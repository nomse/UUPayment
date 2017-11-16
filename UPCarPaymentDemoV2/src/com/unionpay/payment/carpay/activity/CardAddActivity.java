package com.unionpay.payment.carpay.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.base.PaymentBaseActivity;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.utils.ActivityUtils;
import com.unionpay.payment.carpay.utils.BankInfo;

public class CardAddActivity extends PaymentBaseActivity {

    private BankCard mTempBankCard;

    private EditText mCardHolderEdit;
    private EditText mCardNumberEdit;
    private Button mAddCardNextBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_add);
    }

    @Override
    protected void initView() {
        mCardHolderEdit = (EditText) findViewById(R.id.text_card_holder);
        mCardNumberEdit = (EditText) findViewById(R.id.text_card_number);
        mAddCardNextBtn = (Button) findViewById(R.id.btn_add_card_next);
        mAddCardNextBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO simple verify
                String holder = mCardHolderEdit.getText().toString();
                String pan = mCardNumberEdit.getText().toString();
                // if (TextUtils.isEmpty(holder) || TextUtils.isEmpty(pan)
                // || !CardUtils.isValidBankCard(pan)) {
                if (TextUtils.isEmpty(holder.trim())) {
                    showToast("请输入姓名！");
                    return;
                }
                if (TextUtils.isEmpty(pan.trim())) {
                    showToast("请输入银行卡号！");
                    return;
                }
                if (!pan.startsWith("62")) {
                    showToast("请输入62开头的银行卡号！");
                    return;
                }
                if (pan.length() < 16 || pan.length() > 19) {
                    showToast("请输入正确的银行卡号！");
                    return;
                }

                String bankName = BankInfo.getNameOfBank(pan);
                if (TextUtils.isEmpty(bankName)) {
                    showToast("请输入正确的银行卡号！");
                    return;
                }

                mTempBankCard.setName(holder);
                mTempBankCard.setPan(pan);
                ActivityUtils.showAddCardInfoActivity(CardAddActivity.this);
            }
        });
    }

    @Override
    protected void initData() {
        mTempBankCard = DataMock.getInstance().getTempBankCard();

    }

}
