package com.example.B10709042_HW1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    public final ArrayList<Item> mData = new ArrayList<>();
    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 30; i++) {
            Item temp = new Item();
            temp.setText(String.valueOf(i));
            temp.setCheck(false);
            mData.add(temp);
        }
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(mData);
        recyclerView.setAdapter(adapter);
        Button temp = findViewById(R.id.button);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                for (Item tmp : mData) {
                    if (tmp.check == true) {
                        count++;
                    }
                }
                Context context = MainActivity.this;
                Class Destination = ResultMenu.class;
                Intent intent = new Intent(context, Destination);
                intent.putExtra("Extravalue", count);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        Intent data = getIntent();
        if (data.hasExtra("clearTag")) {
            for (Item tmp : mData) {
                tmp.setCheck(false);
            }
        }
        super.onResume();
    }

    public class Item {
        String text;
        boolean check;

        public void setText(String text) {
            this.text = text;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }
    }
}
