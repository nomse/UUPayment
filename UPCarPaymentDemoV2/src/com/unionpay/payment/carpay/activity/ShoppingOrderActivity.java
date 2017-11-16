package com.unionpay.payment.carpay.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.base.PaymentBaseActivity;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.constant.Constant;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.data.Module;
import com.unionpay.payment.carpay.utils.ActivityUtils;
import com.unionpay.payment.carpay.utils.CardUtils;

public class ShoppingOrderActivity extends PaymentBaseActivity implements OnClickListener {

    private BankCard mDefaultBankCard;

    private View mPopupContentView;
    private PopupWindow mPayOrderPopupWindow;
    private TextView mBankPanText;
    private TextView mBankCardNoText;

    protected Handler mHandler = new Handler(new Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
            case Constant.MSG.ORDER_SUCCESS:
                ActivityUtils.finishActivity();
                break;

            default:
                break;
            }
            return false;
        }
    });

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shopping_order);
    }

    @Override
    protected void initView() {
        findViewById(R.id.btn_shopping_order_cancel).setOnClickListener(this);
        findViewById(R.id.btn_shopping_order_submit).setOnClickListener(this);

        mBankCardNoText = (TextView) findViewById(R.id.text_order_card_no);
        mBankPanText = (TextView) findViewById(R.id.text_order_card_pan);
    }

    @Override
    protected void initData() {
        mDefaultBankCard = DataMock.getInstance().getDefaultBankCard();
        mBankCardNoText.setText(CardUtils.formatCardNum(CardUtils.maskCardNum(mDefaultBankCard
                .getCardNo())));
        mBankPanText.setText(CardUtils.formatCardNum(CardUtils.maskCardNum1(mDefaultBankCard
                .getPan())));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btn_shopping_order_cancel:
            ActivityUtils.finishActivity();
            break;
        case R.id.btn_shopping_order_submit:
            showPayOrderPopupWindow();
            break;

        default:
            break;
        }
    }

    @Override
    protected void onAlertConfirmed(int action) {
        super.onAlertConfirmed(action);
        switch (action) {
        case DIALOG_ACTION_SET_DEFAULT_CARD:
            showOrDismissPopupWindow();
            finish();
            break;
        default:
            break;
        }
    }

    @SuppressLint("InflateParams")
    private void showPayOrderPopupWindow() {
        if (mPayOrderPopupWindow == null) {
            mPopupContentView = LayoutInflater.from(this).inflate(R.layout.popup_pay_order, null);
            mPayOrderPopupWindow = new PopupWindow(mPopupContentView, LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT, true);

            TextView popupCardNoText = (TextView) mPopupContentView
                    .findViewById(R.id.text_order_popup_card_no);
            TextView popupBankNameText = (TextView) mPopupContentView
                    .findViewById(R.id.text_order_popup_bank_name);
            popupCardNoText.setText(CardUtils.formatCardNum(CardUtils.maskCardNum(mDefaultBankCard
                    .getCardNo())));
            popupBankNameText.setText(mDefaultBankCard.getBank());

            final LinearLayout popupLayout = (LinearLayout) mPopupContentView
                    .findViewById(R.id.layout_popup_pay_order);
            final ImageView submitSuccessImg = (ImageView) mPopupContentView
                    .findViewById(R.id.imgview_order_success);
            final LinearLayout subLayout = (LinearLayout) mPopupContentView
                    .findViewById(R.id.layout_popup_sub_content);
            final ImageButton submitOrderBtn = (ImageButton) mPopupContentView
                    .findViewById(R.id.imgBtn_submit_order);
            submitOrderBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    BankCard defaultCard = DataMock.getInstance().getDefaultBankCard();
                    if (defaultCard == null) {
                        showAlert(getString(R.string.notice_set_default_card),
                                DIALOG_ACTION_SET_DEFAULT_CARD);
                        return;
                    }
                    subLayout.setVisibility(View.GONE);
                    submitSuccessImg.setVisibility(View.VISIBLE);
                    popupLayout.setGravity(Gravity.CENTER);

                    DataMock.getInstance().addTransRecord(Module.MODULE_3, "购物",
                            defaultCard.getPan(), 68.00f);
                    mHandler.sendEmptyMessageDelayed(Constant.MSG.ORDER_SUCCESS, 2000);
                }
            });
            mPayOrderPopupWindow.setOutsideTouchable(true);
            mPayOrderPopupWindow.setFocusable(true);
            mPayOrderPopupWindow.setBackgroundDrawable(new ColorDrawable());
            mPayOrderPopupWindow.showAtLocation(
                    getLayoutInflater().inflate(R.layout.activity_shopping_order, null),
                    Gravity.BOTTOM, 0, 0);
        } else {
            showOrDismissPopupWindow();
        }
    }

    private void showOrDismissPopupWindow() {
        if (mPayOrderPopupWindow != null) {
            if (mPayOrderPopupWindow.isShowing()) {
                mPayOrderPopupWindow.dismiss();
            } else {
                mPayOrderPopupWindow.showAtLocation(
                        getLayoutInflater().inflate(R.layout.activity_shopping_order, null),
                        Gravity.BOTTOM, 0, 0);
            }
        }
    }
}
