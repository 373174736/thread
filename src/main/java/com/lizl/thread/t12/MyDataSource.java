package com.lizl.thread.t12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lizl
 * @date 2018/5/10 17:22
 */
public class MyDataSource {

    private LinkedList<Connection> pool = new LinkedList<>();

    private static final String URL = "jdbc:mysql://10.254.1.123:3306/wm_dx";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    private static final int INIT_CONNECTIONS = 10;

    private Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MyDataSource() {
        for (int i = 0; i < INIT_CONNECTIONS; i++) {
            try {
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                pool.add(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnect() {
        Connection con = null;
        try {
            lock.lock();
            while (pool.size() <= 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!pool.isEmpty()) {
                con = pool.removeFirst();
            }
        } finally {
            lock.unlock();
        }
        return con;
    }

    public void release(Connection connection) {
        try {
            lock.lock();
            if (connection != null) {
                pool.add(connection);
                condition.signal();
            }
        }finally {
            lock.unlock();
        }


    }
}
