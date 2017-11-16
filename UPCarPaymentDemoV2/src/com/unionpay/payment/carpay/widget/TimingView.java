package com.unionpay.payment.carpay.widget;

import com.unionpay.payment.carpay.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;




/**
 *
 * todo
 * 1.增加默认值,当前默认为0
 * 2.线程优化
 * 3.加按钮
 * 4.1的bug
 *
 */

public class TimingView extends LinearLayout {
    private int button_size;
    private Drawable itemBackground;
    private Drawable itemButtonBackground;
    private SparseArray<ImageView> timingArr;
    private int timingAccount;
    private Boolean runningStatus = false;
    private Boolean mInitializedFlag = false;
    public TimingView(Context context) {
        this(context, null);
    }

    public TimingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimingView);
        button_size = typedArray.getInteger(R.styleable.TimingView_size, 0);
        itemBackground = typedArray.getDrawable(R.styleable.TimingView_itemBackground);
        itemButtonBackground = typedArray.getDrawable(R.styleable.TimingView_itemButton);

        typedArray.recycle();
    }



    private Boolean isLeagal () {
        if (button_size <=0 ) {
            return false;
        }
        return true;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initTimingArr();
        initTimingView();
    }

    private void initTimingArr () {
        if (isLeagal()) {
            timingArr = new SparseArray<ImageView>();
        }
    }

    private void initTimingView () {
        Log.e("nms","init-timing-view");
        if (!isLeagal()) {
            return;
        }

        for (int buttonSize = button_size; buttonSize > 0; buttonSize--) {
            
            if(buttonSize==2){
            	ImageView imageView = new ImageView(this.getContext());
                imageView.setImageResource(R.drawable.calculagraph3);
                LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                addView(imageView, layoutParams);
            }else{
            	addButton();
            }
            ImageView imageView = new ImageView(this.getContext());
            imageView.setBackground(itemBackground);
            imageView.setTag(0);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            layoutParams.width = 100;
            addView(imageView, layoutParams);
            timingArr.put(buttonSize -1, imageView);
            replaceImage(buttonSize -1,-1);
        }
        addButton();
    }
    private void addButton () {
        ImageView imageView = new ImageView(this.getContext());
        imageView.setImageDrawable(itemButtonBackground);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(imageView, layoutParams);
    }
    private int getImageByNo (int no) {
        switch (no) {
            case 0:
                return R.drawable.zero;
            case 1:
                return R.drawable.one;
            case 2:
                return R.drawable.two;
            case 3:
                return R.drawable.three;
            case 4:
                return R.drawable.four;
            case 5:
                return R.drawable.five;
            case 6:
                return R.drawable.six;
            case 7:
                return R.drawable.seven;
            case 8:
                return R.drawable.eight;
            case 9:
                return R.drawable.nine;
            default:
                return R.drawable.zero;
        }
    }

    private void replaceAll () {

    }

    private void replaceImage(int index) {
        replaceImage(index, 0);
    }

    private void replaceImage(int index, final int defaultVal) {
        replaceImage(index,defaultVal, false);
    }
    private void replaceImage(int index, final int defaultVal,Boolean forceReload) {
        final ImageView imageView = timingArr.get(index);
        int tag = (Integer) imageView.getTag();
        if (tag != defaultVal && !forceReload) {
            final int imageSrc = getImageByNo(defaultVal);
            imageView.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageResource(imageSrc);
                    imageView.setScaleType(ScaleType.MATRIX);
                    imageView.setTag(defaultVal);
                }
            });
        }
    }

    private void needReplaceImage () {
        int tempVal = timingAccount;
        for (int i = 0; i < button_size; i++) {
            int i1 = tempVal % 10;
            replaceImage(i, i1);
            tempVal /= 10;
        }
    }

    public void startRunning () {
        if (runningStatus) {
            return;
        }
        runningStatus = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (runningStatus) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    timingAccount ++;
                    needReplaceImage();
                }

            }
        }).start();
    }
    public void stopRunning () {
        runningStatus = false;
    }
    public void resetTiming () {
        runningStatus = false;
        timingAccount = 0;
        for (int i = 0; i < button_size; i++) {
            replaceImage(i, 0);
        }
    }
    public int getRunningTime () {
        return timingAccount;
    }
}
