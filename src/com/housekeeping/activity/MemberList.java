package com.housekeeping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.housekeeping.R;

public class MemberList extends Basic implements OnClickListener {

	private LinearLayout re_gold, re_platinumcard, re_masonrycard;
	private Intent memberIntent;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_list);
		prepareData();
		initView();
	}

	public void prepareData() {
		memberIntent = new Intent(this, MemberInfor.class);
	};

	public void initView() {
		re_gold = (LinearLayout) findViewById(R.id.re_gold);
		re_platinumcard = (LinearLayout) findViewById(R.id.re_platinumcard);
		re_masonrycard = (LinearLayout) findViewById(R.id.re_masonrycard);
		re_gold.setOnClickListener(this);
		re_masonrycard.setOnClickListener(this);
		re_platinumcard.setOnClickListener(this);
	};

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.re_gold:
			memberIntent.putExtra("mCurSel", 0);
			startActivity(memberIntent);
			break;
		case R.id.re_platinumcard:
			memberIntent.putExtra("mCurSel", 1);
			startActivity(memberIntent);
			break;
		case R.id.re_masonrycard:
			memberIntent.putExtra("mCurSel", 2);
			startActivity(memberIntent);
			break;
		default:
			break;
		}
	}
}