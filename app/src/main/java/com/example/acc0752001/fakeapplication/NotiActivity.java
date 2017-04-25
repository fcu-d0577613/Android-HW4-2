package com.example.acc0752001.fakeapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotiActivity extends AppCompatActivity {
TextView sh_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);

        sh_name = (TextView)findViewById(R.id.textView2);
        String hello = "Hello ";
        Intent intent = getIntent();
        if(intent != null) {
            String name = intent.getStringExtra("KEY_NAME");
            if(name != null) {
                hello = hello + name;
            }
        }
        sh_name.setText(hello);

    }
}
