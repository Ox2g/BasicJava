package me.code41.basic.annotation.vo;

import me.code41.basic.annotation.NeedTest;

/**
 * Created by code41 on 2016/5/29.
 */
public class Teacher {
    private String name;
    private String className;

    @NeedTest
    public String introduction() {
        String result = name + "..." + className;
        System.out.println(result);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
