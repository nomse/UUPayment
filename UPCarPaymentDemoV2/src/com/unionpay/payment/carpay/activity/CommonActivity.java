package com.unionpay.payment.carpay.activity;

import android.os.Bundle;
import android.text.TextUtils;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.base.PaymentBaseActivity;
import com.unionpay.payment.carpay.constant.Constant;

public class CommonActivity extends PaymentBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        String title = getIntent().getStringExtra(Constant.KEY.TITLE);
        if (!TextUtils.isEmpty(title)) {
            setCustomTitle(title);
        }
    }

}
