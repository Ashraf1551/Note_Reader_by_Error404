package com.m.x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.*;
import android.content.*;
import android.view.*;
import com.google.android.gms.ads.*;


public class AddActivity extends AppCompatActivity {

	private Toolbar toolbar;
    EditText title_input, author_input;
	InterstitialAd iad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        toolbar = findViewById(R.id.mainToolbar1);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("New Note");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        iad=new InterstitialAd(this);
		iad.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

		AdRequest adrequest=new AdRequest.Builder().build();

		iad.loadAd(adrequest);

        title_input = findViewById(R.id.title_input);
        author_input = findViewById(R.id.author_input);
    }

}@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.add_menu, menu);
    return true;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



         //noinspection SimplifiableIfStatement
         if (id == R.id.item) {
            DatabaseHelper myDB = new DatabaseHelper(AddActivity.this);
			myDB.addBook(title_input.getText().toString().trim(),
						 author_input.getText().toString().trim());
			startActivity(new Intent(AddActivity.this, MainActivity.class));
			finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
	protected void onPause()
	{
		// TODO: Implement this method
		super.onPause();
	}
