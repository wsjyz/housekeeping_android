package com.housekeeping.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.housekeeping.R;

public class More extends Basic implements OnClickListener {
	private PopupWindow authorSendPop;
	// 引入窗口配置文件
	private LayoutInflater inflater;
	private LinearLayout parent;
	private RelativeLayout re_more_share, re_more_infor, re_more_delete,
			re_more_refresh, re_more_idea, re_more_relation, re_more_star;
	private View view_more_share, view_more_infor, view_more_delete,
			view_more_refresh, view_more_idea, view_more_relation,
			view_more_star;
	private PopupWindow pop_more_share, pop_more_infor, pop_more_delete,
			pop_more_refresh, pop_more_idea, pop_more_relation, pop_more_star;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.more);
		prepareData();
		initView();
	}

	public void prepareData() {
		inflater = LayoutInflater.from(this);
		// authorSendView = inflater.inflate(R.layout.author_send, null);
		// authorSendPop = new PopupWindow(authorSendView,
		// LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);

	};

	public void initView() {
		parent = (LinearLayout) findViewById(R.id.parent);
		re_more_share = (RelativeLayout) findViewById(R.id.re_more_share);
		re_more_infor = (RelativeLayout) findViewById(R.id.re_more_infor);
		re_more_delete = (RelativeLayout) findViewById(R.id.re_more_delete);
		re_more_refresh = (RelativeLayout) findViewById(R.id.re_more_refresh);
		re_more_idea = (RelativeLayout) findViewById(R.id.re_more_idea);
		re_more_relation = (RelativeLayout) findViewById(R.id.re_more_relation);
		re_more_star = (RelativeLayout) findViewById(R.id.re_more_star);

		view_more_share = inflater.inflate(R.layout.pop_more_share, null);
		// pop_more_share = new PopupWindow(view_more_share,
		// LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		view_more_delete = inflater.inflate(R.layout.pop_more_delete, null);
		// pop_more_delete = new PopupWindow(view_more_delete,
		// LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		view_more_refresh = inflater.inflate(R.layout.pop_more_refresh, null);
		// pop_more_delete = new PopupWindow(view_more_delete,
		// LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);

		view_more_idea = inflater.inflate(R.layout.pop_more_idea, null);
		// pop_more_idea = new PopupWindow(view_more_idea,
		// LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);

		view_more_star = inflater.inflate(R.layout.pop_more_about, null);
		// pop_more_star = new PopupWindow(view_more_star,
		// LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		// initPop(view_more_share,pop_more_share);
		// initPop(view_more_delete,pop_more_delete);
		// initPop(view_more_refresh,pop_more_refresh);
		// initPop(view_more_idea,pop_more_idea);
		// initPop(view_more_star,pop_more_star);
		initPop();
		re_more_star.setOnClickListener(this);
		re_more_infor.setOnClickListener(this);
		re_more_delete.setOnClickListener(this);
		re_more_refresh.setOnClickListener(this);
		re_more_idea.setOnClickListener(this);
		re_more_relation.setOnClickListener(this);
		re_more_share.setOnClickListener(this);
	};

	public void initPop() {
		view_more_share.getBackground().setAlpha(75);
		view_more_delete.getBackground().setAlpha(75);
		view_more_refresh.getBackground().setAlpha(75);
		view_more_idea.getBackground().setAlpha(75);
		view_more_star.getBackground().setAlpha(75);
		pop_more_share = new PopupWindow(view_more_share,
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
		pop_more_share.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
		pop_more_share.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
		pop_more_share.setFocusable(true);
		pop_more_delete = new PopupWindow(view_more_delete,
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
		pop_more_delete.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
		pop_more_delete.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
		pop_more_delete.setFocusable(true);

		pop_more_refresh = new PopupWindow(view_more_refresh,
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
		pop_more_refresh.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
		pop_more_refresh.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
		pop_more_refresh.setFocusable(true);

		pop_more_idea = new PopupWindow(view_more_idea,
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
		pop_more_idea.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
		// pop_more_idea.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
		pop_more_idea.setFocusable(true);

		pop_more_star = new PopupWindow(view_more_star,
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
		pop_more_star.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
		pop_more_star.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
		pop_more_star.setFocusable(true);

		

	}

	public void initPop(View view, PopupWindow pop) {

		pop = new PopupWindow(view, LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
		pop.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
		pop.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
		pop.setFocusable(true);

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {

		case R.id.re_more_share:
			showPop(pop_more_share);
			break;
		case R.id.re_more_infor:
			break;
		case R.id.re_more_delete:
			showPop(pop_more_delete);
			break;
		case R.id.re_more_refresh:
			showPop(pop_more_refresh);
			break;
		case R.id.re_more_idea:
			showPop(pop_more_idea);
			break;
		case R.id.re_more_relation:
			break;
		case R.id.re_more_star:
			showPop(pop_more_star);
			break;
		default:
			break;
		}
	}

	public void showPop(PopupWindow pop) {
		if (pop != null) {
			System.out.println("doit..........");
			pop.showAtLocation(re_more_share, Gravity.CENTER, 0, 0);
		}
	}

	public void closePop(PopupWindow pop) {
		if (pop != null && pop.isShowing()) {
			// 隐藏窗口，如果设置了点击窗口外小时即不需要此方式隐藏
			pop.dismiss();
		}
	}

}