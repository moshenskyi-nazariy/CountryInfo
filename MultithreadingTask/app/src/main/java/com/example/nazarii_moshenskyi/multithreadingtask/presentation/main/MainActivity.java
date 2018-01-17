package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.nazarii_moshenskyi.multithreadingtask.R;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.listener.OnDataLoadedListener;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.listener.OnDataReadyListener;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.presenter.MainMvpPresenter;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.presenter.MainPresenter;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.threads.AsyncTaskDataLoader;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.threads.ThreadFactory;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.util.FileUtils;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainMvpView, OnDataLoadedListener, OnDataReadyListener {
    private MainMvpPresenter presenter;
    private ProgressBar progressBar;
    private AsyncTaskDataLoader asyncTask;

    private EditText name;
    private EditText phone;
    private EditText email;

    private static final String FILE_NAME = "multithreading_task";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        presenter = (MainMvpPresenter) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            presenter = new MainPresenter();
        }
        presenter.attachView(this);
    }

    private void initViews() {
        progressBar = findViewById(R.id.progressBar);

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
                asyncTask = ThreadFactory.createAsyncTask(this, this);
                String[] name;
                if ((name = getData()).length == 3) {
                    asyncTask.execute(name);
                } else {
                    onError();
                }
                break;
            case R.id.loader:
                break;
            case R.id.handler:
                break;
            case R.id.handler_thread:
                break;
            default:
                break;
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    private String[] getData() {
        return new String[]{"name: " + String.valueOf(name.getText()) + "\n"
                , "phone: " + String.valueOf(phone.getText()) + "\n"
                , "email:" + String.valueOf(email.getText()) + "\n"};
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void updateProgress(int progress) {
        progressBar.setProgress(progress);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "No Data found. Please, fill all fields", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void writeToFile(String data) {
        try {
            FileOutputStream outputStream = openFileOutput(FILE_NAME, Context.MODE_APPEND);
            FileUtils.writeToFile(data, outputStream);
            outputStream.close();
        } catch (IOException e) {
            Log.d(TAG, "openFile: " + e.getMessage());
        }
    }
}
