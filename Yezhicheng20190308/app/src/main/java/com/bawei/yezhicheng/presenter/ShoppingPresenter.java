package com.bawei.yezhicheng.presenter;

import com.bawei.yezhicheng.model.ShoppingModel;
import com.bawei.yezhicheng.view.ShoppingView;

import org.json.JSONArray;

import java.lang.ref.WeakReference;

/**
 * Created by 叶至成 on 2019/3/8.
 */
public class ShoppingPresenter <T>{

    private final ShoppingModel shoppingModel;
    private final ShoppingView shoppingView;
    private WeakReference<T> reference;

    public ShoppingPresenter(ShoppingView view) {

        shoppingModel = new ShoppingModel();
        shoppingView = view;
    }

    public void send() {
        //创建model层的方法
        shoppingModel.send();
        shoppingModel.setShoppingLisenter(new ShoppingModel.OnShoppingLisenter() {
            @Override
            public void shop(JSONArray data) {
                shoppingView.item(data);
            }
        });
    }
    public  void att(T t){
        //使用弱引用
        reference = new WeakReference<>(t);
    }
    //
    public void deta(){
        if (reference.get()!=null){
            reference.clear();
            reference = null;
        }
    }
}
