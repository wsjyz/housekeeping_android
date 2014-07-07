package com.housekeeping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.housekeeping.R;
import com.housekeeping.view.OnViewChangeListener;
import com.housekeeping.view.SwitchLayout;

public class MemberInfor extends Basic implements OnClickListener {
	/** Called when the activity is first created. */
	private SwitchLayout switchLayout;// �Զ���Ŀؼ�
	private LinearLayout linearLayout;
	private int mViewCount;// �Զ���ؼ����ӿؼ��ĸ���
	private ImageView mImageView[];// �ײ���imageView
	private int mCurSel;// ��ǰѡ�е�imageView

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.member_intro);
		init();
	}

	private void init() {
		mCurSel = getIntent().getIntExtra("mCurSel", 0);
		switchLayout = (SwitchLayout) findViewById(R.id.switchLayoutID);
		linearLayout = (LinearLayout) findViewById(R.id.linerLayoutID);
		// �õ��ӿؼ��ĸ���
		mViewCount = switchLayout.getChildCount();
		mImageView = new ImageView[mViewCount];
		// ����imageView
		for (int i = 0; i < mViewCount; i++) {
			// �õ�LinearLayout�е��ӿؼ�
			mImageView[i] = (ImageView) linearLayout.getChildAt(i);
			mImageView[i].setEnabled(true);// �ؼ�����
			mImageView[i].setOnClickListener(new MOnClickListener());
			mImageView[i].setTag(i);// ������view��صı�ǩ
		}
		// ���õ�һ��imageView��������
		
		mImageView[mCurSel].setEnabled(false);
		switchLayout.setOnViewChangeListener(new MOnViewChangeListener());
	}

	// ����¼��ļ�����
	private class MOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			int pos = (Integer) v.getTag();
			// ���õ�ǰ��ʾ��ImageView
			setCurPoint(pos);
			// �����Զ���ؼ��е��ĸ��ӿؼ�չʾ�ڵ�ǰ��Ļ��
			switchLayout.snapToScreen(pos);
		}
	}

	/**
	 * ���õ�ǰ��ʾ��ImageView
	 * 
	 * @param pos
	 */
	private void setCurPoint(int pos) {
		if (pos < 0 || pos > mViewCount - 1 || mCurSel == pos)
			return;
		// ��ǰ��imgaeView�����Ա�����
		mImageView[mCurSel].setEnabled(true);
		// ��Ҫ��ת��ȥ���Ǹ�imageView��ɲ��ɼ���
		mImageView[pos].setEnabled(false);
		mCurSel = pos;
	}

	// �Զ���ؼ���View�ı���¼�����
	private class MOnViewChangeListener implements OnViewChangeListener {
		@Override
		public void onViewChange(int view) {
			if (view < 0 || mCurSel == view) {
				return;
			} else if (view > mViewCount - 1) {
				// ���������������ʱ��activity�ᱻ�ر�
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
			break;
		default:
			break;
		}
	}

}