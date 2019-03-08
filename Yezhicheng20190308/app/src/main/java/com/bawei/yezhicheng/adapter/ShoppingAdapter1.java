package com.bawei.yezhicheng.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.yezhicheng.R;
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
public class ShoppingAdapter1 extends RecyclerView.Adapter<ShoppingAdapter1.MyViewHolder> {
    private Context context;
    private JSONArray data;
    private Handler handler = new Handler();

    public ShoppingAdapter1(Context context, JSONArray data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //获取布局
        View view = LayoutInflater.from(context).inflate(R.layout.item1, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        try {
            JSONObject jsonObject = data.getJSONObject(i);
            String sellerName = jsonObject.getString("sellerName");
            myViewHolder.textView.setText(sellerName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = "http://172.17.8.100/ks/product/getCarts?uid=51";
        OkHttpUtils.getInstance().getData(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String json = response.body().string();
                            //Log.i("json2", "run: "+json);
                            JSONObject jsonObject = new JSONObject(json);
                            JSONArray data = jsonObject.getJSONArray("data");

                            /*JSONObject jsonObject1 = data.getJSONObject(i);
                            JSONArray list = jsonObject1.getJSONArray("list");*/
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                            myViewHolder.recyclerView2.setLayoutManager(linearLayoutManager);
                            ShoppingAdapter2 shoppingAdapter2 = new ShoppingAdapter2(context,data,i);
                            myViewHolder.recyclerView2.setAdapter(shoppingAdapter2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final RecyclerView recyclerView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item1_tv);
            recyclerView2 = itemView.findViewById(R.id.rv2);
        }
    }
}
