package com.example.madaim.ex13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
        MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.adapter=new MyAdapter(this, R.layout.item);
        GridView gridView =findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
    }
}
