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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;

import com.housekeeping.R;
import com.housekeeping.activity.HourlyList.HourlyAdapter;
import com.housekeeping.view.XListView;
import com.housekeeping.view.XListView.IXListViewListener;

public class OrderList extends Basic implements OnClickListener,OnItemClickListener, IXListViewListener {
	private List<String> strs;
	private XListView order_listview;
	private LayoutInflater layoutInflater;
	private OrderAdapter orderAdapter;
	private Handler mHandler;
	private int start = 0;
	private int refreshCnt = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 去掉标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.order_list);
		// 闪屏核心代码
		prepareData();
		initView();
	}

	private void prepareData() {
		layoutInflater = LayoutInflater.from(this);
		strs = new ArrayList<String>();
		for (int i = 0; i < 30; i++) {
			strs.add("a");
		}
		orderAdapter = new OrderAdapter();
	};

	private void initView() {
		order_listview = (XListView) findViewById(R.id.order_listview);
		orderAdapter = new OrderAdapter();
		order_listview.setPullLoadEnable(true);
		order_listview.setAdapter(orderAdapter);
		order_listview.setXListViewListener(this);
//		hourly_listview.setPullRefreshEnable(false);
		mHandler = new Handler();
//		mListView.startRefresh();
		order_listview.setOnItemClickListener(this);
	};
	private void onLoad() {
		order_listview.stopRefresh();
		order_listview.stopLoadMore();
		order_listview.setRefreshTime("刚刚");
	}
	class OrderAdapter extends BaseAdapter {

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
		public View getView(int positon, View currentView, ViewGroup arg2) {
			// TODO Auto-generated method stub
			if(currentView==null){
				currentView = layoutInflater.inflate(R.layout.order_item, null);
			}
			return currentView;
		}

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
				orderAdapter = new OrderAdapter();
				order_listview.setAdapter(orderAdapter);
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
				orderAdapter.notifyDataSetChanged();
				onLoad();
			}
		}, 2000);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent orderDetailIntent = new Intent(this, OrderDetail.class);
		startActivity(orderDetailIntent);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}