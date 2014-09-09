package com.example.androidtests;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class WakeLockTest extends Activity {
	WakeLock wakeLock;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wake_lock_test);
		PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = powerManager.newWakeLock(
				PowerManager.FULL_WAKE_LOCK, "My Lock");
	}

	protected void onResume() {
		wakeLock.acquire();
	}

	protected void onPause() {
		wakeLock.release();
	}
}
