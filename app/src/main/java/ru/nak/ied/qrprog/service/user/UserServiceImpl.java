package ru.nak.ied.qrprog.service.user;

import java.sql.Connection;
import java.util.List;

import ru.nak.ied.qrprog.data.dao.user.UserDaoImpl;
import ru.nak.ied.qrprog.data.entities.User;

public class UserServiceImpl implements IUserService{
    private static UserServiceImpl instance;

    private final UserDaoImpl userDao = UserDaoImpl.getInstance();


    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    private UserServiceImpl() {

    }

    @Override
    public void addUser(User user) {

        userDao.addUser(user);
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User getUserByPersonNum(int personNum) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public String getUserPassword() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUserSurname() {
        return null;
    }
}
