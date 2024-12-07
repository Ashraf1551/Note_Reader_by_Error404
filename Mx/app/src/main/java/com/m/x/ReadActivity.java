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
