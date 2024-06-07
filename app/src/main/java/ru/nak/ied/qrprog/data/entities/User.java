package ru.nak.ied.qrprog.data.entities;

public class User {

    private int id;
    private int personNum;
    private String name;
    private String surname;
    private String userPassword;

    public User(int personNum, String name, String surname, String userPassword) {
        this.personNum = personNum;
        this.name = name;
        this.surname = surname;
        this.userPassword = userPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", personNum=" + personNum +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password=" + userPassword +
                '}';
    }
}
