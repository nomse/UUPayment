package com.unionpay.payment.carpay.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.base.PaymentBaseActivity;
import com.unionpay.payment.carpay.utils.ActivityUtils;
import com.unionpay.payment.carpay.widget.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

public class ShoppingGoodsDetailActivity extends PaymentBaseActivity {

    private Banner mGoodsBannerView;
    private Button mGoodsBuyBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shopping_goods_dtl);
    }

    @Override
    protected void initView() {
        mGoodsBannerView = (Banner) findViewById(R.id.banner_goods);
        mGoodsBannerView.setBannerStyle(BannerConfig.NUM_INDICATOR);
        mGoodsBannerView.setIndicatorGravity(BannerConfig.RIGHT);
        mGoodsBuyBtn = (Button) findViewById(R.id.btn_shopping_buy);
        mGoodsBuyBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.showOrderActivity(ShoppingGoodsDetailActivity.this);
            }
        });
    }

    @Override
    protected void initData() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.banner_goods_0);
        list.add(R.drawable.banner_goods_1);
        list.add(R.drawable.banner_goods_2);
        mGoodsBannerView.setImages(list).setImageLoader(new GlideImageLoader()).start();
    }

}
