package me.code41.basic.reflect.vo;

/**
 * Created by liushiyao on 2016/5/27.
 */
public class Leader {
    private String name;
    private Integer level;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
