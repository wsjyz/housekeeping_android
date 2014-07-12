package com.housekeeping.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.housekeeping.R;

public class MyPopDialog extends Dialog implements OnClickListener{

	private Context context;
	private TextView pop_title;
	private View view;
	private String pop_title_str;
	private RelativeLayout pop_parent;
	public MyPopDialog(Context context) {
		super(context, R.style.dialog);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.pop_more_delete);
		this.setCancelable(true);
		this.setCanceledOnTouchOutside(true);
		view = getWindow().getDecorView();
		pop_title = (TextView) findViewById(R.id.pop_title);
		pop_parent = (RelativeLayout) findViewById(R.id.pop_parent);
		pop_parent.setOnClickListener(this);
		pop_title.setText(pop_title_str);
	}

	public void setStr(String content) {
		this.pop_title_str = content;

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.pop_parent:
			this.cancel();
			break;

		default:
			break;
		}
	}

}