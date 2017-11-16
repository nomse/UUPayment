package com.unionpay.payment.carpay.widget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.utils.CardUtils;

public class BankCardListAdapter extends BaseAdapter {

    private Context mContext;
    private List<BankCard> mBandCards = new ArrayList<BankCard>();

    public BankCardListAdapter(Context context, List<BankCard> bankcards) {
        this.mContext = context;
        this.mBandCards = bankcards;
    }

    @Override
    public int getCount() {
        return mBandCards.size();
    }

    @Override
    public Object getItem(int position) {
        return mBandCards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BankCardListItemHolder listItemHolder = null;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_card, null);
            listItemHolder = new BankCardListItemHolder();
            listItemHolder.bankcardIcon = (ImageView) convertView.findViewById(R.id.img_bank_icon);
            listItemHolder.bankcardNameText = (TextView) convertView
                    .findViewById(R.id.text_bank_name);
            listItemHolder.bankcardPanText = (TextView) convertView
                    .findViewById(R.id.text_bank_pan);
            listItemHolder.defaultCardText = (TextView) convertView
                    .findViewById(R.id.text_bank_defult);
            listItemHolder.bankcardLogoImg = (ImageView) convertView
                    .findViewById(R.id.img_bank_logo);
            listItemHolder.bankisDefaultImg = (ImageView) convertView
                    .findViewById(R.id.img_bank_defult);
            convertView.setTag(listItemHolder);
        } else {
            listItemHolder = (BankCardListItemHolder) convertView.getTag();
        }

        BankCard bankcard = mBandCards.get(position);
        listItemHolder.bankcardNameText.setText(bankcard.getBank());
        listItemHolder.bankcardPanText.setText(CardUtils.formatCardNum(CardUtils
                .maskCardNum(bankcard.getPan())));
        listItemHolder.bankcardLogoImg.setImageDrawable(mContext.getResources().getDrawable(
                bankcard.getLogoResId()));
        // listItemHolder.bankisDefaultImg.setVisibility(bankcard.isDefault() ?
        // View.VISIBLE
        // : View.GONE);
        listItemHolder.defaultCardText.setVisibility(bankcard.isDefault() ? View.VISIBLE
                : View.GONE);

        return convertView;
    }

    private class BankCardListItemHolder {
        public ImageView bankcardIcon;
        public TextView bankcardNameText;
        public TextView bankcardPanText;
        public TextView defaultCardText;
        public ImageView bankisDefaultImg;
        public ImageView bankcardLogoImg;
    }

}
