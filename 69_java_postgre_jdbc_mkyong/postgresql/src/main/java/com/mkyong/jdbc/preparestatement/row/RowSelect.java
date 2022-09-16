package com.mkyong.jdbc.preparestatement.row;

import com.mkyong.jdbc.model.Todo;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RowSelect {

    private static final String SQL_SELECT = "SELECT * FROM EMPLOYEE";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/test", "postgres", "password");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("id");
                String assign_to = resultSet.getString("assign_to");
                String description = resultSet.getString("description");
                Date time_stamp = resultSet.getDate("time_stamp");

                Todo obj = new Todo();
                obj.setId(id);
                obj.setAssign_to("assign_to");
                obj.setDescription("descripcion");


                // Timestamp -> LocalDateTime
                obj.setTime_stamp(LocalTime.now());
                obj.setTitle("Hernan");

                System.out.println(obj);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
