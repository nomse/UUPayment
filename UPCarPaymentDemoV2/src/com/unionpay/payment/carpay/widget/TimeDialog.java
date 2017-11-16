package com.unionpay.payment.carpay.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

public class TimeDialog extends AlertDialog {
	private int FLAG_DISMISS = 100;
	private boolean flag = true;
	private int time;
	public TimeDialog(Context context,int time) {
		super(context);
		this.time=time;
		setTitle("温馨提示");
	}

	@Override
	public void show() {
		super.show();
		newThread.start();
	}

	@Override
	public void dismiss() {
		super.dismiss();
		flag = false;
	}

	private Thread newThread = new Thread() {
		public void run() {
			super.run();
			while (flag) {
				try {
					Thread.sleep(time);
					newHandler.sendEmptyMessage(FLAG_DISMISS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	private Handler newHandler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == FLAG_DISMISS)
				dismiss();
		}

	};

	public void setPositiveButton(String text, OnClickListener listener) {
		setButton(DialogInterface.BUTTON_POSITIVE, text, listener);
	}
}
