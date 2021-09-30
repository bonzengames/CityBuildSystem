package de.wichtigesyt.managers.mysql;

import java.sql.*;

public class MySQLMoney {

    private String host;
    private String port;
    private String user;
    private String password;
    private String database;

    private Connection conn = null;

    public MySQLMoney(String host, String port, String user, String password, String database) {

        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;

        openConnection();

    }

    public MySQLMoney openConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database , this.user , this.password);

            this.conn = connection;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Connection getConnection() {

        return conn;

    }

    public boolean hasConnection(){

        try {

            return this.conn != null || this.conn.isValid(1);

        } catch (SQLException e) {
            return false;
        }

    }

    public void qeryUpdate(String query) {

        Connection conn = this.conn;

        PreparedStatement st = null;

        try {

            st = conn.prepareStatement(query);

            st.execute();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            this.closeRessources(null, st);

        }

    }

    public void closeRessources(ResultSet rs, PreparedStatement st) {

        if (rs != null) {

            try {

                rs.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

        if (st != null) {

            try {

                st.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

    }

    public void closeConnection() {

        try {

            this.conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        this.conn = null;

    }

}
