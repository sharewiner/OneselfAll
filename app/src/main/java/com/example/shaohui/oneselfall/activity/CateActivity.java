package com.example.shaohui.oneselfall.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shaohui.oneselfall.R;
import com.example.shaohui.oneselfall.adapter.CateAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CateActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;

    CateAdapter cateAdapter;
    List<String> list = new ArrayList<>();
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate);
        ButterKnife.bind(this);

        initView();
    }

    /**
     * 初始化页面
     */
    private void initView() {
        getData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cateAdapter = new CateAdapter(this, list);
        recyclerView.setAdapter(cateAdapter);

        //刷新
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                getData();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cateAdapter.notifyDataSetChanged();
                        refreshLayout.finishRefresh();
                    }
                }, 2000);

            }
        });

        //加载
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                getData();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cateAdapter.notifyDataSetChanged();
                        refreshLayout.finishLoadMore();
                    }
                }, 2000);
            }
        });

    }

    /**
     * 获取数据信息
     */
    private void getData() {
        for (int i = 0; i < 10; i++) {
            count = count + 1;
            list.add("数据" + count);
        }
    }
}
