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
