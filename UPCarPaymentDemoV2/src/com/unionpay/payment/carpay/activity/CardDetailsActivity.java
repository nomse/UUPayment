package com.unionpay.payment.carpay.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.base.PaymentBaseActivity;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.utils.ActivityUtils;
import com.unionpay.payment.carpay.utils.CardUtils;

public class CardDetailsActivity extends PaymentBaseActivity {

    private BankCard mBankCard;

    private View mPopupContentView;
    private PopupWindow mPopupWindow;
    private TextView mCardTransText;
    private TextView mBankNameText;
    private TextView mBankPan1Text;
    private TextView mBankPan2Text;
    private TextView mBankCardNoText;
    private TextView mContactBankText;
    private TextView mBankServiceText;
    private Button mSetDefaultCardBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);
    }

    @Override
    protected void initView() {
        showTitleRightBtn(true);

        mBankNameText = (TextView) findViewById(R.id.text_bank_name);
        mBankPan1Text = (TextView) findViewById(R.id.text_bank_pan_1);
        mCardTransText = (TextView) findViewById(R.id.text_card_trans);
        mCardTransText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.showCardTransDetailsActivity(CardDetailsActivity.this);
            }
        });
        mBankCardNoText = (TextView) findViewById(R.id.text_card_no);
        mBankPan2Text = (TextView) findViewById(R.id.text_bank_pan_2);
        mContactBankText = (TextView) findViewById(R.id.text_contact_bank);

        mBankServiceText = (TextView) findViewById(R.id.text_bank_service_tel);
        mBankServiceText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(
                        String.format(getString(R.string.notice_bank_service), mBankCard.getBank()),
                        DIALOG_ACTION_BANK_SERVICE);
            }
        });

        mSetDefaultCardBtn = (Button) findViewById(R.id.btn_set_card_default);
        mSetDefaultCardBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DataMock.getInstance().setDefaultBankCard(mBankCard);
                mSetDefaultCardBtn.setEnabled(!mBankCard.isDefault());
            }
        });
    }

    @Override
    protected void initData() {
        mBankCard = DataMock.getInstance().getCurBankCard();

        String bank = mBankCard.getBank();
        String pan = mBankCard.getPan();
        mBankNameText.setText(bank);
        mBankPan1Text.setText(String.format(getString(R.string.label_pan_end),
                pan.substring(pan.length() - 4)));
        mBankPan2Text.setText(CardUtils.formatCardNum(CardUtils.maskCardNum1(pan)));
        mBankCardNoText
                .setText(CardUtils.formatCardNum(CardUtils.maskCardNum(mBankCard.getCardNo())));
        mContactBankText.setText(String.format(getString(R.string.label_contact_bank), bank));
        mBankServiceText.setText(mBankCard.getService());
        mSetDefaultCardBtn.setEnabled(!mBankCard.isDefault());
    }

    @Override
    protected void onAlertConfirmed(int action) {
        super.onAlertConfirmed(action);
        switch (action) {
        case DIALOG_ACTION_CARD_DELETE:
            DataMock.getInstance().removeBankCard(mBankCard);
            mPopupWindow.dismiss();
            finish();
            break;
        case DIALOG_ACTION_BANK_SERVICE:
            ActivityUtils.callPhoneApplication(this, mBankCard.getService());
            break;
        default:
            break;
        }
    }

    @Override
    protected void onAlertCanceled(int action) {
        super.onAlertCanceled(action);
        switch (action) {
        case DIALOG_ACTION_CARD_DELETE:
            mPopupWindow.dismiss();
            break;
        default:
            break;
        }
    }

    @Override
    protected void onTitleRightBtnClicked() {
        super.onTitleRightBtnClicked();
        initTitileRightMainView();
        showTitlePopupWindow(mTitleRightBtn);
    }

    @SuppressLint("InflateParams")
    private void initTitileRightMainView() {
        mPopupContentView = LayoutInflater.from(this).inflate(R.layout.popup_del_card, null);
        mPopupContentView.findViewById(R.id.btn_del_card).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showAlert(R.string.notice_card_del, R.string.btn_label_card_del_confirm,
                        R.string.btn_label_card_del_cancel, DIALOG_ACTION_CARD_DELETE);
            }
        });
        mPopupContentView.findViewById(R.id.btn_cancel_del_card).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        mPopupWindow.dismiss();
                    }
                });
    }

    @SuppressLint("NewApi")
    private void showTitlePopupWindow(View view) {
        mPopupWindow = new PopupWindow(mPopupContentView, LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT, true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
            }
        });
        mPopupWindow.showAsDropDown(view);
    }

}
