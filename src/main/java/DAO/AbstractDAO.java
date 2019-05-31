package DAO;

import web.DBPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractDAO {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet answer = null;


    void close() {
        try {
            answer.close();
        } catch (SQLException ignored) {
        }
        try {
            statement.close();
        } catch (SQLException ignored) {
        }
    }
}
