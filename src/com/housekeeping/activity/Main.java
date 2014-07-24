package com.housekeeping.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.housekeeping.R;
import com.housekeeping.utils.ScreenUtils;
import com.housekeeping.view.MyDialog;
import com.housekeeping.view.MyPopDialog;
import com.housekeeping.view.MyDialog.MyDialogOnClickListener;

public class Main extends Basic implements OnClickListener,
		OnCheckedChangeListener, MyDialogOnClickListener {
	/** Called when the activity is first created. */
	private TextView main_tab_new_message;
	private Intent hourlyInforIntent, orderIntent, couponIntent, searchIntent,
			moreIntent;
	private Button hourlylist, xinju, bt_want,more_want;
	private int[] location = new int[2];
	private RadioGroup radioGroup;
	private FrameLayout.LayoutParams layoutParams;
	private DisplayMetrics dm;
	private int screenWidth;
	private int screenHeight;
	private ImageView im_vip;
	private MyDialog myDialog;
	private ImageView img_phone;
	private Button dialog_yes, dialog_no, hourly_common,service_idea;
	private TextView dialog_text, dialog_title;
	private PopupWindow pop_zhouqi, pop_main_bottom;
	private View view_zhouqi, vie_main_bottom;
	private LayoutInflater inflater;
	private LinearLayout parent;
	private List<String> days;
	private ListView pop_listview;
	private ZhouqiAdapter zhouqiAdapter;
	private TextView tv_value,pop_title;
	private LinearLayout topre;
	private GridView grid_main_bottom;
	private List<String> hourlys;
	private HourlyAdapter hourlyAdapter;
	private ImageView main_next;
	private int flag;
	private View view_pop;
	private PopupWindow pop_pop;
	private RelativeLayout pop_zhouqi_parent;
	 private MyPopDialog myPopDialog;
	 private RadioButton tab_person_center,tab_myorder,
	 tab_coupon,tab_search,tab_more;
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
		days = new ArrayList<String>();
		hourlys = new ArrayList<String>();
		for (int i = 1; i < 7; i++) {
			days.add("" + i);
		}
		days.add("其他" );
		for (int i = 1; i < 8; i++) {
			hourlys.add("");
		}
		zhouqiAdapter = new ZhouqiAdapter();
		hourlyAdapter = new HourlyAdapter();
		inflater = LayoutInflater.from(this);
		view_zhouqi = inflater.inflate(R.layout.pop_zhouqi, null);
		vie_main_bottom = inflater.inflate(R.layout.main_bottom, null);
		hourlyInforIntent = new Intent().setClass(this, UserInfor.class);
		orderIntent = new Intent().setClass(this, OrderList.class);
		couponIntent = new Intent().setClass(this, Coupon.class);
		searchIntent = new Intent().setClass(this, Search.class);
		moreIntent = new Intent().setClass(this, More.class);
		dm = ScreenUtils.getDisplayMetrics(this);
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels;

	}

	public void initView() {
		view_pop = inflater.inflate(R.layout.pop_more_delete, null);
		pop_listview = (ListView) view_zhouqi.findViewById(R.id.pop_listview);
		pop_zhouqi_parent = (RelativeLayout) view_zhouqi.findViewById(R.id.pop_zhouqi_parent);
		main_next = (ImageView) vie_main_bottom.findViewById(R.id.main_next);
		topre = (LinearLayout) findViewById(R.id.topre);
		parent = (LinearLayout) findViewById(R.id.parent);
		tab_myorder = (RadioButton) findViewById(R.id.tab_myorder);
		xinju = (Button) findViewById(R.id.xinju);
		service_idea = (Button) findViewById(R.id.service_idea);
		bt_want = (Button) findViewById(R.id.bt_want);
		im_vip = (ImageView) findViewById(R.id.im_vip);
		hourly_common = (Button) findViewById(R.id.hourly_common);
		main_tab_new_message = (TextView) findViewById(R.id.main_tab_new_message);
		hourlylist = (Button) findViewById(R.id.hourlylist);
		img_phone = (ImageView) findViewById(R.id.img_phone);
		radioGroup = (RadioGroup) this.findViewById(R.id.main_tab_group);
		tv_value = (TextView) view_zhouqi.findViewById(R.id.tv_value);
		grid_main_bottom = (GridView) vie_main_bottom
				.findViewById(R.id.bottom_gridview);
		pop_title = (TextView) view_pop.findViewById(R.id.pop_title);

		tab_person_center = (RadioButton) findViewById(R.id.tab_person_center);
		tab_myorder = (RadioButton) findViewById(R.id.tab_myorder);
		tab_coupon = (RadioButton) findViewById(R.id.tab_coupon);
		tab_search = (RadioButton) findViewById(R.id.tab_search);
		tab_more = (RadioButton) findViewById(R.id.tab_more);
		more_want = (Button) findViewById(R.id.more_want);
		tab_myorder.getLocationOnScreen(location);
		main_tab_new_message.setVisibility(View.VISIBLE);
		main_tab_new_message.setText("10");
		layoutParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(screenWidth * 2 / 5 - screenWidth * 1 / 15, 3,
				0, 0);
		main_tab_new_message.setLayoutParams(layoutParams);
		pop_listview.setAdapter(zhouqiAdapter);
		grid_main_bottom.setAdapter(hourlyAdapter);
		hourlylist.setOnClickListener(this);
		im_vip.setOnClickListener(this);
		radioGroup.setOnCheckedChangeListener(this);
		xinju.setOnClickListener(this);
		img_phone.setOnClickListener(this);
		bt_want.setOnClickListener(this);
		tv_value.setOnClickListener(this);
		main_next.setOnClickListener(this);
		hourly_common.setOnClickListener(this);
		more_want.setOnClickListener(this);
		service_idea.setOnClickListener(this);
		pop_zhouqi_parent.setOnClickListener(this);

		tab_person_center.setOnClickListener(this);
		tab_myorder.setOnClickListener(this);
		tab_coupon.setOnClickListener(this);
		tab_search.setOnClickListener(this);
		tab_more.setOnClickListener(this);
		pop_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long position) {
				// TODO Auto-generated method stu
				tv_value.setText(position+"天");
				pop_listview.setVisibility(View.GONE);
			}

		});
	}

	public void initPop() {
		view_zhouqi.getBackground().setAlpha(75);
		pop_zhouqi = new PopupWindow(view_zhouqi, LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
		pop_zhouqi.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
		pop_zhouqi.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
		pop_zhouqi.setFocusable(true);
		pop_main_bottom = new PopupWindow(vie_main_bottom,
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, false);
		// 需要设置一下此参数，点击外边可消失
		pop_main_bottom.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
		pop_main_bottom.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
		pop_main_bottom.setFocusable(true);
		
		
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			flag = 2;
			myDialog = new MyDialog(this, this);
			myDialog.setStr("温馨提示", "你确定退出吗？", "确定", "取消");
			myDialog.show();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
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
		case R.id.pop_zhouqi_parent:
			closePop(pop_zhouqi);
			break;
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
			flag = 1;
			myDialog = new MyDialog(this, this);
			myDialog.setStr("请拨打服务热线：", "400-100-56688", "拨打", "重播");
			myDialog.show();
			break;
		case R.id.bt_want:
			showPop(pop_zhouqi);
			break;
		case R.id.tv_value:
			// showPop(pop_zhouqi_list);
			// if (pop_zhouqi_list != null) {
			// pop_zhouqi_list.showAsDropDown(tv_value);
			// }
			pop_listview.setVisibility(View.VISIBLE);
			break;
		case R.id.hourly_common:
			// showPop(pop_zhouqi_list);
			if (pop_main_bottom != null) {
				pop_main_bottom.showAsDropDown(topre);
			}
			break;
		case R.id.main_next:
			closePop(pop_main_bottom);
			break;
		case R.id.more_want:
			myPopDialog = new MyPopDialog(this);
			myPopDialog.setStr("更多功能，正在努力升级中，敬请期待待");
			myPopDialog.show();
			break;
		case R.id.service_idea:
			Intent webLoadIntent = new Intent(this, WebLoad.class);
			webLoadIntent.putExtra("title", "服务理念");
			startActivity(webLoadIntent);
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
//			startActivity(hourlyInforIntent);
			break;
		case R.id.tab_myorder:// 我的订单
//			startActivity(orderIntent);
			break;
		case R.id.tab_coupon:// 优惠券
//			startActivity(couponIntent);
			break;
		case R.id.tab_search:// 搜索
//			startActivity(searchIntent);
			break;
		case R.id.tab_more:// 更多
//			startActivity(moreIntent);
			break;
		default:
			break;
		}
	}

	@Override
	public void yes() {
		// TODO Auto-generated method stub
		switch (flag) {
		case 1:
			Intent phoneIntent = new Intent("android.intent.action.CALL",
			Uri.parse("tel:" + "400-100-56688"));
			startActivity(phoneIntent);
			break;
		case 2:
			super.finish();
			break;
		default:
			break;
		}
	}

	@Override
	public void no() {
		// TODO Auto-generated method stub

	}

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

	class ZhouqiAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return days.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return days.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View curentView, ViewGroup arg2) {
			// TODO Auto-generated method stub
			curentView = inflater.inflate(R.layout.pop_zhouqi_list_item, null);
			TextView text = (TextView) curentView.findViewById(R.id.text);
			text.setText(days.get(position));
			return curentView;
		}
	};

	class HourlyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return hourlys.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return hourlys.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View curentView, ViewGroup arg2) {
			// TODO Auto-generated method stub
			curentView = inflater.inflate(R.layout.main_bottom_item, null);
			return curentView;
		}
	};
}