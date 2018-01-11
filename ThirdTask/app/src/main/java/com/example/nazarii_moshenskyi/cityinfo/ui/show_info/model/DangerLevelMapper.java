package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model;

public class DangerLevelMapper {

    public static int convertLevel(String advise) {
        if (advise.contains("Exercise normal safety precautions"))
            return 1;
        else if (advise.contains("Exercise a high degree of caution"))
            return 2;
        else if (advise.contains("Reconsider your need to travel"))
            return 3;
        else
            return 4;
    }
}
