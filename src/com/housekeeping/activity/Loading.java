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
		// 去掉标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.loading);
		// 闪屏核心代码
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Loading.this,
						Login.class);
				// 从启动动画切换到主界面
				startActivity(intent);
				Loading.this.finish();// 结束动画
			}
		}, (long) 1000.02);
	}

}
