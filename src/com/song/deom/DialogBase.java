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
	 * 创建方法，用于子类定制创建过程
	 */
	protected abstract void onBuilding();

	/**
	 * 确认按钮单击方法，用于子类定制
	 */
	protected abstract boolean OnClickPositiveButton();

	/**
	 * 取消按钮单击方法，用于子类定制
	 */
	protected abstract void OnClickNegativeButton();

	/**
	 * 关闭方法，用于子类定制
	 */
	protected abstract void onDismiss();
}
