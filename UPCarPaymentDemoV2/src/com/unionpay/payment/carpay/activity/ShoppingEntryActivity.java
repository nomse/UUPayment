package com.unionpay.payment.carpay.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.base.PaymentBaseActivity;
import com.unionpay.payment.carpay.utils.ActivityUtils;

public class ShoppingEntryActivity extends PaymentBaseActivity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shopping_entry);
    }

    @Override
    protected void initView() {
        findViewById(R.id.layout_car_filter).setOnClickListener(this);
        findViewById(R.id.layout_car_oil).setOnClickListener(this);
        findViewById(R.id.layout_car_insurance).setOnClickListener(this);
        findViewById(R.id.layout_car_wheel).setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.layout_car_filter:
            ActivityUtils.showGoodsDetailActivity(this);
            break;
        case R.id.layout_car_oil:
        case R.id.layout_car_insurance:
        case R.id.layout_car_wheel:
        default:
            // ActivityUtils.showCommonActivity(this, null);
            break;
        }
    }

}
