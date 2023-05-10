package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public void createUsersTable() {
        try (Connection connection = Util.getConnection()) {
            try (Statement statement = connection.createStatement()){
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS mysql.users" +
                        "(id mediumint not null auto_increment," +
                        "name VARCHAR(25)," +
                        "lastname VARCHAR(25)," +
                        "age tinyint," +
                        "PRIMARY KEY (id))");
                System.out.println("Таблица создана");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.getConnection()) {
            try (Statement statement = connection.createStatement()){
                statement.executeUpdate("DROP TABLE IF EXISTS mysql.users");
                System.out.println("Таблица удалена");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mysql.users(name, lastname, age) VALUES(?,?,?)")) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, lastName);
                preparedStatement.setByte(3, age);
                preparedStatement.executeUpdate();
                System.out.println("User с именем: " + name + " добавлен в базу данных");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection()) {
            try (Statement statement = connection.createStatement()){
                statement.executeUpdate("DELETE FROM mysql.users WHERE id");
                System.out.println("User удален");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> allUser = new ArrayList<>();
        try (Connection connection = Util.getConnection()) {
            try (Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery("SELECT id, name, lastName, age FROM mysql.users");
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setName(resultSet.getString("name"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setAge(resultSet.getByte("age"));
                    allUser.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUser;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection()) {
            try (Statement statement = connection.createStatement()){
                statement.executeUpdate("TRUNCATE mysql.users");
                System.out.println("Таблица очищена");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось очистить");
        }
    }
}
