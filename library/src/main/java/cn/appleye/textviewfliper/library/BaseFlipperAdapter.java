package cn.appleye.textviewfliper.library;

import android.view.View;

/**
 * @author Liu Liaopu
 * @date 2018/5/24
 * @description 适配器，用于提供必要的接口数据
 */
public abstract class BaseFlipperAdapter {
    /**
     * 两次item切换的间隔
     * */
    public static final int DEFAULT_FLIP_INTERVAL = 3000;

    /**
     * 获取动画持续时间
     * */
    public static final int DEFAULT_DURATION = 500;

    /**
     * 获取数据个数
     * @return 返回数据个数
     * */
    public abstract int getCount();

    /**
     * 获取当前要显示的控件
     * */
    public abstract View getView(View convertView, int position);

    /**
     * 获取item切换的间隔
     * */
    public int getFlipInterval(){
        return DEFAULT_FLIP_INTERVAL;
    }

    /**
     * 获取动画持续时间
     * */
    public int getAnimDuration(){
        return DEFAULT_DURATION;
    }

    /**
     * 只有一个item的时候，是否开启动画，默认false
     * */
    public boolean startWhenOnlyOne(){
        return false;
    }
}
