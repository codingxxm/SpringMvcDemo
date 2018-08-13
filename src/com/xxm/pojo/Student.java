package com.xxm.pojo;

import com.xxm.controller.DemoController;
import org.springframework.beans.factory.annotation.Autowired;

public class Student {
    private String name;
    private Integer age;
    private String gender;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Student(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

