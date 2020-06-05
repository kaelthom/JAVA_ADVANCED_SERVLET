package com.mywebapp.model;

public class User {
    private String lastname;
    private String firstname;
    private String email;
    private int salary;

    public User(String email, String lastname) {
        this.email = email;
        this.lastname = lastname;
        this.firstname = "";
    }

    @Override
    public String toString() {
        return "User{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", salary=" + salary +
                '}';
    }

    public User(String lastname, String firstname, int salary) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.salary = salary;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLinkFromUserList() {
        return "/MyWebApp/user-details?action=detail&id=" + lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
