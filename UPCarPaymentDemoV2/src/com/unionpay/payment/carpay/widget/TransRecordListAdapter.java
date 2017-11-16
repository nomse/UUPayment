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
import com.unionpay.payment.carpay.data.Module;
import com.unionpay.payment.carpay.data.TransRecord;
import com.unionpay.payment.carpay.utils.DatetimeUtil;

public class TransRecordListAdapter extends BaseAdapter {

    private Context mContext;
    private List<TransRecord> mTransRecords = new ArrayList<TransRecord>();

    public TransRecordListAdapter(Context context, List<TransRecord> transRecords) {
        this.mContext = context;
        this.mTransRecords = transRecords;
    }

    @Override
    public int getCount() {
        return mTransRecords.size();
    }

    @Override
    public Object getItem(int position) {
        return mTransRecords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TransRecordListItemHolder listItemHolder = null;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_trans_record,
                    null);
            listItemHolder = new TransRecordListItemHolder();
            listItemHolder.transTimeText = (TextView) convertView
                    .findViewById(R.id.text_trans_time);
            listItemHolder.transAmountText = (TextView) convertView
                    .findViewById(R.id.text_trans_amount);
            listItemHolder.transDescText = (TextView) convertView
                    .findViewById(R.id.text_trans_desc);
            listItemHolder.transTypeImg = (ImageView) convertView.findViewById(R.id.img_trans_type);
            convertView.setTag(listItemHolder);
        } else {
            listItemHolder = (TransRecordListItemHolder) convertView.getTag();
        }

        TransRecord transRecord = mTransRecords.get(position);
        listItemHolder.transTimeText.setText(DatetimeUtil.getFormatTime("MM/dd HH:mm",
                transRecord.getTransTime()));
        listItemHolder.transAmountText.setText(transRecord.getAmount());
        listItemHolder.transDescText.setText(transRecord.getDesc());
        int type = transRecord.getType();
        switch (type) {
        case Module.MODULE_1:
            listItemHolder.transTypeImg.setImageDrawable(mContext.getResources().getDrawable(
                    R.drawable.ic_module_du));
            break;
        case Module.MODULE_2:
            listItemHolder.transTypeImg.setImageDrawable(mContext.getResources().getDrawable(
                    R.drawable.ic_module_highway));
            break;
        case Module.MODULE_3:
            listItemHolder.transTypeImg.setImageDrawable(mContext.getResources().getDrawable(
                    R.drawable.ic_module_shopping));
            break;
        case Module.MODULE_4:
            listItemHolder.transTypeImg.setImageDrawable(mContext.getResources().getDrawable(
                    R.drawable.ic_module_charge));
            break;
        case Module.MODULE_5:
            listItemHolder.transTypeImg.setImageDrawable(mContext.getResources().getDrawable(
                    R.drawable.ic_module_park));
            break;
        case Module.MODULE_6:
            listItemHolder.transTypeImg.setImageDrawable(mContext.getResources().getDrawable(
                    R.drawable.ic_module_etc));
            break;

        default:
            break;
        }

        return convertView;
    }

    private class TransRecordListItemHolder {
        public TextView transTimeText;
        public TextView transAmountText;
        public TextView transDescText;
        public ImageView transTypeImg;
    }

}
