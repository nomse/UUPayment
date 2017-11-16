package com.unionpay.payment.carpay.utils;

import java.util.Stack;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

public class AppActivityManager {

    private static Stack<Activity> mActivityStack = new Stack<Activity>();
    private static AppActivityManager mInstance;

    private AppActivityManager() {
    }

    public static AppActivityManager getInstance() {
        if (mInstance == null) {
            mInstance = new AppActivityManager();
        }
        return mInstance;
    }

    public void addActivity(Activity activity) {
        mActivityStack.push(activity);
    }

    public Activity currentActivity() {
        return mActivityStack.lastElement();
    }

    public void finishCurrentActivity() {
        if (mActivityStack.size() > 0) {
            Activity activity = mActivityStack.pop();
            activity.finish();
        }
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public void finishActivity(Class<?> cls) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    public void finishAllActivity() {
        for (Activity activity : mActivityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
        mActivityStack.clear();
    }

    public void exitApp(Context context) {
        try {
            finishAllActivity();
            ActivityManager manager = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            manager.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
