package com.m.x;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import java.io.InputStream;


public class DebugActivity extends Activity {

	String[] exceptionType = {
			"",
			"",
			"",
			"",
			""

	};

	String[] errMessage= new String[]{"","","","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


