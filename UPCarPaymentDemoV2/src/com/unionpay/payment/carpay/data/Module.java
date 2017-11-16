package com.unionpay.payment.carpay.data;

import com.unionpay.payment.carpay.R;

public class Module {

    private static final int MODULE_START = 0;
    public static final int MODULE_1 = MODULE_START + 1;
    public static final int MODULE_2 = MODULE_START + 2;
    public static final int MODULE_3 = MODULE_START + 3;
    public static final int MODULE_4 = MODULE_START + 4;
    public static final int MODULE_5 = MODULE_START + 5;
    public static final int MODULE_6 = MODULE_START + 6;

    private int moduleId;
    private int iconResId;
    private int lableResId;
    private boolean isNew;

    public Module(int moduleId) {
        this(moduleId, false);
    }

    public Module(int moduleId, boolean isNew) {
        this.moduleId = moduleId;
        this.isNew = isNew;
        getModuleInfo(moduleId);
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public int getLableResId() {
        return lableResId;
    }

    public void setLableResId(int lableResId) {
        this.lableResId = lableResId;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    private void getModuleInfo(int moduleId) {
        switch (moduleId) {
        case MODULE_1:
            iconResId = R.drawable.ic_module_du;
            lableResId = R.string.module_label_1;
            break;
        case MODULE_2:
            iconResId = R.drawable.ic_module_highway;
            lableResId = R.string.module_label_2;
            break;
        case MODULE_3:
            iconResId = R.drawable.ic_module_shopping;
            lableResId = R.string.module_label_3;
            break;
        case MODULE_4:
            iconResId = R.drawable.ic_module_charge;
            lableResId = R.string.module_label_4;
            break;
        case MODULE_5:
            iconResId = R.drawable.ic_module_park;
            lableResId = R.string.module_label_5;
            break;
        case MODULE_6:
            iconResId = R.drawable.ic_module_etc;
            lableResId = R.string.module_label_6;
            break;
        }
    }

}
