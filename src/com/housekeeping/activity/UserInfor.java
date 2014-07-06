package com.housekeeping.activity;

import com.housekeeping.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class UserInfor extends Basic implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.user_infor);
		prepareData();
		initView();
	}

	public void prepareData() {
	};

	public void initView() {
	};

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub

	}

}
