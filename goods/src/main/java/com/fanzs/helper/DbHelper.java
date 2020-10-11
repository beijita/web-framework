package com.fanzs.helper;

import com.fanzs.utils.PropUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DbHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbHelper.class);

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    static {
        Properties configProps = PropUtils.loadProps("config.properties");
        DRIVER = configProps.getProperty("jdbc.driver");
        URL = configProps.getProperty("jdbc.url");
        USERNAME = configProps.getProperty("jdbc.username");
        PASSWORD = configProps.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("load jdbc driver failure", e);
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("get connection exception", e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn == null) {
            return;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            LOGGER.error("close connection exception", e);
        }
    }

    public static <T> List<T> queryEntityList(Class<T> entityClazz, Connection conn, String sql, Object... params) {
        try {
            return QUERY_RUNNER.query(conn, sql, new BeanListHandler<>(entityClazz), params);
        } catch (Exception e) {
            throw new RuntimeException("query db exception", e);
        } finally {
            closeConnection(conn);
        }
    }
}











