package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

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
