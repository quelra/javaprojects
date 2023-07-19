package mact2;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;
    public User() {
    }
    public User(String n, String p) {
        this.name = n;
        this.password = p;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String n) {
        this.name = n;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String p) {
        this.password = p;
    }
    public String toString() {
        return name + ":" + password;
    }
}