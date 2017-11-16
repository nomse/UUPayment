package com.unionpay.payment.carpay.widget;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.data.Module;

public class ModuleGridAdapter extends BaseAdapter {

    private Context mContext;
    private List<Module> mModules = new ArrayList<Module>();

    public ModuleGridAdapter(Context context, List<Module> modules) {
        this.mContext = context;
        this.mModules = modules;
    }

    @Override
    public int getCount() {
        return mModules.size();
    }

    @Override
    public Object getItem(int position) {
        return mModules.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ModuleGridItemHolder gridItemHolder = null;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item_module, null);
            gridItemHolder = new ModuleGridItemHolder();
            gridItemHolder.moduleImg = (ImageView) convertView.findViewById(R.id.img_module);
            gridItemHolder.isNewImg = (ImageView) convertView.findViewById(R.id.img_new);
            gridItemHolder.moduleLabelText = (TextView) convertView.findViewById(R.id.label_module);
            convertView.setTag(gridItemHolder);
        } else {
            gridItemHolder = (ModuleGridItemHolder) convertView.getTag();
        }

        Module module = mModules.get(position);
        gridItemHolder.moduleImg.setImageResource(module.getIconResId());
        gridItemHolder.moduleLabelText.setText(module.getLableResId());

        if (module.isNew()) {
            gridItemHolder.isNewImg.setVisibility(View.VISIBLE);
        } else {
            gridItemHolder.isNewImg.setVisibility(View.GONE);
        }
        return convertView;
    }

    private class ModuleGridItemHolder {
        public ImageView moduleImg;
        public ImageView isNewImg;
        public TextView moduleLabelText;
    }
}
