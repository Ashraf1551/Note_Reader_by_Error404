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


		Intent intent = getIntent();
		String errMsg = "";
		String madeErrMsg = "";
		if(intent != null){
			errMsg = intent.getStringExtra("error");

			String[] spilt = errMsg.split("\n");
			//errMsg = spilt[0];
			try {
				for (int j = 0; j < exceptionType.length; j++) {
					if (spilt[0].contains(exceptionType[j])) {
						madeErrMsg = errMessage[j];

						int addIndex = spilt[0].indexOf(exceptionType[j]) + exceptionType[j].length();

						madeErrMsg += spilt[0].substring(addIndex, spilt[0].length());
						break;

					}
				}
