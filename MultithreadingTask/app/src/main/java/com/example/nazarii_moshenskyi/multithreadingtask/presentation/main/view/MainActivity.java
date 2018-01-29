package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.view;

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
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.presenter.MainMvpPresenter;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.presenter.MainPresenter;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.util.FileUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainMvpView {
    private MainMvpPresenter presenter;

    private EditText name;
    private EditText phone;
    private EditText email;
    private ProgressBar loadingBar;

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
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);

        loadingBar = findViewById(R.id.loadingBar);
        loadingBar.setIndeterminate(true);

        Button btnHandlerThread = findViewById(R.id.handler_thread);
        btnHandlerThread.setOnClickListener(this);

        Button btnAsyncTask = findViewById(R.id.asynctask);
        btnAsyncTask.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.asynctask) {
            Log.d(TAG, "onClick: Started AsyncTask");
            presenter.runAsyncTask(prepareData());
        } else {
            Log.d(TAG, "onClick: Started HandlerThread");
            presenter.runHandlerThread(prepareData());
        }
    }

    public void noDataFound() {
        Log.d(TAG, "noDataFound");
        Toast.makeText(this, "Please, fill all the fields.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        loadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingBar.setVisibility(View.GONE);

    }

    @Override
    public void readData() {
        try {
            FileInputStream outputStream = openFileInput(FILE_NAME);
            FileUtils.readFromFile(this, outputStream);
        } catch (FileNotFoundException e) {
            Log.d(TAG, "readData: file not found");
        } catch (IOException e) {
            Log.d(TAG, "readData: " + e.getMessage());
        }
    }

    public void fillFields(String[] storedData) {
        name.setText(storedData[0]);
        phone.setText(storedData[1]);
        email.setText(storedData[2]);

    }

    private String[] prepareData() {
        return new String[]{getName()
                , getPhone()
                , getAddress()};
    }

    private String getName() {
        return String.valueOf(name.getText());
    }

    private String getPhone() {
        return String.valueOf(phone.getText());
    }

    private String getAddress() {
        return String.valueOf(email.getText());
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    @Override
    public void writeToFile(String data) {
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(FILE_NAME, Context.MODE_APPEND);
            try {
                FileUtils.writeToFile(data, outputStream);
            } catch (IOException e) {
                Log.d(TAG, "openFile: " + e.getMessage());
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    Log.d(TAG, "writeToFile: can't perform close operation");
                }
            }
        } catch (FileNotFoundException e) {
            Log.d(TAG, "openFile: " + e.getMessage());
        }
    }

}
