package com.welot.newsdemomd.mvp.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.welot.newsdemomd.R;
import com.welot.newsdemomd.mvp.ui.adapter.TitleTabAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

//只进行了View的操作
public class FragmentLingGan extends BaseFragment {


    private static final String TYPE1 = null;

    private static final String TYPE2 = "shouxiemeiju";

    private static final String TYPE3 = "jingdianduibai";

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private View view;

    private Unbinder unbinder;

    //只进行了View的展示操作  并没有进行数据得操作
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_meiju, container, false);
        }
        unbinder = ButterKnife.bind(this, view);
        initControls();
        return view;
    }

    private void initControls() {
        //初始化各fragment
        FragmentLingGanList fragmentMeijuList1 = FragmentLingGanList.newInstance(TYPE1);
        FragmentLingGanList fragmentMeijuList2 = FragmentLingGanList.newInstance(TYPE2);
        FragmentLingGanList fragmentMeijuList3 = FragmentLingGanList.newInstance(TYPE3);
        //将fragment装进列表中
        List<Fragment> list_fragment = new ArrayList<>();
        list_fragment.add(fragmentMeijuList1);
        list_fragment.add(fragmentMeijuList2);
        list_fragment.add(fragmentMeijuList3);
        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        List<String> list_title = new ArrayList<>();
        list_title.add("美图美句");
        list_title.add("手写句子");
        list_title.add("经典对白");
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(2)));
        TitleTabAdapter titleTabAdapter = new TitleTabAdapter(getChildFragmentManager(), list_fragment, list_title);
        //viewpager加载adapter
        viewPager.setAdapter(titleTabAdapter);
        tabLayout.setupWithViewPager(viewPager);//联动
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
