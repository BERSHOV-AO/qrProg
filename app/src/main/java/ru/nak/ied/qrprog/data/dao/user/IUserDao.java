package ru.nak.ied.qrprog.data.dao.user;

import java.util.List;

import ru.nak.ied.qrprog.data.entities.User;

public interface IUserDao {

    public void addUser(User user);

    public User getUserById(int id);

    public User getUserByPersonNum(int personNum);

    public List<User> getAllUsers();
}
