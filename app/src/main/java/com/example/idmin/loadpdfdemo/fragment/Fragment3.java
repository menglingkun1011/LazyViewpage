package com.example.idmin.loadpdfdemo.fragment;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.idmin.loadpdfdemo.R;

/**
 * 作者：idmin on 2018/6/4 17:03
 */
public class Fragment3 extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment1;
    }

    @Override
    protected void loadData() {
        Log.d("AAAAAAAAAAA", "loadData: "+Fragment3.class.getSimpleName());

    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        ((TextView)view.findViewById(R.id.tv)).setText(Fragment3.class.getSimpleName());
        Log.d("AAAAAAAAAAA", "调用了onCreateView方法 "+Fragment3.class.getSimpleName());
    }

    @Override
    protected String getClassName() {
        return getClass().getSimpleName();
    }
}
