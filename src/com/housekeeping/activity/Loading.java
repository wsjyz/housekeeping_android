package com.housekeeping.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.housekeeping.R;

public class Loading extends Basic {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ȥ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.loading);
		// �������Ĵ���
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Loading.this,
						Login.class);
				// �����������л���������
				startActivity(intent);
				Loading.this.finish();// ��������
			}
		}, (long) 1000.02);
	}

}
