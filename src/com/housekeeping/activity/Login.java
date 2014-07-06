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
	// ���봰�������ļ�
	private View authorSendView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ȥ��������
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
		// ��Ҫ����һ�´˲����������߿���ʧ
		authorSendPop.setBackgroundDrawable(new BitmapDrawable());
		// ���õ��������ߴ�����ʧ
		authorSendPop.setOutsideTouchable(true);
		// ���ô˲�����ý��㣬�����޷����
		authorSendPop.setFocusable(true);

	}

	private void initView() {
		username = (EditText) findViewById(R.id.login_username);
		password = (EditText) findViewById(R.id.login_password);
		// ��ȡ����
		loginBtn = (Button) findViewById(R.id.login_btn);
		get_authorBtn = (Button) findViewById(R.id.get_author);
		// ���ð�ť�ļ����¼�
		
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
		
			// ��½�ж�
			startActivity(new Intent(Login.this, Main.class));
			this.finish();
			break;
		case R.id.get_author:
			int[] location = new int[2];
			get_authorBtn.getLocationOnScreen(location);
			if (authorSendPop.isShowing()) {
				// ���ش��ڣ���������˵��������Сʱ������Ҫ�˷�ʽ����
				authorSendPop.dismiss();
			} else {
				// ��ʾ����
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
