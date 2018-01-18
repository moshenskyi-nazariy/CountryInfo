package com.example.nazarii_moshenskyi.multithreadingtask.presentation.services;

import java.io.FileOutputStream;

public class FileManager {
    private OnDataLoadedListener listener;

    public FileManager(OnDataLoadedListener listener) {
        this.listener = listener;
    }

    public void writeToFile(String data, FileOutputStream stream) {
        if (data != null) {
            try {
                stream.write(data.getBytes());
                stream.close();
                listener.onComplete();
            } catch (Exception e) {
                listener.onError(e.getMessage());
            }
        }
    }

    public interface OnDataLoadedListener {

        void onComplete();

        void onError(String exception);

    }

}
