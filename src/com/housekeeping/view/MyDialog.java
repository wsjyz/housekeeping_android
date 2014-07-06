package com.housekeeping.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.housekeeping.R;

public class MyDialog extends Dialog implements
		android.view.View.OnClickListener {

	private Context context;
	private Button dialog_yes, dialog_no;
	private TextView dialog_text;
	private MyDialogOnClickListener clickListener;

	public MyDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public MyDialog(Context context, 
			MyDialogOnClickListener clickListener) {
		super(context,  R.style.dialog);
		this.context = context;
		this.clickListener = clickListener;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.mydialog);
		this.setCancelable(false);
		dialog_yes = (Button) findViewById(R.id.dialog_yes);
		dialog_no = (Button) findViewById(R.id.dialog_no);
		dialog_text = (TextView) findViewById(R.id.dialog_text);
		dialog_yes.setOnClickListener(this);
		dialog_no.setOnClickListener(this);
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
		case R.id.dialog_no:
			clickListener.no();
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