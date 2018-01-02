package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model;

public abstract class BaseRowType implements RowType {
    protected String checkNotNull(String toCheck) {
        return toCheck == null ? "-" : toCheck;
    }
}
