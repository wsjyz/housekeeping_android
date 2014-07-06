package com.housekeeping.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.housekeeping.R;
import com.housekeeping.utils.ScreenUtils;

public class Main extends Basic implements OnClickListener,
		OnCheckedChangeListener {
	/** Called when the activity is first created. */
	private TextView main_tab_new_message;
	private Intent hourlyInforIntent, orderIntent, couponIntent, searchIntent,
			moreIntent;
	private Button hourlylist;
	private int[] location = new int[2];
	private RadioButton tab_myorder;
	private RadioGroup radioGroup;
	private FrameLayout.LayoutParams layoutParams;
	private DisplayMetrics dm;
	private int screenWidth;
	private int screenHeight;
	private ImageView im_vip;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		prepareData();
		initView();

	}

	public void prepareData() {
		hourlyInforIntent = new Intent().setClass(this, UserInfor.class);
		orderIntent = new Intent().setClass(this, MyExam.class);
		couponIntent = new Intent().setClass(this, MyMessage.class);
		searchIntent = new Intent().setClass(this, Setting.class);
		moreIntent = new Intent().setClass(this, More.class);
		dm = ScreenUtils.getDisplayMetrics(this);
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels;
	}

	public void initView() {
		tab_myorder = (RadioButton) findViewById(R.id.tab_myorder);
		im_vip = (ImageView) findViewById(R.id.im_vip);
		main_tab_new_message = (TextView) findViewById(R.id.main_tab_new_message);
		hourlylist = (Button) findViewById(R.id.hourlylist);
		radioGroup = (RadioGroup) this.findViewById(R.id.main_tab_group);
		tab_myorder.getLocationOnScreen(location);
		main_tab_new_message.setVisibility(View.VISIBLE);
		main_tab_new_message.setText("10");
		layoutParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(screenWidth * 2 / 5 - screenWidth * 1 / 15, 3,
				0, 0);
		main_tab_new_message.setLayoutParams(layoutParams);
		hourlylist.setOnClickListener(this);
		im_vip.setOnClickListener(this);
		radioGroup.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("��ȷ���˳���")
					.setCancelable(false)
					.setPositiveButton("ȷ��",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									finish();
									System.exit(0);
								}
							})
					.setNegativeButton("����",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			AlertDialog alert = builder.create();
			alert.show();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.hourlylist:
			Intent hourlyListIntent = new Intent(this, HourlyList.class);
			startActivity(hourlyListIntent);
			break;
		case R.id.im_vip:
			Intent memberListIntent = new Intent(this, MemberList.class);
			startActivity(memberListIntent);
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.tab_person_center:// ��������
			startActivity(hourlyInforIntent);
			break;
		case R.id.tab_myorder:// �ҵĶ���
			startActivity(orderIntent);
			break;
		case R.id.tab_coupon:// �Ż�ȯ
			startActivity(couponIntent);
			break;
		case R.id.tab_search:// ����
			startActivity(searchIntent);
			break;
		case R.id.tab_more:// ����
			startActivity(moreIntent);
			break;
		default:
			break;
		}
	}

}