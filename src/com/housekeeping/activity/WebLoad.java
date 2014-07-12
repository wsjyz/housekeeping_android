package com.housekeeping.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.housekeeping.R;

public class WebLoad extends Basic implements OnClickListener {
	private String title;
	private TextView title_text;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);
		prepareData();
		initView();
	}

	private void prepareData() {
		title= getIntent().getStringExtra("title");
	};

	private void initView() {
		title_text = (TextView) findViewById(R.id.title_text);
	    if(!TextUtils.isEmpty(title)){
	    	title_text.setText(title);
	    }
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
