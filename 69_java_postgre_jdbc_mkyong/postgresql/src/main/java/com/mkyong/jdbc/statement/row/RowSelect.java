package com.mkyong.jdbc.statement.row;

import com.mkyong.jdbc.model.Todo;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalTime;

public class RowSelect {

    public static void main(String[] args) {

        String sql = "SELECT * FROM TODO";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/barroetadb", "postgres", "postgres");
             Statement statement = conn.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                 long id = resultSet.getLong("id");
                String assign_to = resultSet.getString("assign_to");
                String description = resultSet.getString("description");
                Timestamp time_stamp = resultSet.getTimestamp("time_stamp");
                String title = resultSet.getString("time_stamp");

                Todo obj = new Todo();
                obj.setId(id);
                obj.setAssign_to(assign_to);
                obj.setDescription(description);
                // Timestamp -> LocalDateTime
                obj.setTime_stamp(LocalTime.now());

                System.out.println(obj.getDescription());
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
