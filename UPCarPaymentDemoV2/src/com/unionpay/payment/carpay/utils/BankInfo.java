package com.unionpay.payment.carpay.utils;

import android.text.TextUtils;

public class BankInfo {

    public static String getNameOfBank(String pan) {
        String name = BankInfoA.getNameOfBank(pan);
        if (TextUtils.isEmpty(name)) {
            name = BankInfoB.getNameOfBank(pan);
        }
        if (TextUtils.isEmpty(name)) {
            name = BankInfoC.getNameOfBank(pan);
        }
        if (TextUtils.isEmpty(name)) {
            name = BankInfoD.getNameOfBank(pan);
        }
        if (TextUtils.isEmpty(name)) {
            name = BankInfoE.getNameOfBank(pan);
        }
        return name;
    }

}