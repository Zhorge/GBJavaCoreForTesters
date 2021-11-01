package lesson8;

import lesson7.project.Controller;

import java.sql.*;

public class SqliteExamples {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db");

            Statement statement = connection.createStatement();

            statement.executeUpdate("update faculties set name = 'Test1' where id = 1");

            ResultSet resultSet = statement.executeQuery("select * from students");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
//            }

            Long time = System.currentTimeMillis();
//            for (int i = 0; i < 10000; i++) {
//                statement.executeUpdate(String.format("insert into students (name, score, faculty_id) values ('%s', %d, %d)", "student" + i, i, i));
//            }
//            System.out.println("Время выполнения с автокоммитом " + (System.currentTimeMillis() - time));

            time = System.currentTimeMillis();
            connection.setAutoCommit(false);

            for (int i = 10000; i < 20000; i++) {
                statement.executeUpdate(String.format("insert into students (name, score, faculty_id) values ('%s', %d, %d)", "student" + i, i, i));
            }
            System.out.println("Время выполнения с автокоммитом " + (System.currentTimeMillis() - time));


            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into students (name, score, faculty_id) values (?, ?, ?)");

            connection.setAutoCommit(false);
            preparedStatement.setString(1, "Kate");
            preparedStatement.setInt(2, 10);
            preparedStatement.setInt(2, 11);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "Mike");
            preparedStatement.setInt(2, 20);
            preparedStatement.setInt(2, 21);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "Sveta");
            preparedStatement.setInt(2, 30);
            preparedStatement.setInt(2, 31);
            preparedStatement.executeBatch();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
