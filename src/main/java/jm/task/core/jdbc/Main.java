package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.service.UserService;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Иван", "Иванов", (byte) 37);
        userService.saveUser("Петр", "Петров", (byte) 58);
        userService.saveUser("Максим", "Белоусов", (byte) 45);
        userService.saveUser("Виктор", "Сидоров", (byte) 83);

        userService.removeUserById(1);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
