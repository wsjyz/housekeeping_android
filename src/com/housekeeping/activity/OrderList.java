package com.housekeeping.activity;

import android.os.Bundle;
import android.view.Window;

import com.housekeeping.R;

public class OrderList extends Basic {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ȥ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.order_list);
		// �������Ĵ���
		prepareData();
		initView();
	}
	private void prepareData(){
		
	};
	private void initView(){
		
	};

}