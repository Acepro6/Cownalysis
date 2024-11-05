package com.example.demo.Delete;

import com.example.demo.DataClasses.Cow;

public interface Filter {
    public boolean meetsCriteria (Cow cow);
}