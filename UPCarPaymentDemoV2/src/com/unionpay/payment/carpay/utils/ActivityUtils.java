package com.unionpay.payment.carpay.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.unionpay.payment.carpay.activity.CardAddActivity;
import com.unionpay.payment.carpay.activity.CardAddDoneActivity;
import com.unionpay.payment.carpay.activity.CardAddInfoActivity;
import com.unionpay.payment.carpay.activity.CardDetailsActivity;
import com.unionpay.payment.carpay.activity.CardTransDetailsActivity;
import com.unionpay.payment.carpay.activity.CommonActivity;
import com.unionpay.payment.carpay.activity.CommonWebActivity;
import com.unionpay.payment.carpay.activity.ShoppingEntryActivity;
import com.unionpay.payment.carpay.activity.ShoppingGoodsDetailActivity;
import com.unionpay.payment.carpay.activity.ShoppingOrderActivity;
import com.unionpay.payment.carpay.constant.Constant;

public class ActivityUtils {

    @SuppressLint("NewApi")
    public static void setWindowStatusBarColor(Activity activity, int colorResId) {
        try {
            if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                        | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                window.getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setNavigationBarColor(Color.TRANSPARENT);

                window.setStatusBarColor(colorResId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void finishActivity() {
        String curActivityName = AppActivityManager.getInstance().currentActivity().getClass()
                .getSimpleName();
        if (curActivityName.equals(CardAddInfoActivity.class.getSimpleName())) {
            AppActivityManager.getInstance().finishCurrentActivity();
        }
        if (curActivityName.equals(ShoppingOrderActivity.class.getSimpleName())) {
            AppActivityManager.getInstance().finishCurrentActivity();
        }
        AppActivityManager.getInstance().finishCurrentActivity();
    }

    public static void exitApplication(Context context) {
        AppActivityManager.getInstance().exitApp(context);
    }

    public static void showAddCardActivity(Context context) {
        Intent intent = new Intent(context, CardAddActivity.class);
        context.startActivity(intent);
    }

    public static void showAddCardInfoActivity(Context context) {
        Intent intent = new Intent(context, CardAddInfoActivity.class);
        context.startActivity(intent);
    }

    public static void showAddCardDoneActivity(Context context) {
        Intent intent = new Intent(context, CardAddDoneActivity.class);
        context.startActivity(intent);
        finishActivity();
    }

    public static void showCardDetailsActivity(Context context) {
        Intent intent = new Intent(context, CardDetailsActivity.class);
        context.startActivity(intent);
    }

    public static void showCardTransDetailsActivity(Context context) {
        Intent intent = new Intent(context, CardTransDetailsActivity.class);
        context.startActivity(intent);
    }

    public static void callPhoneApplication(Context context, String mobile) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + mobile));
        context.startActivity(intent);
    }

    public static void showCommonActivity(Context context, String title) {
        Intent intent = new Intent(context, CommonActivity.class);
        intent.putExtra(Constant.KEY.TITLE, title);
        context.startActivity(intent);
    }

    public static void showCommonWebActivity(Context context, String title, String url) {
        Intent intent = new Intent(context, CommonWebActivity.class);
        intent.putExtra(Constant.KEY.TITLE, title);
        intent.putExtra(Constant.KEY.URL, url);
        context.startActivity(intent);
    }

    public static void showShoppingEntryActivity(Context context) {
        Intent intent = new Intent(context, ShoppingEntryActivity.class);
        context.startActivity(intent);
    }

    public static void showGoodsDetailActivity(Context context) {
        Intent intent = new Intent(context, ShoppingGoodsDetailActivity.class);
        context.startActivity(intent);
    }

    public static void showOrderActivity(Context context) {
        Intent intent = new Intent(context, ShoppingOrderActivity.class);
        context.startActivity(intent);
    }
}
