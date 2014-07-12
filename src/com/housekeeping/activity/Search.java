package com.housekeeping.activity;

import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;

import com.housekeeping.R;
import com.housekeeping.view.KeywordsFlow;

public class Search extends Basic implements OnClickListener,
		OnCheckedChangeListener {
	public static final String[] keywords = { "保姆", "月嫂", "小时工", "留洋",
			"英语",//
			"勤快" };
	private KeywordsFlow keywordsFlow;
	private Button next;
	private RadioGroup main_tab_group;
	private RadioButton tab_search_jinque, tab_search_ci;
	private LinearLayout li_search_jinque;
	private RelativeLayout re_search_ci;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		prepareData();
		initView();
	}

	private void prepareData() {

	};

	private void initView() {
		next = (Button) findViewById(R.id.next);
		main_tab_group = (RadioGroup) findViewById(R.id.main_tab_group);
		tab_search_jinque = (RadioButton) findViewById(R.id.tab_search_jinque);
		tab_search_ci = (RadioButton) findViewById(R.id.tab_search_ci);
		keywordsFlow = (KeywordsFlow) findViewById(R.id.keywordsflow);
		li_search_jinque = (LinearLayout) findViewById(R.id.li_search_jinque);
		re_search_ci = (RelativeLayout) findViewById(R.id.re_search_ci);
		keywordsFlow.setDuration(800l);
		keywordsFlow.setOnItemClickListener(this);
//		li_search_jinque.setOnClickListener(this);
//		re_search_ci.setOnClickListener(this);
		next.setOnClickListener(this);
		li_search_jinque.setVisibility(View.VISIBLE);
		re_search_ci.setVisibility(View.GONE);
		// 添加
		feedKeywordsFlow(keywordsFlow, keywords);
		keywordsFlow.go2Show(KeywordsFlow.ANIMATION_IN);
		main_tab_group.setOnCheckedChangeListener(this);
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
}
