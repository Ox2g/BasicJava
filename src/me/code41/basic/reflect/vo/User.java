package me.code41.basic.reflect.vo;

/**
 * Created by liushiyao on 2016/5/27.
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String hello() {
        String hello = "hello-" + name;
        System.out.println(hello);
        return hello;
    }

    public static String welcome(String customer) {
        System.out.println("welcome-" + customer);
        return "welcome-" + customer;
    }
}
