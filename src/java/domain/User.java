package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yukih
 */
public class User {
    String id;
    String usertype;
    String name;
    String pw;
    String phone;
    String address;
    
    public User(String id, String usertype, String name, String pw, String phone, String address) {
        this.id = id;
        this.usertype = usertype;
        this.name = name;
        this.pw = pw;
        this.phone = phone;
        this.address = address;
        //this.joinAllow = joinAllow;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String searchID() {
        return id;
    }

    public void searchID(String name, String phone) {
        this.id = id;
    }
    
    public String searchPwd() {
        return pw;
    }

    public void searchPwd(String name, String phone) {
        this.pw = pw;
    }
}