package com.song.deom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

public abstract class DialogBase extends Dialog {

	protected OnClickListener onSuccessListener;
	protected OnClickListener onCancelListener;
	protected OnDismissListener onDismissListener;
	
	protected Context mainContext;
	
	protected Button positiveButton, negativeButton;
	
	public DialogBase(Context context) {
		super(context);
		this.mainContext = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
		this.onBuilding();
	}

	/**
	 * �����������������ඨ�ƴ�������
	 */
	protected abstract void onBuilding();

	/**
	 * ȷ�ϰ�ť�����������������ඨ��
	 */
	protected abstract boolean OnClickPositiveButton();

	/**
	 * ȡ����ť�����������������ඨ��
	 */
	protected abstract void OnClickNegativeButton();

	/**
	 * �رշ������������ඨ��
	 */
	protected abstract void onDismiss();
}
