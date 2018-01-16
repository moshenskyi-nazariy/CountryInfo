package com.example.nazarii_moshenskyi.multithreadingtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.asynctask:
                break;
            case R.id.loader:
                break;
            case R.id.handler:
                break;
            case R.id.intent_service:
                break;
            case R.id.handler_thread:
                break;
            default:
                break;
        }
    }
}
