package com.wooi.vibox.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.wooi.vibox.fragment.CommentsByMeFragment;
import com.wooi.vibox.fragment.ContentFragment;
import com.wooi.vibox.fragment.FavoritesFragment;
import com.wooi.vibox.fragment.TestFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/9.
 */
public class ContentVPAdapter extends FragmentPagerAdapter {
    private final int NUM_ITEMS = 3;
    public static final int CONTENTFRAGMENT = 0;
    public static final int COMMENTSFRAGMENT = 1;
    public static final int FAVORITESFRAGMENT = 2;

    public ContentVPAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case CONTENTFRAGMENT:
                return ContentFragment.newInstance(0, "ContentPage");
            case COMMENTSFRAGMENT:
                return CommentsByMeFragment.newInstance(1, "CommentPage");
            case FAVORITESFRAGMENT:
                return TestFragment.newInstance(2, "FavoritesPage");
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
