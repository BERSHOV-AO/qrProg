package ru.nak.ied.qrprog.data.entities;

public class User {
    private int personNum;
    private String name;
    private String surname;
    private int password;

    public User(int personNum, String name, String surname, int password) {
        this.personNum = personNum;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "personNum=" + personNum +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password=" + password +
                '}';
    }
}
