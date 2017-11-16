package com.unionpay.payment.carpay.data;

import java.io.Serializable;

/**
 * 交易记录信息
 * 
 */
public class TransRecord implements Serializable {

    private static final long serialVersionUID = -863342822079759657L;

    private int id;// 索引
    private long transTime;// 交易时间
    private int type;// 交易类型
    private String amount;// 交易金额
    private String desc;// 交易备注
    private String cardPan;// 交易卡号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTransTime() {
        return transTime;
    }

    public void setTransTime(long transTime) {
        this.transTime = transTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCardPan() {
        return cardPan;
    }

    public void setCardPan(String cardPan) {
        this.cardPan = cardPan;
    }

}
