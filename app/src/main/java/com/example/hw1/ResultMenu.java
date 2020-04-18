package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultMenu extends AppCompatActivity {
    private static int count = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_menu);
        Intent intent = getIntent();
        if(intent.hasExtra("Extravalue")){
            count = intent.getIntExtra("Extravalue",0);
        }
        final TextView textView = (TextView) findViewById(R.id.resultCount);
        textView.setText("選取了"+String.valueOf(count)+"個項目");
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button backclear = (Button) findViewById(R.id.backclear);
        backclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(MainActivity.Item temp: MainActivity.mData){
                    temp.check = false;
                }
                MainActivity.ActivityA.recreate();
                finish();
            }
        });
    }
}
