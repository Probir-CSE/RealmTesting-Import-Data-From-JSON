package com.chronvas.realmtesting;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class People extends RealmObject {
    @PrimaryKey
    private int id;
    private String Name;
    private int Age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
