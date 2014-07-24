package com.housekeeping.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.housekeeping.R;

public class Coupon extends Basic implements OnClickListener {
	private Button scran;
	private TextView scran_text;
	private final static int SCANNIN_GREQUEST_CODE = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coupon);
		prepareData();
		initView();
	}

	private void prepareData() {

	};

	private void initView() {
		scran = (Button) findViewById(R.id.scran);
		scran_text = (TextView) findViewById(R.id.scran_text);
		scran.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.scran:
			Intent intent = new Intent();
			intent.setClass(this, MipcaActivityCapture.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
			break;

		default:
			break;
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case SCANNIN_GREQUEST_CODE:
			if (resultCode == RESULT_OK) {
				Bundle bundle = data.getExtras();
				// 显示扫描到的内容
				scran_text.setText(bundle.getString("result"));
				// 显示
				// mImageView.setImageBitmap((Bitmap)
				// data.getParcelableExtra("bitmap"));
			}
			break;
		}
	}
}
