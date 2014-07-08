package com.housekeeping.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.housekeeping.R;
import com.housekeeping.utils.ScreenUtils;
import com.housekeeping.view.MyDialog;
import com.housekeeping.view.MyDialog.MyDialogOnClickListener;

public class Main extends Basic implements OnClickListener,
		OnCheckedChangeListener, MyDialogOnClickListener {
	/** Called when the activity is first created. */
	private TextView main_tab_new_message;
	private Intent hourlyInforIntent, orderIntent, couponIntent, searchIntent,
			moreIntent;
	private Button hourlylist, xinju,bt_want;
	private int[] location = new int[2];
	private RadioButton tab_myorder;
	private RadioGroup radioGroup;
	private FrameLayout.LayoutParams layoutParams;
	private DisplayMetrics dm;
	private int screenWidth;
	private int screenHeight;
	private ImageView im_vip;
	private MyDialog myDialog;
	private ImageView img_phone;
	private Button dialog_yes, dialog_no;
	private TextView dialog_text, dialog_title;
	private PopupWindow pop_zhouqi, pop_zhouqi_list;
    private View view_zhouqi,vie_zhouqi_list;
    private LayoutInflater inflater;
    private LinearLayout parent;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		prepareData();
		initView();
		initPop();
	}

	public void prepareData() {
		inflater = LayoutInflater.from(this);
		view_zhouqi = inflater.inflate(R.layout.pop_zhouqi, null);
		vie_zhouqi_list = inflater.inflate(R.layout.pop_zhouqi_list, null);
		hourlyInforIntent = new Intent().setClass(this, UserInfor.class);
		orderIntent = new Intent().setClass(this, OrderList.class);
		couponIntent = new Intent().setClass(this, Coupon.class);
		searchIntent = new Intent().setClass(this, Search.class);
		moreIntent = new Intent().setClass(this, More.class);
		dm = ScreenUtils.getDisplayMetrics(this);
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels;
		myDialog = new MyDialog(this, this);
		myDialog.setStr("请拨打服务热线：", "400-100-56688", "拨打", "重播");
	}

	public void initView() {
		parent = (LinearLayout) findViewById(R.id.parent);
		tab_myorder = (RadioButton) findViewById(R.id.tab_myorder);
		xinju = (Button) findViewById(R.id.xinju);
		bt_want = (Button) findViewById(R.id.bt_want);
		im_vip = (ImageView) findViewById(R.id.im_vip);
		main_tab_new_message = (TextView) findViewById(R.id.main_tab_new_message);
		hourlylist = (Button) findViewById(R.id.hourlylist);
		img_phone = (ImageView) findViewById(R.id.img_phone);
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
		xinju.setOnClickListener(this);
		img_phone.setOnClickListener(this);
		bt_want.setOnClickListener(this);
	}
    public void initPop(){
    	view_zhouqi.getBackground().setAlpha(75);
    	pop_zhouqi = new PopupWindow(view_zhouqi,
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
    	pop_zhouqi.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
    	pop_zhouqi.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
    	pop_zhouqi.setFocusable(true);
    	
    	pop_zhouqi_list = new PopupWindow(vie_zhouqi_list,
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
    	pop_zhouqi_list.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
    	pop_zhouqi_list.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
    	pop_zhouqi_list.setFocusable(true);
    }
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("你确定退出吗？")
					.setCancelable(false)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									finish();
									System.exit(0);
								}
							})
					.setNegativeButton("返回",
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
		case R.id.xinju:
			Intent orderIntent = new Intent(this, OrderSubmit.class);
			orderIntent.putExtra("type", "2");
			startActivity(orderIntent);
			break;
		case R.id.img_phone:
			myDialog.show();
			break;
		case R.id.bt_want:
			showPop(pop_zhouqi);
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.tab_person_center:// 个人中心
			startActivity(hourlyInforIntent);
			break;
		case R.id.tab_myorder:// 我的订单
			startActivity(orderIntent);
			break;
		case R.id.tab_coupon:// 优惠券
			startActivity(couponIntent);
			break;
		case R.id.tab_search:// 搜索
			startActivity(searchIntent);
			break;
		case R.id.tab_more:// 更多
			startActivity(moreIntent);
			break;
		default:
			break;
		}
	}

	@Override
	public void yes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void no() {
		// TODO Auto-generated method stub

	}
	public void showPop(PopupWindow pop) {
		if (pop != null) {
			System.out.println("doit..........");
			pop.showAtLocation(parent, Gravity.CENTER, 0, 0);
		}
	}

	public void closePop(PopupWindow pop) {
		if (pop != null && pop.isShowing()) {
			// 隐藏窗口，如果设置了点击窗口外小时即不需要此方式隐藏
			pop.dismiss();
		}
	}
}