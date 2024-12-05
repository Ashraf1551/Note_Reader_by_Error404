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