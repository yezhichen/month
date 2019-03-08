package com.bawei.yezhicheng.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bawei.yezhicheng.utils.OkHttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 叶至成 on 2019/3/8.
 */
public class ShoppingModel {
    String url = "http://172.17.8.100/ks/product/getCarts?uid=51";
    //使用接口回调
    public interface OnShoppingLisenter{
        void shop(JSONArray data);
    }
    private OnShoppingLisenter shoppingLisenter;

    public void setShoppingLisenter(OnShoppingLisenter shoppingLisenter) {
        this.shoppingLisenter = shoppingLisenter;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json = (String) msg.obj;
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        JSONArray data = jsonObject.getJSONArray("data");
                        if (shoppingLisenter!=null){
                            shoppingLisenter.shop(data);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    public void send() {
        OkHttpUtils.getInstance().getData(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                //创建消息使用hander发送
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);
            }
        });
    }
}
