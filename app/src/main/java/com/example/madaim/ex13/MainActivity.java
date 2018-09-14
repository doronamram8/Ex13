package com.example.madaim.ex13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements MyDialog.ResultListener{
  ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ItemAdapter(this, R.layout.item);
        GridView gridView =findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        Button bt = findViewById(R.id.newItem);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDialog.newInstance(MyDialog.ADD_NUMBER_DIALOG).show(getFragmentManager(), "Add number Dialog");
            }
        });


    }

    @Override
    public void onFinishedDialog(Object results) {
        adapter.addnewItem((Item) results);
    }
}
