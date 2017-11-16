package com.unionpay.payment.carpay.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileUtils {

    /**
     * 校验手机号码格式是否正确
     * 
     * @param mobileNum
     * @return true为手机号码，false为无效手机号码
     */
    public static boolean isValidNumber(String mobileNum) {
        // Pattern p =
        // Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9]))\\d{8}$");
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        Matcher m = p.matcher(mobileNum);
        return m.matches();
    }


    /**
     * 手机号只显示后4位
     * 
     * @param phoneNo
     *            手机号
     * @return 返回如：*******8888
     */
    public static String maskMobileNo(String mobileNo) {
        StringBuffer buffer = new StringBuffer(mobileNo);
        int length = mobileNo.length();
        buffer.replace(3, length - 4, "****");
        return buffer.toString();
    }

}
