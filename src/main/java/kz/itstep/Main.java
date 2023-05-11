package kz.itstep;

import kz.itstep.dao.UserDAO;
import kz.itstep.dao.UserDAOImpl;
import kz.itstep.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        UserDAO userDAO = new UserDAOImpl(DatabaseConnection.getConnection());

        List<User> users = userDAO.findAll();
        System.out.println("users list = " + users);

        User user = new User(11L, "Sergey", "5443", Date.valueOf(LocalDate.now()));
        Integer isCreated = userDAO.create(user);
        System.out.println("row affected count = " + isCreated);

        User createdUser = userDAO.findById(5L);
        System.out.println("Found user = "+createdUser);

    }
}