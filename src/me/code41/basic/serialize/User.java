package me.code41.basic.serialize;

import java.io.Serializable;

/**
 * Created by liushiyao on 2016/5/18.
 */
public class User implements Serializable {
    private String firstName;
    private transient String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
