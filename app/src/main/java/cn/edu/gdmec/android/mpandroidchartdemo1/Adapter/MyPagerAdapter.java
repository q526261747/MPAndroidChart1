package cn.edu.gdmec.android.mpandroidchartdemo1.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 52626 on 2017/12/6.
 */

public class MyPagerAdapter extends PagerAdapter {
    protected Context mContext;
    private List<View> mViews;

    public MyPagerAdapter(Context context, List<View> views) {
        mContext = context;
        mViews = views;
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViews.get(position));
        return mViews.get(position);
    }
}
