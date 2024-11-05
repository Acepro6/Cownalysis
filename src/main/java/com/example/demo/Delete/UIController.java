package com.example.demo.Delete;

import com.example.demo.DataClasses.Cow;
import com.example.demo.Delete.Model;

public class UIController {
    Model model;
    public void setModel(Model model) {
        this.model = model;
    }
    public void clickedOnCow(Cow cow) {
        System.out.println("ID:" + cow.getID());
    }
}
