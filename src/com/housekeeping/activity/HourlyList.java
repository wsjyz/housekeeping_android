package com.housekeeping.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.housekeeping.R;
import com.housekeeping.view.XListView;
import com.housekeeping.view.XListView.IXListViewListener;
import com.housekeeping.view.XListViewFooter;

public class HourlyList extends Basic implements OnClickListener , IXListViewListener {
	private List<String> strs;
	private XListView hourly_listview;
	private LayoutInflater layoutInflater;
	private HourlyAdapter hourlyAdapter;
	private List<String> list = null;
	private List<String> groupkey = new ArrayList<String>();
	private List<String> aList = new ArrayList<String>();
	private List<String> bList = new ArrayList<String>();
	private LinearLayout li_biaozhun;
	private Handler mHandler;
	private int start = 0;
	private int refreshCnt = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hourly_list);
		prepareData();
		initView();
	}

	private void prepareData() {
		strs = new ArrayList<String>();
		for (int i = 0; i < 30; i++) {
			strs.add("a");
		}

		list = new ArrayList<String>();

		groupkey.add("1km");
		groupkey.add("2km");

		for (int i = 0; i < 5; i++) {
			aList.add("1km" + i);
		}

		list.addAll(aList);
		list.add("1km");
		for (int i = 0; i < 8; i++) {
			bList.add("2km" + i);
		}
		list.addAll(bList);
		list.add("2km");
		layoutInflater = LayoutInflater.from(this);
		hourlyAdapter = new HourlyAdapter();
	};

	private void initView() {
		li_biaozhun = (LinearLayout) findViewById(R.id.li_biaozhun);

		hourly_listview = (XListView) findViewById(R.id.hourly_listview);
		hourly_listview.setPullLoadEnable(true);
		hourly_listview.setAdapter(hourlyAdapter);
		hourly_listview.setXListViewListener(this);
//		hourly_listview.setPullRefreshEnable(false);
		mHandler = new Handler();
//		mListView.startRefresh();
		li_biaozhun.setOnClickListener(this);
		
	}
	private void onLoad() {
		hourly_listview.stopRefresh();
		hourly_listview.stopLoadMore();
		hourly_listview.setRefreshTime("刚刚");
	}
	
	@Override
	public void onRefresh() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				start = ++refreshCnt;
//				items.clear();
//				geneItems();
//				// mAdapter.notifyDataSetChanged();
//				mAdapter = new ArrayAdapter<String>(XListViewActivity.this, R.layout.list_item, items);
//				hourly_listview.setAdapter(mAdapter);
				hourlyAdapter = new HourlyAdapter();
				hourly_listview.setAdapter(hourlyAdapter);
				onLoad();
			}
		}, 2000);
	}

	@Override
	public void onLoadMore() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
//				geneItems();
				hourlyAdapter.notifyDataSetChanged();
				onLoad();
			}
		}, 2000);
	}
	class HourlyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return list.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public boolean isEnabled(int position) {
			// TODO Auto-generated method stub
			if (groupkey.contains(getItem(position))) {
				return false;
			}
			return super.isEnabled(position);
		}

		@Override
		public View getView(int position, View currentView, ViewGroup arg2) {
			// TODO Auto-generated method stub
			View view = currentView;
			if (groupkey.contains(getItem(position))) {
				view = layoutInflater.inflate(R.layout.hourly_list_itema, null);
			} else {
				view = layoutInflater.inflate(R.layout.hourly_list_item, null);
				RatingBar start_ratingbar = (RatingBar) view
						.findViewById(R.id.start_ratingbar);
				start_ratingbar.setRating((float) 3.2);

				view.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent hourlyDetailIntent = new Intent();
						hourlyDetailIntent.setClass(HourlyList.this,
								HourlyDetail.class);

						startActivity(hourlyDetailIntent);
					}
				});
			}
			return view;
		}

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.li_biaozhun:
			
			Intent webLoadIntent = new Intent(this, WebLoad.class);
			webLoadIntent.putExtra("title", "小时工标准费用");
			webLoadIntent.putExtra("url", "file:///android_asset/image/standard_fee_hourly.png");
			startActivity(webLoadIntent);
			break;
		default:
			break;
		}
	}

}
