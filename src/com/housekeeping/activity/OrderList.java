package com.housekeeping.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.housekeeping.R;

public class OrderList extends Basic implements OnClickListener,OnItemClickListener{
	private List<String> strs;
	private ListView order_listview;
	private LayoutInflater layoutInflater;
	private OrderAdapter orderAdapter;

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
		order_listview = (ListView) findViewById(R.id.order_listview);
		orderAdapter = new OrderAdapter();
		order_listview.setAdapter(orderAdapter);
		order_listview.setOnItemClickListener(this);
	};

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