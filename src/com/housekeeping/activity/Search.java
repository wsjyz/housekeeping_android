package com.housekeeping.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.housekeeping.R;
import com.housekeeping.view.KeywordsFlow;

public class Search extends Basic implements OnClickListener,
		OnCheckedChangeListener, OnItemClickListener {
	public static final String[] keywords = { "保姆", "月嫂", "小时工", "留洋", "英语",//
			"勤快" };
	private KeywordsFlow keywordsFlow;
	private Button next;
	private RadioGroup main_tab_group;
	private RadioButton tab_search_jinque, tab_search_ci;
	private LinearLayout li_search_jinque;
	private RelativeLayout re_search_ci;
	private List<String> conList, businessList, bloodList;
	private RelativeLayout re_business, re_con, re_blood;
	private PopupWindow pop_type;
	private View view_type;
	private LayoutInflater inflater;
	private ListView pop_listview;
	private LinearLayout parent;
	private SearchTypeAdapter searchTypeAdapter;
	private int type = -1;
	private TextView text_business, text_con, text_blood;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		prepareData();
		initView();
	}

	private void prepareData() {
		inflater = LayoutInflater.from(this);
		conList = new ArrayList<String>();
		businessList = new ArrayList<String>();
		bloodList = new ArrayList<String>();
		conList.add("不限");
		conList.add("白羊座");
		conList.add("金牛座");
		conList.add("双子座");
		conList.add("巨蟹座");
		conList.add("狮子座");
		conList.add("处女座");
		conList.add("天秤座");
		conList.add("天蝎座");
		conList.add("射手座");
		conList.add("摩羯座");
		conList.add("水瓶座");
		conList.add("双鱼座");

		bloodList.add("不限");
		bloodList.add("O型");
		bloodList.add("A型");
		bloodList.add("B型");
		bloodList.add("AB型");

	};

	private void initView() {
		view_type = inflater.inflate(R.layout.pop_list, null);
		parent = (LinearLayout) findViewById(R.id.parent);
		pop_listview = (ListView) view_type.findViewById(R.id.pop_listview);
		next = (Button) findViewById(R.id.next);
		main_tab_group = (RadioGroup) findViewById(R.id.main_tab_group);
		tab_search_jinque = (RadioButton) findViewById(R.id.tab_search_jinque);
		tab_search_ci = (RadioButton) findViewById(R.id.tab_search_ci);
		keywordsFlow = (KeywordsFlow) findViewById(R.id.keywordsflow);
		li_search_jinque = (LinearLayout) findViewById(R.id.li_search_jinque);
		re_search_ci = (RelativeLayout) findViewById(R.id.re_search_ci);

		re_business = (RelativeLayout) findViewById(R.id.re_business);
		re_con = (RelativeLayout) findViewById(R.id.re_con);
		re_blood = (RelativeLayout) findViewById(R.id.re_blood);
		text_business = (TextView) findViewById(R.id.text_business);
		text_con = (TextView) findViewById(R.id.text_con);
		text_blood = (TextView) findViewById(R.id.text_blood);
		keywordsFlow.setDuration(800l);
		keywordsFlow.setOnItemClickListener(this);
		// li_search_jinque.setOnClickListener(this);
		// re_search_ci.setOnClickListener(this);
		next.setOnClickListener(this);
		li_search_jinque.setVisibility(View.VISIBLE);
		re_search_ci.setVisibility(View.GONE);
		// 添加
		feedKeywordsFlow(keywordsFlow, keywords);
		keywordsFlow.go2Show(KeywordsFlow.ANIMATION_IN);
		main_tab_group.setOnCheckedChangeListener(this);
		pop_listview.setOnItemClickListener(this);
		re_business.setOnClickListener(this);
		re_con.setOnClickListener(this);
		re_blood.setOnClickListener(this);
		initPop();
	}

	private void initPop() {
		view_type.getBackground().setAlpha(75);
		pop_type = new PopupWindow(view_type, LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
		pop_type.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
		pop_type.setOutsideTouchable(false);
		// 设置此参数获得焦点，否则无法点击
		pop_type.setFocusable(true);
	};

	public void showPop(PopupWindow pop) {
		if (pop != null) {
			pop.showAtLocation(parent, Gravity.CENTER, 0, 0);
		}
	}

	public void closePop(PopupWindow pop) {
		if (pop != null && pop.isShowing()) {
			// 隐藏窗口，如果设置了点击窗口外小时即不需要此方式隐藏
			pop.dismiss();
		}
	}

	private void feedKeywordsFlow(KeywordsFlow keywordsFlow, String[] arr) {
		Random random = new Random();
		for (int i = 0; i < KeywordsFlow.MAX; i++) {
			int ran = random.nextInt(arr.length);
			String tmp = arr[ran];
			keywordsFlow.feedKeyword(tmp);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long positiona) {
		// TODO Auto-generated method stub

		switch (type) {
		// text_business,text_con,text_blood;
		case 0:

			break;
		case 1:
			text_con.setText(conList.get(position));
			break;
		case 2:
			text_blood.setText(bloodList.get(position));
			break;
		default:
			break;
		}
		closePop(pop_type);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.next:
			keywordsFlow.rubKeywords();
			// keywordsFlow.rubAllViews();
			feedKeywordsFlow(keywordsFlow, keywords);
			keywordsFlow.go2Show(KeywordsFlow.ANIMATION_IN);
			break;
		case R.id.li_search_jinque:
			break;
		case R.id.re_search_ci:
			break;
		case R.id.re_business:
			type = 0;
			break;
		case R.id.re_con:
			searchTypeAdapter = new SearchTypeAdapter(this, conList);
			pop_listview.setAdapter(searchTypeAdapter);
			type = 1;
			showPop(pop_type);
			break;
		case R.id.re_blood:
			searchTypeAdapter = new SearchTypeAdapter(this, bloodList);
			pop_listview.setAdapter(searchTypeAdapter);
			type = 2;
			showPop(pop_type);
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup radioGroup, int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case R.id.tab_search_jinque:
			li_search_jinque.setVisibility(View.VISIBLE);
			re_search_ci.setVisibility(View.GONE);
			break;
		case R.id.tab_search_ci:
			li_search_jinque.setVisibility(View.GONE);
			re_search_ci.setVisibility(View.VISIBLE);
			break;

		default:
			break;
		}
	};

	class SearchTypeAdapter extends BaseAdapter {
		private Context context;
		private LayoutInflater layoutInflater;
		private List<String> strs;

		public SearchTypeAdapter(Context context, List<String> strs) {
			// TODO Auto-generated constructor stub
			this.context = context;
			this.strs = strs;
			layoutInflater = layoutInflater.from(context);
		}

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
			currentView = layoutInflater.inflate(
					R.layout.search_type_list_item, null);
			RadioButton radioMale = (RadioButton) currentView
					.findViewById(R.id.radioMale);
			radioMale.setText(strs.get(position));
			return currentView;
		}
	}

}
