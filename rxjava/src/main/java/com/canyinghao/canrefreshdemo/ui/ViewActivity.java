package com.canyinghao.canrefreshdemo.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.sf.rxjava.R;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewActivity extends AppCompatActivity {

    @Bind(R.id.cd)
    View cd;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pager2);
        ButterKnife.bind(this);
        toolbar.setTitle("RxJava");
        if (viewPager != null) {
            setViewPager(viewPager);
        }
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * viewPager 设置适配器
     * @param viewPager
     */
    private void setViewPager(ViewPager viewPager){
        adapter = new Adapter(getSupportFragmentManager());
        String[] titleArr = getResources().getStringArray(R.array.array_list1);
        adapter.addFragment(new TextViewFragment(),titleArr[0]);
        adapter.addFragment(new LinearLayoutFragment(),titleArr[1]);
        viewPager.setAdapter(adapter);
    }

    /**
     * 自定义adapter
     */
        class Adapter extends FragmentPagerAdapter{

            private List<Fragment> fragmentList = new ArrayList<>();
            private List<String>   pageTitle = new ArrayList<>();
            public void addFragment(Fragment fragment, String title){
                fragmentList.add(fragment);
                pageTitle.add(title);
            }
            public Adapter(FragmentManager fragmentManager){
                super(fragmentManager);
            }
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return pageTitle.get(position);
            }
        }
}
