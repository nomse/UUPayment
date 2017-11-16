package com.unionpay.payment.carpay.base;

import android.app.Application;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

public class PaymentApplication extends Application {

    private static PaymentApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);
        mInstance = this;
    }

    public synchronized static PaymentApplication getInstance() {
        return mInstance;
    }
}
