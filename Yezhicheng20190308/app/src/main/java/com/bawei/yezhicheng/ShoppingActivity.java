package com.bawei.yezhicheng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bawei.yezhicheng.adapter.ShoppingAdapter1;
import com.bawei.yezhicheng.base.BaseActivity;
import com.bawei.yezhicheng.presenter.ShoppingPresenter;
import com.bawei.yezhicheng.view.ShoppingView;

import org.json.JSONArray;

public class ShoppingActivity extends BaseActivity implements ShoppingView {


    private ShoppingPresenter shoppingPresenter;
    private RecyclerView recyclerView1;

    @Override
    protected int layoutID() {
        return R.layout.activity_shopping;
    }

    @Override
    protected void initView() {
        recyclerView1 = findViewById(R.id.rv1);
        //创建布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShoppingActivity.this);
        recyclerView1.setLayoutManager(linearLayoutManager);
        shoppingPresenter = new ShoppingPresenter(this);
        shoppingPresenter.att(this);
    }

    @Override
    protected void initData() {
        shoppingPresenter.send();
    }

    @Override
    public void item(JSONArray data) {
        //创建适配器
        ShoppingAdapter1 shoppingAdapter1 = new ShoppingAdapter1(ShoppingActivity.this, data);
        recyclerView1.setAdapter(shoppingAdapter1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        shoppingPresenter.deta();
        Log.i("销毁", "onDestroy: ");
    }
}
