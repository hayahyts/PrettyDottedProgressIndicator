package com.hayahyts.dottedprogressindicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

public class DottedProgressBar extends LinearLayout {

    private static final float FULL_SCALE = 1f;
    private static final float HALF_SCALE = 0.6f;
    private static final int DURATION_IMMEDIATE = 0;
    private static final int SCALE_ANIMATION_DEFAULT_DURATION = 300;

    private static final DecelerateInterpolator DEFAULT_INTERPOLATOR = new DecelerateInterpolator();

    @ColorInt
    private int mUnselectedColor;

    @ColorInt
    private int mSelectedColor;

    private int mDotCount;

    private int mCurrent;

    public DottedProgressBar(Context context) {
        this(context, null);
    }

    public DottedProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DottedProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mSelectedColor = ContextCompat.getColor(context, R.color.selectedColor);
        mUnselectedColor = ContextCompat.getColor(context, R.color.unselectedColor);
    }

    public void setUnselectedColor(@ColorInt int unselectedColor) {
        this.mUnselectedColor = unselectedColor;
    }

    public void setSelectedColor(@ColorInt int selectedColor) {
        this.mSelectedColor = selectedColor;
    }

    public void setDotCount(int dotCount) {
        this.mDotCount = dotCount;
        removeAllViews();
        for (int i = 0; i < dotCount; i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.ms_dot, this, false);
            addView(view);
        }
        setCurrent(0, false);
    }

    /**
     * Changes the currently selected dot and updates the UI accordingly
     * @param current the new currently selected dot
     * @param shouldAnimate true if the change should be animated, false otherwise
     */
    public void setCurrent(int current, boolean shouldAnimate) {
        this.mCurrent = current;
        update(shouldAnimate);
    }

    private void update(boolean shouldAnimate) {
        for (int i = 0; i < mDotCount; i++) {
            if (i == mCurrent) {
                getChildAt(i).animate()
                        .scaleX(FULL_SCALE)
                        .scaleY(FULL_SCALE)
                        .setDuration(shouldAnimate ? SCALE_ANIMATION_DEFAULT_DURATION : DURATION_IMMEDIATE)
                        .setInterpolator(DEFAULT_INTERPOLATOR)
                        .start();
                colorChildAtPosition(i, true);
            } else {
                getChildAt(i).animate()
                        .scaleX(HALF_SCALE)
                        .scaleY(HALF_SCALE)
                        .setDuration(shouldAnimate ? SCALE_ANIMATION_DEFAULT_DURATION : DURATION_IMMEDIATE)
                        .setInterpolator(DEFAULT_INTERPOLATOR)
                        .start();
                colorChildAtPosition(i, false);
            }
        }
    }

    private void colorChildAtPosition(int i, boolean selected) {
        Drawable d = getChildAt(i).getBackground();
        TintUtil.tintDrawable(d, selected ? mSelectedColor : mUnselectedColor);
    }

}