package cn.appleye.textviewfliper.library;

/**
 * @author Liu Liaopu
 * @date 2018/5/24
 * @description 上下滚动控件
 */
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * @author Liu Liaopu
 * @date 2018/5/23
 * @description
 */
public class TextViewFlipper extends FrameLayout {
    /**
     * 只保留2个控件，进行动画轮播
     * */
    private View mView1;
    private View mView2;

    private int mIndex = 0;

    private boolean mStarted;
    private boolean mRunning;

    private ValueAnimator mAnimator;

    private BaseFlipperAdapter mAdapter;

    private int mFlipInterval = BaseFlipperAdapter.DEFAULT_FLIP_INTERVAL;

    private int mAnimDuration = BaseFlipperAdapter.DEFAULT_DURATION;

    private final Runnable mFlipRunnable = new Runnable() {
        @Override
        public void run() {
            if (mRunning) {
                showNext();
                postDelayed(mFlipRunnable, mFlipInterval);
            }
        }
    };

    public TextViewFlipper(Context context) {
        this(context, null);
    }

    public TextViewFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 设置适配器，并且开始动画
     * */
    public void setFlipperAdapter(BaseFlipperAdapter adapter){
        mAdapter = adapter;

        if(adapter != null){
            initData();
        } else {
            stopFlipping();
        }
    }

    /**
     * 获取适配器
     * */
    public BaseFlipperAdapter getAdapter() {
        return mAdapter;
    }

    private void initData(){
        mFlipInterval = mAdapter.getFlipInterval();
        mAnimDuration = mAdapter.getAnimDuration();

        int count = mAdapter.getCount();

        if(count >= 1){
            mView1 = mAdapter.getView(mView1, 0);
        }

        if(count > 1){
            mView2 = mAdapter.getView(mView2, 1);
        }

        reset();

        if(count >= 1 && mView1 != null){
            mView1.setVisibility(VISIBLE);
        }
    }

    /**
     * 重置所有状态
     * */
    private void reset(){
        mStarted = false;
        mRunning = false;
        mIndex = 0;

        removeCallbacks(mFlipRunnable);

        if(mAnimator != null){
            mAnimator.cancel();
        }

        removeAllViews();

        if(mView1 != null){
            mView1.setVisibility(GONE);
            mView1.setTranslationY(0);
            mView1.setAlpha(1.0f);
            addView(mView1);
        }

        if(mView2 != null){
            mView2.setVisibility(GONE);
            mView2.setTranslationY(0);
            mView2.setAlpha(1.0f);
            addView(mView2);
        }
    }

    /**
     * 开始轮播
     * */
    public void startFlipping() {
        if(mAdapter==null || mAdapter.getCount() == 0){
            return;
        }

        if(mAdapter.getCount() == 1 && !mAdapter.startWhenOnlyOne()){
            return;
        }
        mStarted = true;
        updateRunning();
    }

    /**
     * 结束轮播
     * */
    public void stopFlipping() {
        mStarted = false;
        updateRunning();
    }

    private void updateRunning() {
        boolean running = mStarted;
        if (running != mRunning) {
            if (running) {
                showOnly();
                postDelayed(mFlipRunnable, mFlipInterval);
            } else {
                removeCallbacks(mFlipRunnable);
                if(mAnimator != null){
                    mAnimator.cancel();
                }
            }
            mRunning = running;
        }
    }

    /**
     * 开始动画
     * */
    private void showOnly() {
        if(mAnimator == null){
            mAnimator = ValueAnimator.ofFloat(0f, 1.0f);
            mAnimator.setDuration(mAnimDuration);
            mAnimator.setRepeatCount(0);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float value = (float)valueAnimator.getAnimatedValue();

                    int count = getChildCount();
                    int childIndex = mIndex % 2;
                    for (int i = 0; i < count; i++) {
                        final View child = getChildAt(i);
                        if (i == childIndex) {
                            child.setAlpha(value);
                            child.setTranslationY(getHeight()*(1-value));
                            child.setVisibility(View.VISIBLE);
                        } else {
                            if(child.getVisibility() == VISIBLE){
                                child.setAlpha(1 - value);
                                child.setTranslationY(- getHeight()*value);
                            }
                        }
                    }
                }
            });
        }

        mAnimator.start();
    }

    public void showNext() {
        setDisplayedChild(mIndex + 1);
    }

    /**
     * 设置特定View的值
     * */
    private void setDisplayedChild(int whichChild) {
        mIndex = whichChild;
        if (whichChild >= mAdapter.getCount()) {
            mIndex = 0;
        } else if (whichChild < 0) {
            mIndex = mAdapter.getCount() - 1;
        }

        if(mIndex % 2 == 0){
            View tempView = mAdapter.getView(mView1, mIndex);
            //如果属于重新创建的控件，则需要重新添加
            if(tempView.getParent() != this){
                removeView(mView1);
                addView(tempView, 0);
            }

            mView1 = tempView;
        } else {
            View tempView = mAdapter.getView(mView2, mIndex);
            //如果属于重新创建的控件，则需要重新添加
            if(tempView.getParent() != this){
                removeView(mView2);
                addView(tempView, 1);
            }

            mView2 = tempView;
        }

        boolean hasFocus = getFocusedChild() != null;
        // This will clear old focus if we had it
        showOnly();
        if (hasFocus) {
            // Try to retake focus if we had it
            requestFocus(FOCUS_FORWARD);
        }
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }
}
