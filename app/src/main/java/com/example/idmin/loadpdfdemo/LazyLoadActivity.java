package com.example.idmin.loadpdfdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.idmin.loadpdfdemo.adapter.MyPagerAdapter;
import com.example.idmin.loadpdfdemo.fragment.Fragment1;
import com.example.idmin.loadpdfdemo.fragment.Fragment2;
import com.example.idmin.loadpdfdemo.fragment.Fragment3;
import com.example.idmin.loadpdfdemo.fragment.Fragment4;

import java.util.ArrayList;
import java.util.List;


public class LazyLoadActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] titleArr = {"推荐","热点","上海","食品"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_load);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),fragments,titleArr));

        for (int i = 0; i < titleArr.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(titleArr[i]);
            tabLayout.addTab(tab);
        }

        // 使用 TabLayout 和 ViewPager 相关联
        tabLayout.setupWithViewPager(viewPager);
    }
}
