package com.unionpay.payment.carpay.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.base.PaymentBaseActivity;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.utils.ActivityUtils;

public class CardAddDoneActivity extends PaymentBaseActivity {

    private BankCard mTempBankCard;

    private Button mAddCardDoneBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, false);
        setContentView(R.layout.activity_card_add_done);
    }

    @Override
    protected void initView() {
        mAddCardDoneBtn = (Button) findViewById(R.id.btn_add_card_done);
        mAddCardDoneBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DataMock.getInstance().addBankCard(mTempBankCard);
                ActivityUtils.finishActivity();
            }
        });
    }

    @Override
    protected void initData() {
        mTempBankCard = DataMock.getInstance().getTempBankCard();
    }

}
