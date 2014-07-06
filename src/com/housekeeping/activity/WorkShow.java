package com.housekeeping.activity;

import com.housekeeping.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class WorkShow extends Basic implements OnClickListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.work_show);
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
