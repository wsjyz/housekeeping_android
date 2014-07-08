package com.housekeeping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.housekeeping.R;

public class OrderSubmit extends Basic implements OnClickListener {
	private TextView title;
	private TextView feiyongbiaozhu;
	private String type;
    private RelativeLayout re_biaozhun;
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
		re_biaozhun = (RelativeLayout) findViewById(R.id.re_biaozhun);
		if (type.equals("1")) {
			title.setText("提交订单");
			feiyongbiaozhu.setText("标准费用¥40.00/h");
		}
		if (type.equals("2")) {
			title.setText("新居开荒");
			feiyongbiaozhu.setText("标准费用¥50.00/h");
		}
		re_biaozhun.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.re_biaozhun:
			Intent webLoadIntent = new Intent(this, WebLoad.class);
			startActivity(webLoadIntent);
			break;
		default:
			break;
		}
	}
}
