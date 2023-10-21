package com.company.shiyishi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "some_MainActivity";

    private ArrayList<JavaBean> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.my_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(list,this);
        recyclerView.setAdapter(myAdapter);
        for (int i = 0; i <= 100; i++) {
            JavaBean javaBean = new JavaBean();
            javaBean.setName("新闻" + i );
            list.add(javaBean);
        }
        myAdapter.setClick(new MyAdapter.onRecycleclick() {
            @Override
            public void setClickMethod(int position) {
                FragmentChange(new RightFragment());
            }
        });
    }
    private void FragmentChange(Fragment fragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_layout,fragment);
        fragmentTransaction.commit();
    }
}