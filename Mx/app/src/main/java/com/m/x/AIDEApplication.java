package com.m.x;
import android.app.*;
import java.io.*;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.MobileAds;
public class AIDEApplication extends Application
{
	private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
	@Override
	public void onCreate() {
		MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
		this.uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override