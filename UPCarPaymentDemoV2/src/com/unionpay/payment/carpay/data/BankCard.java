package com.unionpay.payment.carpay.data;

import java.io.Serializable;

import android.text.TextUtils;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.utils.BankInfo;
import com.unionpay.payment.carpay.utils.CardUtils;

/**
 * 银行卡信息
 * 
 */
public class BankCard implements Serializable {

    private static final long serialVersionUID = -5885356266445731449L;

    private String id;// 索引
    private String name;// 持卡人姓名
    private String pan;// 银行卡号
    private String cardNo;// 实体卡号
    private String bank;// 银行名称
    private String validity;// 有效期
    private String safeCode;// 安全码
    private String telNumber;// 预留手机号码
    private int logoResId;// 银行logo(临时采用资源id)
    private String service;// 银行服务电话
    private boolean isDefault;// 是否为默认卡

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
        setCardNo(CardUtils.generageCardNo(pan));

        String bankName = BankInfo.getNameOfBank(pan);// 获取银行卡的信息
        if (!TextUtils.isEmpty(bankName)) {
            setBank(bankName);
            setBankInfo(bankName);
        }
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getSafeCode() {
        return safeCode;
    }

    public void setSafeCode(String safeCode) {
        this.safeCode = safeCode;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public int getLogoResId() {
        return logoResId;
    }

    public void setLogoResId(int logoResId) {
        this.logoResId = logoResId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    private void setBankInfo(String name) {
        String hotLine = "95516";
        int logoResId = R.drawable.logo_bank_default;
        if (name.contains("中国银行")) {
            hotLine = "95566";
        } else if (name.contains("工商银行")) {
            hotLine = "95588";
        } else if (name.contains("农业银行")) {
            hotLine = "95599";
        } else if (name.contains("建设银行")) {
            hotLine = "95533";
        } else if (name.contains("招商银行")) {
            hotLine = "95555";
            logoResId = R.drawable.logo_cmbc;
        } else if (name.contains("交通银行")) {
            hotLine = "95559";
        } else if (name.contains("邮政银行")) {
            hotLine = "95580";
        } else if (name.contains("光大银行")) {
            hotLine = "95595";
        } else if (name.contains("民生银行")) {
            hotLine = "95568";
        } else if (name.contains("上海银行")) {
            hotLine = "95594";
            logoResId = R.drawable.logo_shbc;
        } else if (name.contains("浦东发展银行")) {
            hotLine = "95528";
        }
        setService(hotLine);
        setLogoResId(logoResId);
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    // 中国银联服务热线：95516
    // 中国银行客服热线: 95566
    // 工商银行客服热线: 95588
    // 农业银行客服热线: 95599
    // 建设银行客服热线: 95533
    // 招商银行客服热线: 95555
    // 交通银行客服热线: 400-800-9888
    // 邮政银行客服热线: 95580
    // 光大银行客服热线: 95595
    // 徽商银行客服热线: 400-889-6588
    // 民生银行客服热线: 95568
    // 华夏银行客服热线: 95577
    // 浦东发展银行客服热线: 95528
    // 深圳发展银行客服热线: 95501
    // 北京银行客服热线: 95526
    // 恒丰银行客服电话: 400-813-8888
    // 邮储银行信用卡热线 400-889-5580
    // 深发展银行信用卡专线 400-669-5501
    // 建行信用卡中心客户热线 400-820-0588
    // 招行信用卡服务热线 400-820-5555
    // 招行企业年金热线 800-830-8855
    // 招行金葵花贵宾专线 400-889-5555
    // 招行钻石贵宾专线 400-689-5555

}
