package com.example.nazarii_moshenskyi.multithreadingtask.presentation.util;

import java.io.FileOutputStream;

public class FileUtils {

    public static void writeToFile(String data, FileOutputStream stream) {
        if (data != null) {

            try {
                stream.write(data.getBytes());
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
