package com.song.deom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private Button dialog_a, dialog_b, btn_share_activity, btn_share_win,
			btn_search_user;
	private ScrollView layout_all;

	PopupWindow sharePopWin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dialog_a = (Button) findViewById(R.id.dialog_a);
		dialog_b = (Button) findViewById(R.id.dialog_b);
		btn_share_activity = (Button) findViewById(R.id.btn_share_activity);
		btn_share_win = (Button) findViewById(R.id.btn_share_win);
		btn_search_user = (Button) findViewById(R.id.btn_search_user);
		dialog_a.setOnClickListener(this);
		dialog_b.setOnClickListener(this);
		btn_share_activity.setOnClickListener(this);
		btn_share_win.setOnClickListener(this);
		btn_search_user.setOnClickListener(this);

		layout_all = (ScrollView) findViewById(R.id.layout_all);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dialog_a:
			startActivity(new Intent(this, DialogActivity.class));
			break;
		case R.id.dialog_b:
			showSexDialog();
			break;
		case R.id.btn_share_activity:
			startActivity(new Intent(this, ShareActivity.class));
			break;
		case R.id.btn_share_win:
			showPopWindowShare();
			break;
		case R.id.btn_search_user:
			startActivity(new Intent(this, SearchUserActivity.class));
			break;
		default:
			break;
		}
	}

	private void showPopWindowShare() {
		SharePopwin sharePopwin = new SharePopwin(this);
		sharePopwin.showPopupWindow(layout_all);
	}

	private void showSexDialog() {
		final AlertDialog dlg = new AlertDialog.Builder(this).create();
		dlg.show();
		Window window = dlg.getWindow();
		window.setContentView(R.layout.dialog_alert_sex);
		LinearLayout ll_title = (LinearLayout) window
				.findViewById(R.id.ll_title);
		ll_title.setVisibility(View.VISIBLE);
		TextView tv_title = (TextView) window.findViewById(R.id.tv_title);
		tv_title.setText("性别");
		// 为确认按钮添加事件,执行退出应用操作
		TextView tv_paizhao = (TextView) window.findViewById(R.id.tv_content1);
		tv_paizhao.setText("男");
		tv_paizhao.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SdCardPath")
			public void onClick(View v) {
				dlg.cancel();
			}
		});
		TextView tv_xiangce = (TextView) window.findViewById(R.id.tv_content2);
		tv_xiangce.setText("女");
		tv_xiangce.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				dlg.cancel();
			}
		});
	}
}
