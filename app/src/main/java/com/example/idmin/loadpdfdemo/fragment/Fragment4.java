package com.example.idmin.loadpdfdemo.fragment;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.idmin.loadpdfdemo.R;

/**
 * 作者：idmin on 2018/6/4 17:03
 */
public class Fragment4 extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment1;
    }

    @Override
    protected void loadData() {
        Log.d("AAAAAAAAAAA", "loadData: "+Fragment4.class.getSimpleName());

    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        ((TextView)view.findViewById(R.id.tv)).setText(Fragment4.class.getSimpleName());
        Log.d("AAAAAAAAAAA", "调用了onCreateView方法 "+Fragment4.class.getSimpleName());
    }

    @Override
    protected String getClassName() {
        return getClass().getSimpleName();
    }
}
