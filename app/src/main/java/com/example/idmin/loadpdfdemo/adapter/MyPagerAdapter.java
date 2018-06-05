package com.example.idmin.loadpdfdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 作者：mlk on 2017/12/16 16:53
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {


    private String[] titleArr;
    private List<Fragment> fragments;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] titleArr) {
        super(fm);
        this.fragments = fragments;
        this.titleArr = titleArr;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleArr[position % titleArr.length];
    }
}
