package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nazarii_moshenskyi.multithreadingtask.R;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.presenter.MainMvpPresenter;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.presenter.MainPresenter;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.services.FileManager;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainMvpView, FileManager.OnDataLoadedListener {
    private MainMvpPresenter presenter;
    private FileManager manager;

    private EditText name;
    private EditText phone;
    private EditText email;

    private static final String FILE_NAME = "multithreading_task";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = new FileManager(this);

        initViews();

        presenter = (MainMvpPresenter) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            presenter = new MainPresenter();
        }
        presenter.attachView(this);
    }

    private void initViews() {
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);

        Button asyncTask = findViewById(R.id.asynctask);
        asyncTask.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.asynctask:
                presenter.runAsyncTask();
                break;
            case R.id.handler_thread:
                break;
            default:
                break;
        }
    }

    public void noDataFound() {
        Toast.makeText(this, "Please, fill all the fields.", Toast.LENGTH_LONG).show();
    }

    @Override
    public String getName() {
        return String.valueOf(name.getText());
    }

    @Override
    public String getPhone() {
        return String.valueOf(phone.getText());
    }

    @Override
    public String getAddress() {
        return String.valueOf(email.getText());
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: Data loaded");
    }

    @Override
    public void onError(String exception) {
        Log.d(TAG, "onError: " + exception);
    }

    public void writeToFile(String data) {
        try {
            FileOutputStream outputStream = openFileOutput(FILE_NAME, Context.MODE_APPEND);
            manager.writeToFile(data, outputStream);
            outputStream.close();
        } catch (IOException e) {
            Log.d(TAG, "openFile: " + e.getMessage());
        }
    }
}
