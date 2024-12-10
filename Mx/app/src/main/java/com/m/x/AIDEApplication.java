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
			public void onCreate() {
				MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
				this.uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
		
				Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
					@Override
					public void uncaughtException(Thread thread, Throwable ex) {
						Intent intent = new Intent(getApplicationContext(), DebugActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		
						intent.putExtra("error", getStackTrace(ex));
		
						PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 11111, intent, PendingIntent.FLAG_ONE_SHOT);
		
		
						AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
						am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 1000, pendingIntent);
		
						android.os.Process.killProcess(android.os.Process.myPid());
						System.exit(2);
		
						uncaughtExceptionHandler.uncaughtException(thread, ex);
					}
				});
				super.onCreate();
		
			}