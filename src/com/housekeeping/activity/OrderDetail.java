package com.housekeeping.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.housekeeping.R;
import com.housekeeping.view.MyDialog;
import com.housekeeping.view.MyDialog.MyDialogOnClickListener;

public class OrderDetail extends Basic implements OnClickListener ,MyDialogOnClickListener{
	private Button sure,cancle;
    private MyDialog myDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_detail);
		prepareData();
		initView();
	}

	private void prepareData() {
		myDialog = new MyDialog(this, this);
		myDialog.setStr("温馨提示", "确定保存订单？", "确定", "取消");
	};

	private void initView() {
		sure = (Button) findViewById(R.id.sure);
		cancle = (Button) findViewById(R.id.cancle);
		sure.setOnClickListener(this);
		cancle.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.sure:
			myDialog.show();
			break;
		case R.id.cancle:
			this.finish();
			break;
		default:
			break;
		}
	}

	@Override
	public void yes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void no() {
		// TODO Auto-generated method stub
		
	}
}
