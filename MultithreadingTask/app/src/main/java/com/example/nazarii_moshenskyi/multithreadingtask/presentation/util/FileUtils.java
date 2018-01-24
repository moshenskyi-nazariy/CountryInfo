package com.example.nazarii_moshenskyi.multithreadingtask.presentation.util;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.view.MainMvpView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileUtils {

    public static void writeToFile(String data, FileOutputStream stream) throws IOException {
        if (data != null) {
            stream.write(data.getBytes());
            stream.close();
        }
    }

    public static String[] readFromFile(MainMvpView view, FileInputStream stream) throws IOException {
        String[] data = new String[3];

        Scanner scanner = new Scanner(stream);

        try {
            for (int i = 0; i < 3; i++) {
                data[i] = scanner.nextLine();
            }
            view.fillFields(data);
        } catch (NoSuchElementException e) {
            return null;
        } finally {
            stream.close();
        }
        return data;
    }
}
