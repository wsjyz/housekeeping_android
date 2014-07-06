package com.housekeeping.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.eighth.housekeeping.domain.MemberInfo;
import com.eighth.housekeeping.proxy.RemoteProxy;
import com.eighth.housekeeping.proxy.exception.RemoteInvokeException;
import com.eighth.housekeeping.proxy.service.UserService;
import com.eighth.housekeeping.proxy.service.impl.UserServiceImpl;
import com.housekeeping.R;
import com.housekeeping.utils.LogUtils;

public class Login extends Basic implements OnClickListener {
	private Button loginBtn, get_authorBtn;
	private EditText username;
	private EditText password;
	private PopupWindow authorSendPop;
	private LayoutInflater inflater;
	// 引入窗口配置文件
	private View authorSendView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 去掉标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		prepareData();
		initView();

	}

	private void prepareData() {
		
//	 try {
//			UserService proxy = new RemoteProxy<UserService>(new UserServiceImpl()).getProxy();
//            MemberInfo userInfo = proxy.login("sef");
//            LogUtils.d(userInfo.getNickName());
//        } catch (RemoteInvokeException e) {
//            e.printStackTrace();
//        }
		inflater = LayoutInflater.from(this);
		authorSendView = inflater.inflate(R.layout.author_send, null);
		authorSendPop = new PopupWindow(authorSendView,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, false);
		// 需要设置一下此参数，点击外边可消失
		authorSendPop.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击窗口外边窗口消失
		authorSendPop.setOutsideTouchable(true);
		// 设置此参数获得焦点，否则无法点击
		authorSendPop.setFocusable(true);

	}

	private void initView() {
		username = (EditText) findViewById(R.id.login_username);
		password = (EditText) findViewById(R.id.login_password);
		// 获取对象
		loginBtn = (Button) findViewById(R.id.login_btn);
		get_authorBtn = (Button) findViewById(R.id.get_author);
		// 设置按钮的监听事件
		
		username.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
				String temp = s.toString();
				String addChar = temp.substring(start);
				String str = username.getText().toString();
				if (temp.length() == 3 || temp.length() == 8) {
					if (!TextUtils.isEmpty(addChar)) {
						temp += " ";
						username.setText(temp);
						username.setSelection(temp.length());
					}
				}
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		loginBtn.setOnClickListener(this);
		get_authorBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.login_btn:
		
			// 登陆判断
			startActivity(new Intent(Login.this, Main.class));
			this.finish();
			break;
		case R.id.get_author:
			int[] location = new int[2];
			get_authorBtn.getLocationOnScreen(location);
			if (authorSendPop.isShowing()) {
				// 隐藏窗口，如果设置了点击窗口外小时即不需要此方式隐藏
				authorSendPop.dismiss();
			} else {
				// 显示窗口
//				authorSendPop.showAtLocation(get_authorBtn, Gravity.TOP,
//						location[0]-authorSendPop.getWidth(), location[1] + authorSendPop.getHeight());
				authorSendPop.showAtLocation(get_authorBtn, Gravity.BOTTOM,
						0, 0);
			 
			}

			break;
		default:
			break;
		}
	}

}
