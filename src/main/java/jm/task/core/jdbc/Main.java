package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.Driver;

public class Main {
    public static void main(String[] args) {
        Util.getConnection();

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        List<User> userList = new ArrayList<>();
        userList.add(new User("Name1", "LastName1", (byte) 20));
        userList.add(new User("Name2", "LastName2", (byte) 62));
        userList.add(new User("Name3", "LastName3", (byte) 23));
        userList.add(new User("Name4", "LastName4", (byte) 36));
        userList.forEach(x ->{userService.saveUser(x.getName(), x.getLastName(), x.getAge());
            System.out.println("User с именем – " + x.getName() + " добавлен в базу данных");});
        userService.removeUserById(1);
        userService.getAllUsers().forEach(x -> System.out.println(x));
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
