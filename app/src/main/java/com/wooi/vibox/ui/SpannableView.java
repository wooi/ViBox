package com.wooi.vibox.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/10/14.
 */
public class SpannableView extends TextView {
    public SpannableView(Context context) {
        super(context);
    }

    public SpannableView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpannableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SpannableView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

}
