package com.housekeeping.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.housekeeping.R;

public class MySureDialog extends Dialog implements
		android.view.View.OnClickListener {

	private Context context;
	private Button dialog_yes;
	private TextView dialog_text, dialog_title;
	private MyDialogOnClickListener clickListener;
	private View view;
	String title;
	String content;
	String yes;
	String no;

	public MySureDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public MySureDialog(Context context, MyDialogOnClickListener clickListener) {
		super(context, R.style.dialog);
		this.context = context;
		this.clickListener = clickListener;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.mydialog);
		this.setCancelable(false);
		view = getWindow().getDecorView();
		dialog_yes = (Button) findViewById(R.id.dialog_yes);
		dialog_text = (TextView) findViewById(R.id.dialog_text);
		dialog_title = (TextView) findViewById(R.id.dialog_title);
		dialog_title.setText(title);
		dialog_text.setText(content);
		dialog_yes.setText(yes);
		if(TextUtils.isEmpty(content)){
			dialog_title.setVisibility(View.GONE);
			dialog_text.setText(title);
		}
		
		dialog_yes.setOnClickListener(this);
	}

	public void setStr(String title, String content, String yes, String no) {
		this.title = title;
		this.content = content;
		this.yes = yes;
		this.no = no;

	}

	public void setTitle(String title) {
		dialog_text.setText(title);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.dialog_yes:
			clickListener.yes();
			this.cancel();
			break;
		default:
			break;
		}
	}

	public interface MyDialogOnClickListener {
		public abstract void yes();

		public abstract void no();
	}

}