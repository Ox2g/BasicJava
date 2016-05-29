package me.code41.basic.annotation.vo;

import me.code41.basic.annotation.NeedTest;

/**
 * Created by code41 on 2016/5/29.
 */
public class Student {
    private String name;
    private String school;

    @NeedTest(value = false)
    public String introduction() {
        String result = name + "..." + school;
        System.out.println(result);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
