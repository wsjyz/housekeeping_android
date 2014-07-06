package com.housekeeping.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.housekeeping.R;
import com.housekeeping.view.MyDialog;
import com.housekeeping.view.MyDialog.MyDialogOnClickListener;

public class OrderDetail extends Basic implements OnClickListener ,MyDialogOnClickListener{
	private Button sure;
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
		
	};

	private void initView() {
		sure = (Button) findViewById(R.id.sure);
		sure.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.sure:
			myDialog.show();
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
