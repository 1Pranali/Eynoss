package com.ex.eynos.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;

import com.ex.eynos.R;
import com.ex.eynos.adapter.ViewPagerAdapter;
import com.ex.eynos.fragment.Dessign;
import com.ex.eynos.fragment.Fabric;

public class Dashboard extends AppCompatActivity
{
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        initviews();
        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);


    }

    public void initviews()
    {
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);

    }

    public void setViewPager(ViewPager viewpager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fabric(),"Fabric");
        adapter.addFragment(new Dessign(),"Design");
        viewpager.setAdapter(adapter);
    }
}
