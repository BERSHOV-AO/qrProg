package ru.nak.ied.qrprog.service.user;


import java.util.List;

import ru.nak.ied.qrprog.data.entities.User;

public interface IUserService {
    public void addUser(User user);

    public User getUserById(int id);

    public User getUserByPersonNum(int personNum);

    public List<User> getAllUsers();

    public String getUserPassword();

    public String getUserName();

    public String getUserSurname();
}
