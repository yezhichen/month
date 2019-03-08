package com.bawei.yezhicheng.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yezhicheng.R;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 叶至成 on 2019/3/8.
 */
public class ShoppingAdapter2 extends RecyclerView.Adapter<ShoppingAdapter2.MyViewHolder> {
    private Context context;
    private JSONArray data;
    int j = 0;
    private JSONArray list;

    public ShoppingAdapter2(Context context, JSONArray data, int i) {
        this.context = context;
        this.data = data;
        this.j = i;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        try {
            /*JSONObject jsonObject = list.getJSONObject(i);
            JSONArray list = jsonObject.getJSONArray("list");
            Log.i("list", "onBindViewHolder: "+list);
            JSONObject jsonObject1 = list.getJSONObject(jj);
            Log.i("jsonObject1", "onBindViewHolder: "+jsonObject1);*/
            JSONObject jsonObject = data.getJSONObject(j);
            list = jsonObject.getJSONArray("list");
            JSONObject jsonObject1 = list.getJSONObject(i);
            String price = jsonObject1.getString("price");
            String images = jsonObject1.getString("images");
            String title = jsonObject1.getString("title");
            myViewHolder.textView1.setText(title);
            myViewHolder.textView2.setText(price);
            Glide.with(context).load(images).into(myViewHolder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.length();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView1;
        private final TextView textView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item2_img);
            textView1 = itemView.findViewById(R.id.item2_title);
            textView2 = itemView.findViewById(R.id.item2_price);
        }
    }
}
