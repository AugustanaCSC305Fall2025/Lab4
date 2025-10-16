package edu.augustana.csc305.lab4;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long UID = 1L;

    private final String name;
    private final String address1;
    private final String address2;
    private final String city;
    private final String state;
    private final String zip;

    public Student(String name, String address1, String address2, String city, String state, String zip) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override public String toString() {
        return name;
    }

    public String getName() {
        return this.name;
    }
}
