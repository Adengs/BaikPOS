package com.codelabs.konspirasisnack.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.ortiz.touchview.TouchImageView;

public class ExtendedViewPager extends ViewPager {
    public ExtendedViewPager(@NonNull Context context) {
        super(context);
    }

    public ExtendedViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected boolean canScroll(View view, boolean checkV, int dx, int x, int y){
        if (view instanceof TouchImageView){
            return ((TouchImageView)view).canScrollHorizontallyFroyo(-dx);
        }else {
            return super.canScroll(view,checkV,dx,x,y);
        }
    }
}
