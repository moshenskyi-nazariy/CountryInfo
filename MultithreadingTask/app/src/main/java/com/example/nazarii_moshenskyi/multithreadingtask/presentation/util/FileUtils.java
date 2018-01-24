package com.example.nazarii_moshenskyi.multithreadingtask.presentation.util;

import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    private static final String TAG = "FileUtils";

    public static void writeToFile(String data, FileOutputStream stream) throws IOException {
        if (data != null) {
                stream.write(data.getBytes());
                stream.close();
        }
    }
}
