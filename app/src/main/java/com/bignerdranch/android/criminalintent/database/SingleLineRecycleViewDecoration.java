package com.bignerdranch.android.criminalintent.database;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bignerdranch.android.criminalintent.R;

/**
 * <pre>
 *     author : tree_root
 *     e-mail : xxx@xx
 *     time   : 2018/06/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class SingleLineRecycleViewDecoration extends RecyclerView.ItemDecoration{

    private int lineHeight;
    private Paint mPaint;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public SingleLineRecycleViewDecoration(Context context){
        mPaint = new Paint();
        mPaint.setColor(context.getResources().getColor(R.color.colorPrimary , null));

        lineHeight = (int) context.getResources().getDimension(R.dimen.spacing_1);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = lineHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount - 1; i++){
            View view = parent.getChildAt(i);
            int top = view.getBottom();
            int bottom = view.getBottom() + lineHeight;

            c.drawRect(left, top , right, bottom, mPaint);
        }
    }
}
