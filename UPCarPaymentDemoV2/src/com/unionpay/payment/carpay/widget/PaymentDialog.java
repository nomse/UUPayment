package com.unionpay.payment.carpay.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unionpay.payment.carpay.R;

public class PaymentDialog extends Dialog {

    public static final int STYLE_ALERT = 0;
    public static final int STYLE_PROGRESS = 1;
    public static final int STYLE_INFO = 2;
    public static final int STYLE_HORIZONTAL_PROGRESS = 3;

    private int mStyle;
    private String mMessage;
    private boolean mCancelable = true;

    private Context mContext;
    private android.view.View.OnClickListener mOnClickListener;
    private TextView mDialogInfoText;

    public PaymentDialog(Context context, int style, String message, String confirmText,
            String cancelText, android.view.View.OnClickListener onClickListener) {
        super(context);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCanceledOnTouchOutside(false);
        setCancelable(false);

        mContext = context;
        mOnClickListener = onClickListener;
        mStyle = style;
        mMessage = message;
        switch (style) {
        case STYLE_ALERT:
            initAlertDialog(confirmText, cancelText);
            break;
        default:
            break;
        }
    }

    private void initAlertDialog(String confirmText, String cancelText) {
        View dialog = View.inflate(mContext, R.layout.dialog_alert, null);
        WindowManager m = ((Activity) mContext).getWindowManager();
        Display d = m.getDefaultDisplay();
        // 获取屏幕宽、高用
        // int height = (int) (d.getHeight() * 0.5); // 高度设置为屏幕的0.5
        @SuppressWarnings("deprecation")
        int width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的0.8

        setContentView(dialog, new LinearLayout.LayoutParams(width, LayoutParams.WRAP_CONTENT));
        mDialogInfoText = (TextView) findViewById(R.id.dialog_info);
        mDialogInfoText.setText(mMessage);
        Button btnConfirm = (Button) findViewById(R.id.btn_dlg_confirm);
        btnConfirm.setOnClickListener(mOnClickListener);
        Button btnCancel = (Button) findViewById(R.id.btn_dlg_cancel);
        btnCancel.setOnClickListener(mOnClickListener);

        if (!TextUtils.isEmpty(confirmText)) {
            btnConfirm.setText(confirmText);
        }
        if (!TextUtils.isEmpty(cancelText)) {
            btnCancel.setText(cancelText);
        }
    }

    public boolean isCancelable() {
        return mCancelable;
    }

    @Override
    public void setCancelable(boolean cancelable) {
        mCancelable = cancelable;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
        if (mDialogInfoText != null) {
            mDialogInfoText.setText(message);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && !mCancelable) {
            return true;
        }
        ((Activity) mContext).onKeyDown(keyCode, event);
        return super.onKeyDown(keyCode, event);
    }
}
