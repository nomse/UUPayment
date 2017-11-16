package com.unionpay.payment.carpay.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.base.PaymentBaseActivity;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.data.TransRecord;
import com.unionpay.payment.carpay.utils.CardUtils;
import com.unionpay.payment.carpay.utils.DatetimeUtil;

public class CardTransDetailsActivity extends PaymentBaseActivity {

    private BankCard mBankCard;
    private TextView mBankPanText;
    private TextView mLastTransTimeText;
    private TextView mLastTransAmountText;
    private View mLastTransView;
    private TextView mBenefitBankText;
    private TextView mBenefitContentText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_trans_details);
    }

    @Override
    protected void initView() {
        mLastTransView = findViewById(R.id.layout_last_trans);
        mBankPanText = (TextView) findViewById(R.id.text_bank_pan);
        mLastTransTimeText = (TextView) findViewById(R.id.text_last_trans_time);
        mLastTransAmountText = (TextView) findViewById(R.id.text_last_trans_amount);
        mBenefitBankText = (TextView) findViewById(R.id.text_trans_dtl_info_bank);
        mBenefitContentText = (TextView) findViewById(R.id.text_trans_dtl_info_content);
    }

    @Override
    protected void initData() {
        mBankCard = DataMock.getInstance().getCurBankCard();
        String pan = mBankCard.getPan();
        mBankPanText.setText(CardUtils.formatCardNum(CardUtils.maskCardNum(pan)));

        TransRecord lastTransRecord = DataMock.getInstance().getLastTransRecord(pan);
        if (lastTransRecord != null) {
            mLastTransView.setVisibility(View.VISIBLE);
            mLastTransTimeText.setText(DatetimeUtil.getFormatTime("yyyy/MM/dd HH:mm",
                    lastTransRecord.getTransTime()));
            mLastTransAmountText.setText(String.format("￥%s", lastTransRecord.getAmount()));
        } else {
            mLastTransView.setVisibility(View.GONE);
        }

        String bank = mBankCard.getBank();
        mBenefitBankText
                .setText(String.format(getString(R.string.label_trans_dtl_info_bank), bank));
        if (bank.contains("招商银行")) {
            mBenefitContentText.setText(getString(R.string.label_trans_dtl_info_cmcc));
        } else if (bank.contains("上海银行")) {
            mBenefitContentText.setText(getString(R.string.label_trans_dtl_info_shbank));
        } else {
            mBenefitContentText.setText(String.format(
                    getString(R.string.label_trans_dtl_info_content), bank));
        }
    }

}
