package com.m.x;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.*;
import android.view.*;
import android.speech.tts.*;
import java.util.*;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.*;


public class ReadActivity extends AppCompatActivity {

    EditText author_input;
    String id, title, author;
	ImageButton speak, stop;
	TextToSpeech tts;
	LinearLayout ll;
	RelativeLayout rl;
	InterstitialAd iad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
		

        Toolbar toolbar = findViewById(R.id.mainToolbar2);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle(title);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		iad=new InterstitialAd(this);
		iad.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

		AdRequest adrequest=new AdRequest.Builder().build();

		iad.loadAd(adrequest);


        rl = findViewById(R.id.rl);
		ll = findViewById(R.id.ll2);
        author_input = findViewById(R.id.author_input2);
		speak = findViewById( R.id.speak);
		stop = findViewById(R.id.stop);
		
		ll.setVisibility(View.INVISIBLE);


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() 
			{
				@Override
				public void onInit(int i) {
					if(i == TextToSpeech.SUCCESS) {
						int lang = tts.setLanguage(Locale.ENGLISH);
					}
				}
			});


             //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }


        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = author_input.getText().toString();
                tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                ll.setVisibility(View.VISIBLE);
                author_input.setEnabled(false);
                speak.setEnabled(false);
            }
        });



        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.stop();
                ll.setVisibility(View.INVISIBLE);
                author_input.setEnabled(true);
                speak.setEnabled(true);
            }
        });

}


void getAndSetIntentData(){
    if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
       getIntent().hasExtra("author")){

         //Getting Data from Intent
         id = getIntent().getStringExtra("id");
         title = getIntent().getStringExtra("title");
         author = getIntent().getStringExtra("author");


         //Setting Intent Data
         author_input.setText(author);
         Log.d("stev", title+" "+author+" ");
     }else{
         Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
     }
 }

 void confirmDialog(){
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Delete " + title + " ?");
    builder.setMessage("Are you sure you want to delete " + title + " ?");
    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {


        @Override
				public void onClick(DialogInterface dialogInterface, int i) {
					DatabaseHelper myDB = new DatabaseHelper(ReadActivity.this);
					myDB.deleteOneRow(id);
					finish();
				}
			});


            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {

				}
			});
        builder.create().show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.update_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int i = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (i == R.id.update) {
			if(iad.isLoaded()) {
				iad.show();
			}
