package com.unionpay.payment.carpay.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.base.PaymentBaseActivity;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.utils.ActivityUtils;
import com.unionpay.payment.carpay.utils.MobileUtils;

public class CardAddInfoActivity extends PaymentBaseActivity {

    private BankCard mTempBankCard;

    private ImageView mBankLogoImg;
    private TextView mBankInfo;
    private EditText mCardValidityEdit;
    private EditText mCardSafeCodeEdit;
    private EditText mCardPhoneNumEdit;
    private EditText mVerifyCodeEdit;
    private Button mGetVerifyCodeBtn;
    private Button mAddCardInfoNextBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_add_info);
    }

    @Override
    protected void initView() {
        mBankLogoImg = (ImageView) findViewById(R.id.img_bank_logo);
        mBankInfo = (TextView) findViewById(R.id.text_bank_info);
        mCardValidityEdit = (EditText) findViewById(R.id.edit_bank_validity);
        mCardSafeCodeEdit = (EditText) findViewById(R.id.edit_bank_safecode);
        mCardPhoneNumEdit = (EditText) findViewById(R.id.edit_bank_phonenum);
        mVerifyCodeEdit = (EditText) findViewById(R.id.edit_bank_verifycode);

        mGetVerifyCodeBtn = (Button) findViewById(R.id.btn_get_verifycode);
        mGetVerifyCodeBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenum = mCardPhoneNumEdit.getText().toString();
                if (TextUtils.isEmpty(phonenum.trim())) {
                    showToast("请输入手机号码！");
                    return;
                }
                if (!MobileUtils.isValidNumber(phonenum) || phonenum.length() != 11) {
                    showToast("请输入正确的手机号码！");
                    return;
                }
                mCountDownTimer.start();
                mGetVerifyCodeBtn.setEnabled(false);
            }
        });
        mAddCardInfoNextBtn = (Button) findViewById(R.id.btn_add_card_info_next);
        mAddCardInfoNextBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO simple verify
                String validity = mCardValidityEdit.getText().toString();
                String safeCode = mCardSafeCodeEdit.getText().toString();
                String phonenum = mCardPhoneNumEdit.getText().toString();
                String verifyCode = mVerifyCodeEdit.getText().toString();
                if (TextUtils.isEmpty(validity.trim())) {
                    showToast("请输入有效期！");
                    return;
                }
                if (validity.length() != 4) {
                    showToast("请输入正确的有效期！");
                    return;
                }

                if (TextUtils.isEmpty(safeCode.trim())) {
                    showToast("请输入安全码！");
                    return;
                }
                if (safeCode.length() != 3) {
                    showToast("请输入正确的安全码！");
                    return;
                }

                if (TextUtils.isEmpty(phonenum.trim())) {
                    showToast("请输入手机号码！");
                    return;
                }
                if (!MobileUtils.isValidNumber(phonenum) || phonenum.length() != 11) {
                    showToast("请输入正确的手机号码！");
                    return;
                }

                if (TextUtils.isEmpty(verifyCode.trim())) {
                    showToast("请输入验证码！");
                    return;
                }
                if (verifyCode.length() != 6) {
                    showToast("请输入6位验证码！");
                    return;
                }

                mTempBankCard.setValidity(validity);
                mTempBankCard.setSafeCode(safeCode);
                mTempBankCard.setTelNumber(phonenum);
                ActivityUtils.showAddCardDoneActivity(CardAddInfoActivity.this);
            }
        });
    }

    @Override
    protected void initData() {
        mTempBankCard = DataMock.getInstance().getTempBankCard();
        mBankLogoImg.setImageDrawable(getResources().getDrawable(mTempBankCard.getLogoResId()));
        String bank = mTempBankCard.getBank();
        String pan = mTempBankCard.getPan();
        mBankInfo
                .setText(bank
                        + " "
                        + String.format(getString(R.string.label_pan_end),
                                pan.substring(pan.length() - 4)));
    }

    private CountDownTimer mCountDownTimer = new CountDownTimer(60000, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            mGetVerifyCodeBtn.setText(String.format(getString(R.string.label_reget_verify_code),
                    millisUntilFinished / 1000));
        }

        @Override
        public void onFinish() {
            mGetVerifyCodeBtn.setText(getString(R.string.label_get_verify_code));
            mGetVerifyCodeBtn.setEnabled(true);
        }
    };
}
