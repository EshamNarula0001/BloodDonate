package com.example.eaham.data;

class User {


    private String Name;
    private String Mobile;
    private String password ;
    private String bloodgroup;
    private String age;


    public User() {
    }

    public User(String name, String mobile, String password, String bloodgroup, String age) {
        Name = name;
        Mobile = mobile;
        this.password = password;
        this.bloodgroup = bloodgroup;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}









