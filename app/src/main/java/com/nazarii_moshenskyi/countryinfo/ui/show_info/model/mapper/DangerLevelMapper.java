package com.nazarii_moshenskyi.countryinfo.ui.show_info.model.mapper;

public class DangerLevelMapper {

    public static int convertLevel(String advise) {
        switch (advise) {
            case "Exercise normal safety precautions":
                return 1;
            case "Exercise a high degree of caution":
                return 2;
            case "Reconsider your need to travel":
                return 3;
            case "Do not travel":
                return 4;
            default:
                return -1;
        }
    }
}
