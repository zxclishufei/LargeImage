package com.canyinghao.canrefreshdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.canyinghao.canadapter.CanHolderHelper;
import com.canyinghao.canadapter.CanOnItemListener;
import com.canyinghao.canadapter.CanRVAdapter;
import com.canyinghao.canrefreshdemo.model.MainBean;
import com.sf.rxjava.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.cd)
    View cd;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.viewPager)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rxJava();
    }
    /**
     * rxjava例子
     */
    protected void rxJava() {
        ButterKnife.bind(this);
        toolbar.setTitle("canRefreshDemo");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        CanRVAdapter adapter = new CanRVAdapter<MainBean>(recyclerView,R.layout.item_main) {

            @Override
            protected void setView(CanHolderHelper helper, int position, MainBean bean) {
                helper.setText(R.id.tv_title,bean.title);
                helper.setText(R.id.tv_content,bean.content);
            }

            @Override
            protected void setItemListener(CanHolderHelper helper) {

            }
        };
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setList(MainBean.getMainList());
        adapter.setOnItemListener(new CanOnItemListener(){
            @Override
            public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                super.onRVItemClick(parent, itemView, position);
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,ViewActivity.class));
                        break;
                    case  1:
                        startActivity(new Intent(MainActivity.this,ScrollActivity.class));
                        break;
                    case  2:
                        startActivity(new Intent(MainActivity.this,RvActivity.class));
                        break;
                    case  3:
                        startActivity(new Intent(MainActivity.this,CooActivity.class));
                        break;
                }
            }
        });
    }
}
