package com.example.demo.FilterClasses;

import com.example.demo.DataClasses.Cow;
import com.example.demo.Enums.Gender;

public class GenderFilter implements CowFilter {

    private Gender gender;

    public GenderFilter (Gender g) {
        this.gender = g;
    }

    @Override
    public String toString() {
        if (gender == Gender.FEMALE) {
            return "Is Female";
        } else {
            return "Is Male";
        }
    }

    @Override
    public boolean meetsCriteria(Cow cow) {
        if (cow.getGender() == gender) {
            return true;
        }
        else {
            return false;
        }
    }

    // not testing this because it should function identically to CategoryFilter

}
