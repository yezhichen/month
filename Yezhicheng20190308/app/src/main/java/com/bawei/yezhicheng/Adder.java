package com.bawei.yezhicheng;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 叶至成 on 2019/3/8.
 */

public class Adder extends LinearLayout implements View.OnClickListener {
    int i =1;
    private final TextView textView;

    public Adder(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.adder, this, true);
        Button jia = findViewById(R.id.jia);
        textView = findViewById(R.id.nums);
        Button jian = findViewById(R.id.jian);
        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jia:
                i++;
                textView.setText(""+i);
                break;
            case R.id.jian:

                if (i>1){
                    i--;
                    textView.setText(""+i);
                }else {
                    Toast.makeText(getContext(), "不能再减了!", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }
    }
}
