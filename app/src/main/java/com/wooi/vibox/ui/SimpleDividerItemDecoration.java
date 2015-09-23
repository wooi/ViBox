package com.wooi.vibox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wooi.vibox.R;

/**
 * Created by Administrator on 2015/9/23.
 */
public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable drawable;
    public SimpleDividerItemDecoration(Context context) {
        super();
        drawable = context.getResources().getDrawable(R.drawable.line_divider);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth()-parent.getPaddingRight();
        left += right/7;
        right -= right/14;
        int childCount = parent.getChildCount();
        for (int i = 0;i<childCount;i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            int top= child.getBottom()+ params.bottomMargin;
            int bottom = top+drawable.getIntrinsicHeight();
            drawable.setBounds(left,top,right,bottom);
            drawable.draw(c);
        }
    }
}
