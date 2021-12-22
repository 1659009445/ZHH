package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            Properties pro = new Properties();
            ClassLoader ClassLoader = JDBCUtils.class.getClassLoader();
            InputStream res= ClassLoader.getResourceAsStream("druid.properties");
            pro.load(res);
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取连接
     */
    public static Connection getconnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭资源
     */
    public static void close(Statement stmt, Connection conn){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet res, Statement stmt, Connection conn){
        if(res!=null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
