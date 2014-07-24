package com.housekeeping.activity;

import android.os.Bundle;
import android.text.Editable.Factory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.housekeeping.R;

public class UserInfor extends Basic implements OnClickListener {

	private EditText phone_edit, nikenanme_edit, name_edit, address_edit;
	private TextView edit_text;
    private Button exit_button;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.user_infor);
		prepareData();
		initView();
	}

	public void prepareData() {
	};

	public void initView() {
		phone_edit = (EditText) findViewById(R.id.phone_edit);
		nikenanme_edit = (EditText) findViewById(R.id.nikenanme_edit);
		name_edit = (EditText) findViewById(R.id.name_edit);
		address_edit = (EditText) findViewById(R.id.address_edit);
		edit_text = (TextView) findViewById(R.id.edit_text);
		exit_button = (Button) findViewById(R.id.exit_button);
		edit_text.setOnClickListener(this);
		exit_button.setOnClickListener(this);
	};

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.edit_text:
			phone_edit.setEnabled(true);
//			phone_edit.setEditableFactory(new Factory());
			nikenanme_edit.setEnabled(true);
			name_edit.setEnabled(true);
			address_edit.setEnabled(true);
			phone_edit.setClickable(true);
			nikenanme_edit.setClickable(true);
			name_edit.setClickable(true);
			address_edit.setClickable(true);
			break;
		case R.id.exit_button:
			this.finish();
			break;
		default:
			break;
		}
	}

}
