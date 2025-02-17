package com.itbaima.pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private String gneder;
    private String addr;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gneder='" + gneder + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGneder() {
        return gneder;
    }

    public void setGneder(String gneder) {
        this.gneder = gneder;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
