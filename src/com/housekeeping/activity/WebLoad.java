package com.housekeeping.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.housekeeping.R;

public class WebLoad extends Basic implements OnClickListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);
		prepareData();
		initView();
	}

	private void prepareData() {

	};

	private void initView() {

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		// case R.id.:
		//
		// break;

		default:
			break;
		}
	};
}
