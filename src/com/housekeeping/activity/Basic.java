package com.housekeeping.activity;

import com.housekeeping.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

public class Basic extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	public void onBackClick(View view) {
		switch (view.getId()) {
		case R.id.textViewBack:
			this.finish();
			break;
		default:
			break;
		}
	}
}
