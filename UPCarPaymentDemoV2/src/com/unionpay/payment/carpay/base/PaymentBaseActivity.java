package com.unionpay.payment.carpay.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.utils.ActivityUtils;
import com.unionpay.payment.carpay.utils.AppActivityManager;
import com.unionpay.payment.carpay.widget.PaymentDialog;

public abstract class PaymentBaseActivity extends Activity {

    public static final int DIALOG_ACTION_CARD_DELETE = 0;
    public static final int DIALOG_ACTION_BANK_SERVICE = 1;
    public static final int DIALOG_ACTION_SET_DEFAULT_CARD = 2;

    private boolean mIsNeedCustomTitle = false;

    private int mDialogAction;

    protected View mTitleRightBtn;
    private TextView mTitleTextView;
    private PaymentDialog mDialog;

    protected OnClickListener mDialogListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            mDialog.dismiss();
            switch (v.getId()) {
            case R.id.btn_dlg_confirm:
                onAlertConfirmed(mDialogAction);
                break;
            case R.id.btn_dlg_cancel:
                onAlertCanceled(mDialogAction);
                break;
            default:
                break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        onCreate(savedInstanceState, true);
    }

    protected void onCreate(Bundle savedInstanceState, Boolean isNeedCustomTitle) {
        mIsNeedCustomTitle = isNeedCustomTitle;
        if (isNeedCustomTitle) {
            requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        }

        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            ActivityUtils.finishActivity();
            System.exit(0);
        }

        AppActivityManager.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppActivityManager.getInstance().finishActivity(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        if (mIsNeedCustomTitle) {
            getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.layout_title);

            mTitleTextView = (TextView) findViewById(R.id.main_title);
            try {
                PackageManager pm = getPackageManager();
                ActivityInfo activityInfo = pm.getActivityInfo(getComponentName(), 0);
                if (activityInfo != null && activityInfo.labelRes != 0) {
                    mTitleTextView.setText(activityInfo.labelRes);
                } else {
                    mTitleTextView.setText(getString(R.string.app_name));
                }
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                mTitleTextView.setText(getString(R.string.app_name));
            }

            View backButton = findViewById(R.id.nav_btn_back);
            backButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    PaymentBaseActivity.this.finish();
                }
            });

            mTitleRightBtn = findViewById(R.id.btn_right);
            mTitleRightBtn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    onTitleRightBtnClicked();
                }
            });
        }
        initView();
        initData();
    }

    protected void showTitleRightBtn(boolean show) {
        if (mTitleRightBtn != null) {
            if (show) {
                mTitleRightBtn.setVisibility(View.VISIBLE);
            } else {
                mTitleRightBtn.setVisibility(View.GONE);
            }
        }
    }

    protected void setCustomTitle(String title) {
        if (mTitleTextView != null) {
            mTitleTextView.setText(title);
        }
    }

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    protected void showToast(int msgResId) {
        Toast.makeText(this, getString(msgResId), Toast.LENGTH_LONG).show();
    }

    protected void showAlert(String message, String confirmText, String cancelText, int action,
            boolean isCancelable) {
        hideDialog();
        showDialog(this, PaymentDialog.STYLE_ALERT, message, cancelText, confirmText, isCancelable);
        mDialogAction = action;
    }

    protected void showAlert(String message, String confirmText, String cancelText, int action) {
        hideDialog();
        showDialog(this, PaymentDialog.STYLE_ALERT, message, cancelText, confirmText, true);
        mDialogAction = action;
    }

    protected void showAlert(String message, int action) {
        hideDialog();
        showDialog(this, PaymentDialog.STYLE_ALERT, message, null, null, true);
        mDialogAction = action;
    }

    protected void showAlert(int msgResId, int confirmTextResId, int cancelTextResId, int action,
            boolean isCancelable) {
        hideDialog();
        showDialog(this, PaymentDialog.STYLE_ALERT, getString(msgResId),
                getString(confirmTextResId), getString(cancelTextResId), isCancelable);
        mDialogAction = action;
    }

    protected void showAlert(int msgResId, int confirmTextResId, int cancelTextResId, int action) {
        hideDialog();
        showDialog(this, PaymentDialog.STYLE_ALERT, getString(msgResId),
                getString(confirmTextResId), getString(cancelTextResId), true);
        mDialogAction = action;
    }

    protected void showAlert(int msgResId, int action) {
        hideDialog();
        showDialog(this, PaymentDialog.STYLE_ALERT, getString(msgResId), null, null, true);
        mDialogAction = action;
    }

    private void showDialog(Context context, int style, String message, String confirmText,
            String cancelText, boolean isCancelable) {
        mDialog = new PaymentDialog(context, style, message, confirmText, cancelText,
                mDialogListener);
        mDialog.setCancelable(false);
        mDialog.show();
    }

    protected void hideDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    protected void onTitleRightBtnClicked() {
    }

    protected void onAlertCanceled(int action) {
    }

    protected void onAlertConfirmed(int action) {
    }

    protected abstract void initView();

    protected abstract void initData();
}
