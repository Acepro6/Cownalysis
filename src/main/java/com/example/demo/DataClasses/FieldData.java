package com.example.demo.DataClasses;
import java.time.LocalDate;

public class FieldData {
    // Attributes
    private java.time.LocalDate date;
    private Herd herd;

    /**
     * Cosntructor
     * @param day
     * @param herd
     */
    public FieldData(LocalDate day, Herd herd) {
        this.date = day;
        this.herd = herd;
    }

    /**
     * Acessor
     * @return Date object
     */
    public java.time.LocalDate getDate() {
        return this.date;
    }

    /**
     * Mutator
     * @param date Date object
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Accessor
     * @return Herd Object
     */
    public Herd getHerd() {
        return this.herd;
    }

    /**
     * Mutator
     * @param herd Herd Object
     */
    public void setHerd(Herd herd) {
        this.herd = herd;
    }
}
