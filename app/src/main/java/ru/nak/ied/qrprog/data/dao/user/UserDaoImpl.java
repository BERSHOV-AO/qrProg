package ru.nak.ied.qrprog.data.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import ru.nak.ied.qrprog.data.databaseConnection.DatabaseConnectionImpl;
import ru.nak.ied.qrprog.data.entities.User;

public class UserDaoImpl implements IUserDao {

    private static UserDaoImpl instance;
    private final Connection connection = DatabaseConnectionImpl.getConnection();

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    private UserDaoImpl() {   // public
//        connection = DatabaseConnectionImpl.getConnection();
    }

    @Override
    public void addUser(User user) {

        String query = "INSERT INTO maintenance.users (personNum, name, surname, userPassword) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getPersonNum());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getUserPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}
