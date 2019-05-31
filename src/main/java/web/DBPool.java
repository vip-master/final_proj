package web;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DBPool {
    private static BasicDataSource source;
    private static DBPool instance;

    private DBPool() {
        source = new BasicDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost/final_proj");
        source.setUsername("root");
        source.setPassword("1111");
        source.setInitialSize(2);
        source.setMaxTotal(10);
    }

    public synchronized static DBPool getInstance() {
        if (instance == null) instance = new DBPool();
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }

}
