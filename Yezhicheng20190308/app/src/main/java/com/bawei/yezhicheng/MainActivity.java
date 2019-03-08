package com.bawei.yezhicheng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bawei.yezhicheng.base.BaseActivity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // initDatae();
        textView = findViewById(R.id.tiao);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }
        });


    }

   /*
    ArrayList<String> list = new ArrayList<>();
    @BindView(R.id.m_ed)
    EditText mMEd;
    @BindView(R.id.m_but_add)
    Button mMButAdd;
    @BindView(R.id.m_but_jian)
    Button mMButJian;
    @BindView(R.id.id_dlowlayout)
    TagFlowLayout mIdFlowlayout;



    @OnClick({R.id.m_ed, R.id.m_but_add, R.id.m_but_jian, R.id.id_dlowlayout})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.m_but_add:
                String string = mMEd.getText().toString();
                if (string.equals("")) {
                    return;
                } else {
                    list.add(string);
                    initDatae();
                    mMEd.setText("");
                }
                break;
            case R.id.m_but_jian:
                list.clear();
                initDatae();
                break;
        }
    }

    private void initDatae() {
        mIdFlowlayout.setAdapter(new TagAdapter<String>(list) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView textView = (TextView) View.inflate(MainActivity.this, R.layout.butn, null);
                textView.setText(s);
                return textView;
            }
        });
   *//*

    @Override
    protected void initView() {
        textView = findViewById(R.id.tiao);

    }

    @Override
    protected void initData() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }
        });
    }
    @OnClick({R.id.m_ed, R.id.m_but_add, R.id.m_but_jian, R.id.id_dlowlayout})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.m_but_add:
                String string = mMEd.getText().toString();
                if (string.equals("")){
                    return;
                }else {
                    list.add(string);
                    initDatae();
                    mMEd.setText("");
                }
                break;
            case R.id.m_but_jian:
                list.clear();
                initDatae();
                break;
        }
    }

    private void initDatae() {
        mIdFlowlayout.setAdapter(new TagAdapter<String>(list) {
            @Override
            public View getView(FlowLayout parent, int position,String s) {
                TextView textView = (TextView) View.inflate(MainActivity.this,R.layout.butn,null);
                textView.setText(s);
                return textView;
            }
        });
    }*//*
    }*/
}
