package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // JDBC
//        Util util = new Util();
//        util.getConnection();
//
//        UserDao userDao = new UserDaoJDBCImpl();
//
//        userDao.createUsersTable();
//
//        userDao.saveUser("John", "Smith", (byte) 30);
//        userDao.saveUser("Bob", "Peters", (byte) 25);
//        userDao.saveUser("Tom", "Holland", (byte) 31);
//        userDao.saveUser("Alice", "Pitt", (byte) 38);
//
//        userDao.removeUserById(1);
//        System.out.println(userDao.getAllUsers());
//        userDao.cleanUsersTable();
//        userDao.dropUsersTable();


        //Hibernate
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("John", "Smith", (byte) 30);
        userService.saveUser("Bob", "Peters", (byte) 25);
        userService.saveUser("Tom", "Holland", (byte) 31);
        userService.saveUser("Alice", "Pitt", (byte) 38);

        userService.removeUserById(1);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        System.out.println(userService.getAllUsers());
        userService.dropUsersTable();

    }
}
