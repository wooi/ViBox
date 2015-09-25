package com.wooi.vibox.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/9/25.
 */
public class UserVPAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> listFragment;
    private Context context;
    private String[] tabTitle = {"微博","相册"};
    public UserVPAdapter(FragmentManager fm,List<Fragment> listFragment,Context context) {
        super(fm);
        this.context = context;
        this.listFragment = listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitle[position];
    }
}
