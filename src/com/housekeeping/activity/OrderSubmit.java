package com.housekeeping.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.housekeeping.R;

public class OrderSubmit extends Basic {
	private TextView title;
	private TextView feiyongbiaozhu;
	private String type;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_submit);
		prepareData();
		initView();
	}

	private void prepareData() {

		type = getIntent().getStringExtra("type");
	};

	private void initView() {
		title = (TextView) findViewById(R.id.title);
		feiyongbiaozhu = (TextView) findViewById(R.id.feiyongbiaozhu);
		if (type.equals("1")) {
			title.setText("提交订单");
			feiyongbiaozhu.setText("标准费用¥40.00/h");
		}
		if (type.equals("2")) {
			title.setText("新居开荒");
			feiyongbiaozhu.setText("标准费用¥50.00/h");
		}
	}
}
