package com.housekeeping.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.TextView;

import com.housekeeping.R;

public class WebLoad extends Basic implements OnClickListener {
	private String title,url;
	private TextView title_text;
	private WebView webview;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);
		prepareData();
		initView();
	}

	private void prepareData() {
		title= getIntent().getStringExtra("title");
		url = getIntent().getStringExtra("url");
	};

	private void initView() {
		title_text = (TextView) findViewById(R.id.title_text);
		webview = (WebView) findViewById(R.id.webview);
	    if(!TextUtils.isEmpty(title)){
	    	title_text.setText(title);
	    }
	    if(!TextUtils.isEmpty(url)){
	    	webview.loadUrl(url);
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
