package com.mywebapp.model;

public class User {
    private String lastname;
    private String firstname;
    private int salary;

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
}
