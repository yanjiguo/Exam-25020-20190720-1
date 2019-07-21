package com.yjg.utils;

import java.sql.*;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description: 定义一个工具类获取链接和释放资源
 */
public class BaseDao {
    /**
     * 获取配置文件中的值
     */
    static String driver = Evn.newInstance().getProperty("driver");
    static String url = Evn.newInstance().getProperty("url");
    static String user = Evn.newInstance().getProperty("user");
    static String password = Evn.newInstance().getProperty("password");
    /**
     * 定义全局变量
     */
    protected Connection con = null;
    protected ResultSet rs = null;
    protected Statement stmt = null;

    /**
     * 定义静态代码块在文件加载之前加载数据库驱动
     */
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取链接
     */
    public void getConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 又返回的conn
     */
    public  Connection getConnections() {
        Connection connection = null;
        try {
            connection = con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * 释放资源
     */
    public void closeAll() {

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
