package com.housekeeping.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.housekeeping.R;

public class HourlyDetail extends Basic implements OnClickListener {

	private List<String> strs;
	private ListView comment_listview;
	private LayoutInflater layoutInflater;
	private CommentAdapter commentAdapter;
	private TextView call_hourly;
	private RelativeLayout re_workshow_clean, re_workshow_laundry,
			re_workshow_cook;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hourly_detail);
		prepareData();
		initView();
	}

	private void prepareData() {
		strs = new ArrayList<String>();
		for (int i = 0; i < 30; i++) {
			strs.add("a");
		}
		layoutInflater = LayoutInflater.from(this);
		commentAdapter = new CommentAdapter();
	};

	private void initView() {
		comment_listview = (ListView) findViewById(R.id.comment_listview);
		call_hourly = (TextView) findViewById(R.id.call_hourly);
		re_workshow_clean = (RelativeLayout) findViewById(R.id.re_workshow_clean);
		re_workshow_laundry = (RelativeLayout) findViewById(R.id.re_workshow_laundry);
		re_workshow_cook = (RelativeLayout) findViewById(R.id.re_workshow_cook);
		call_hourly.setOnClickListener(this);
		re_workshow_laundry.setOnClickListener(this);
		re_workshow_clean.setOnClickListener(this);
		re_workshow_cook.setOnClickListener(this);
		comment_listview.setAdapter(commentAdapter);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.call_hourly:
//			hourlyDetailIntent.putExtra("type", "1");
			Intent orderIntent = new Intent(this, OrderSubmit.class);
			orderIntent.putExtra("type", "1");
			startActivity(orderIntent);
			break;
		case R.id.re_workshow_clean:
			startActivity(new Intent(this, WorkShow.class));
			break;
		case R.id.re_workshow_laundry:
			startActivity(new Intent(this, WorkShow.class));
			break;
		case R.id.re_workshow_cook:
			startActivity(new Intent(this, WorkShow.class));
			break;	
		default:
			break;
		}
	};

	class CommentAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return strs.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return strs.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View currentView, ViewGroup arg2) {
			// TODO Auto-generated method stub
			if (currentView == null) {
				currentView = layoutInflater.inflate(
						R.layout.hourly_comment_list_item, null);
			}
			return currentView;
		}

	}

}
