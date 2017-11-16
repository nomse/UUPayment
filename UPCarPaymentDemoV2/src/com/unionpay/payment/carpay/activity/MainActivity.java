package com.unionpay.payment.carpay.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.fragment.TabCardFragment;
import com.unionpay.payment.carpay.fragment.TabHomeFragment;
import com.unionpay.payment.carpay.fragment.TabTransFragment;
import com.unionpay.payment.carpay.utils.ActivityUtils;

public class MainActivity extends FragmentActivity implements OnClickListener {

    private final static int TAB_ID_HOME = 0;
    private final static int TAB_ID_CARD = 1;
    private final static int TAB_ID_TRANS = 2;

    private TabHomeFragment mTabHomeFragment;
    private TabCardFragment mTabCardFragment;
    private TabTransFragment mTabTransFragment;

    private LinearLayout mHomeTabLayout;
    private LinearLayout mCardTabLayout;
    private LinearLayout mTransTabLayout;

    private ImageView mHomeImgView;
    private ImageView mCardImgView;
    private ImageView mTransImgView;

    private TextView mHomeTextView;
    private TextView mCardTextView;
    private TextView mTransTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        setTabSelection(TAB_ID_HOME);
    }

    private void initViews() {
        mHomeTabLayout = (LinearLayout) findViewById(R.id.layout_tab_home);
        mCardTabLayout = (LinearLayout) findViewById(R.id.layout_tab_card);
        mTransTabLayout = (LinearLayout) findViewById(R.id.layout_tab_trans);
        mHomeImgView = (ImageView) findViewById(R.id.imgview_tab_home);
        mCardImgView = (ImageView) findViewById(R.id.imgview_tab_card);
        mTransImgView = (ImageView) findViewById(R.id.imgview_tab_trans);
        mHomeTextView = (TextView) findViewById(R.id.text_tab_home);
        mCardTextView = (TextView) findViewById(R.id.text_tab_card);
        mTransTextView = (TextView) findViewById(R.id.text_tab_trans);

        mHomeTabLayout.setOnClickListener(this);
        mCardTabLayout.setOnClickListener(this);
        mTransTabLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.layout_tab_home:
            setTabSelection(TAB_ID_HOME);
            break;
        case R.id.layout_tab_card:
            setTabSelection(TAB_ID_CARD);
            break;
        case R.id.layout_tab_trans:
            setTabSelection(TAB_ID_TRANS);
            break;

        default:
            break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            ActivityUtils.exitApplication(this);
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @SuppressLint("NewApi")
    private void setTabSelection(int index) {
        resetImg();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        switch (index) {
        case TAB_ID_HOME:
            mHomeImgView.setImageResource(R.drawable.ic_tab_home_foucs);
            mHomeTextView.setTextColor(getResources().getColor(R.color.tab_foucs));
            if (mTabHomeFragment == null) {
                mTabHomeFragment = new TabHomeFragment();
                addFragment(transaction, mTabHomeFragment);
            } else {
                transaction.show(mTabHomeFragment);
            }
            break;
        case TAB_ID_CARD:
            mCardImgView.setImageResource(R.drawable.ic_tab_card_foucs);
            mCardTextView.setTextColor(getResources().getColor(R.color.tab_foucs));
            if (mTabCardFragment == null) {
                mTabCardFragment = new TabCardFragment();
                addFragment(transaction, mTabCardFragment);
            } else {
                transaction.show(mTabCardFragment);
            }
            break;
        case TAB_ID_TRANS:
            mTransImgView.setImageResource(R.drawable.ic_tab_trans_foucs);
            mTransTextView.setTextColor(getResources().getColor(R.color.tab_foucs));
            if (mTabTransFragment == null) {
                mTabTransFragment = new TabTransFragment();
                addFragment(transaction, mTabTransFragment);
            }
            transaction.show(mTabTransFragment);
            break;
        }
        transaction.commit();
    }

    private void resetImg() {
        mHomeImgView.setImageResource(R.drawable.ic_tab_home_normal);
        mCardImgView.setImageResource(R.drawable.ic_tab_card_normal);
        mTransImgView.setImageResource(R.drawable.ic_tab_trans_normal);
        mHomeTextView.setTextColor(getResources().getColor(R.color.tab_normal));
        mCardTextView.setTextColor(getResources().getColor(R.color.tab_normal));
        mTransTextView.setTextColor(getResources().getColor(R.color.tab_normal));
    }

    private void addFragment(FragmentTransaction transaction, Fragment fragment) {
        transaction.add(R.id.fragment_content, fragment);
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mTabHomeFragment != null) {
            transaction.hide(mTabHomeFragment);
        }
        if (mTabCardFragment != null) {
            transaction.hide(mTabCardFragment);
        }
        if (mTabTransFragment != null) {
            transaction.hide(mTabTransFragment);
        }
    }

}
