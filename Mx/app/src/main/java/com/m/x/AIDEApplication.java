package com.m.x;
import android.app.*;
import java.io.*;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.MobileAds;
public class AIDEApplication extends Application
{
	private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;