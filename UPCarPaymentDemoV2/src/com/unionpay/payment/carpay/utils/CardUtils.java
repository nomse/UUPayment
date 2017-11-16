package com.unionpay.payment.carpay.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import android.text.TextUtils;

public class CardUtils {

    public static String formatCardNum(String cardNum) {
        if (!TextUtils.isEmpty(cardNum) && cardNum.length() <= 19) {
            // 卡号中间含有空格 即认为格式化过
            cardNum = cardNum.trim();
            String num = cardNum.replaceAll(" ", "");
            if (num.length() != cardNum.length()) {
                return cardNum;
            }
            StringBuffer cardNumBuffer = new StringBuffer();
            for (int i = 0; i < cardNum.length(); i += 4) {
                if (i + 4 > cardNum.length()) {
                    cardNumBuffer.append(cardNum.substring(i, cardNum.length()));
                    break;
                }
                cardNumBuffer.append(cardNum.substring(i, i + 4));
                cardNumBuffer.append(" ");
            }
            return cardNumBuffer.toString().trim();
        }
        return cardNum;
    }

    public static String formatExpireDate(String expireDateYYMMDD) {
        String expireDateMMYY = expireDateYYMMDD;
        if (expireDateYYMMDD != null && expireDateYYMMDD.length() == 6) {
            expireDateMMYY = expireDateYYMMDD.substring(2, 4) + "/"
                    + expireDateYYMMDD.substring(0, 2);
        }
        return expireDateMMYY;
    }

    /**
     * 卡号显示前五位后四位，其他换成*
     * 
     * @param cardNum
     *            银行卡号
     * @return 格式化的银行卡号，如：62228**********8888
     */
    public static String maskCardNum1(String cardNum) {
        int length = cardNum.length();
        StringBuffer buffer = new StringBuffer(cardNum);
        buffer.replace(5, length - 4, "*******");
        return buffer.toString();
    }

    /**
     * 卡号显示后四位，其他换成*
     * 
     * @param cardNum
     *            银行卡号
     * @return 格式化的银行卡号，如：**********8888
     */
    public static String maskCardNum(String cardNum) {
        int length = cardNum.length();
        StringBuffer buffer = new StringBuffer(cardNum);
        buffer.replace(0, length - 4, "****");
        return buffer.toString();
    }

    /**
     * 校验银行卡卡号
     * 
     * @param cardId
     * @return true为银行卡，false为非银行卡
     */
    public static boolean isValidBankCard(String cardId) {
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     * 
     * @param nonCheckCodeCardId
     * @return
     */
    private static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            // 如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    public static String generageCardNo(String pan) {
        Random random = new Random();
        int r = random.nextInt(19);
        SimpleDateFormat df = new SimpleDateFormat("HHmmssSSS", Locale.getDefault());
        return pan.substring(pan.length() - 2) + df.format(new Date()) + r / 2;
    }

}
