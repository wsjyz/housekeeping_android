package com.housekeeping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.housekeeping.R;
import com.housekeeping.view.OnViewChangeListener;
import com.housekeeping.view.SwitchLayout;

public class Switch extends Basic implements OnClickListener {
	/** Called when the activity is first created. */
	private SwitchLayout switchLayout;// 自定义的控件
	private LinearLayout linearLayout;
	private int mViewCount;// 自定义控件中子控件的个数
	private ImageView mImageView[];// 底部的imageView
	private int mCurSel;// 当前选中的imageView
	private Button clock_me;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.indexswitch);
		init();
	}

	private void init() {
		switchLayout = (SwitchLayout) findViewById(R.id.switchLayoutID);
		linearLayout = (LinearLayout) findViewById(R.id.linerLayoutID);
		clock_me = (Button) findViewById(R.id.clock_me);
		// 得到子控件的个数
		mViewCount = switchLayout.getChildCount();
		mImageView = new ImageView[mViewCount];
		// 设置imageView
		for (int i = 0; i < mViewCount; i++) {
			// 得到LinearLayout中的子控件
			mImageView[i] = (ImageView) linearLayout.getChildAt(i);
			mImageView[i].setEnabled(true);// 控件激活
			mImageView[i].setOnClickListener(new MOnClickListener());
			mImageView[i].setTag(i);// 设置与view相关的标签
		}
		// 设置第一个imageView不被激活
		mCurSel = 0;
		mImageView[mCurSel].setEnabled(false);
		switchLayout.setOnViewChangeListener(new MOnViewChangeListener());
		clock_me.setOnClickListener(this);
	}

	// 点击事件的监听器
	private class MOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			int pos = (Integer) v.getTag();
			// 设置当前显示的ImageView
			setCurPoint(pos);
			// 设置自定义控件中的哪个子控件展示在当前屏幕中
			switchLayout.snapToScreen(pos);
		}
	}

	/**
	 * 设置当前显示的ImageView
	 * 
	 * @param pos
	 */
	private void setCurPoint(int pos) {
		if (pos < 0 || pos > mViewCount - 1 || mCurSel == pos)
			return;
		// 当前的imgaeView将可以被激活
		mImageView[mCurSel].setEnabled(true);
		// 将要跳转过去的那个imageView变成不可激活
		mImageView[pos].setEnabled(false);
		mCurSel = pos;
	}

	// 自定义控件中View改变的事件监听
	private class MOnViewChangeListener implements OnViewChangeListener {
		@Override
		public void onViewChange(int view) {
			if (view < 0 || mCurSel == view) {
				return;
			} else if (view > mViewCount - 1) {
				// 当滚动到第五个的时候activity会被关闭
				finish();
			}
			setCurPoint(view);
		}

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.clock_me:
			Intent intent = new Intent();
			intent.setClass(Switch.this,
					com.housekeeping.activity.Loading.class);
			startActivity(intent);
			this.finish();
			break;
		default:
			break;
		}
	}

}