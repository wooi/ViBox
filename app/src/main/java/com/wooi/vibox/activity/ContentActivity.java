package com.wooi.vibox.activity;

import android.app.Activity;
import android.os.Bundle;

import com.wooi.vibox.R;

/**
 * Created by Administrator on 2015/9/16.
 */
public class ContentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
    }
}
