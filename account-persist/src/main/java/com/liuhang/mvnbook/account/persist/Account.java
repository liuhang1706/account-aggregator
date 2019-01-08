package com.liuhang.mvnbook.account.persist;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月21日
 */
public class Account {

    private String id;

    private String name;

    private String email;

    private String password;

    private Boolean activated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
}
