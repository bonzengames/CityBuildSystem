package de.wichtigesyt.managers;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.mysql.MySQLMoney;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;

public class MoneyManager {
    private MySQLMoney mySQL = null;
    private Connection conn = null;
    private String tablename;

    public MoneyManager(MySQLMoney mySQL, String tablename) {

        this.mySQL = mySQL;
        conn = mySQL.getConnection();
        this.tablename = tablename;

    }

    public void setMoney(Player player, String name, String money) {

        mySQL.qeryUpdate("UPDATE " + tablename + " SET " + name + "='" + money + "', PlayerName='" + player.getName() + "' WHERE PlayerUUID='" + player.getUniqueId().toString() + "'");

        ScoreboardManager.setLobbyScore(player);

    }

    public void addPlayer(Player player) {

        if(getMoney(player, "geld") == null) {

            mySQL.qeryUpdate("CREATE TABLE IF NOT EXISTS " + tablename + " (PlayerUUID varchar(200), PlayerName varchar(200), geld int)");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`,`PlayerName`, `geld`) VALUES ('" + player.getUniqueId() + "','" + player.getName() + "', '1000')");

        }

    }

    public String getMoney(Player player, String stat) {
        ResultSet rs = null;
        PreparedStatement st = null;
        String statvalue = null;
        try {
            st = conn.prepareStatement("SELECT * FROM " + tablename + " WHERE PlayerUUID=?");
            st.setString(1, player.getUniqueId().toString());
            rs = st.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                rs.first();
                statvalue = rs.getString("geld");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        } finally {
            mySQL.closeRessources(rs, st);
        }


        return statvalue;

    }

    public void payMoney(Player player, Player target, int money) {

        int akt_money_player = Integer.parseInt(getMoney(player, "geld"));
        int akt_money_target = Integer.parseInt(getMoney(target, "geld"));

        if (akt_money_player >= money) {

            int end_money_player = akt_money_player - money;
            int end_money_target = akt_money_target + money;

            setMoney(player, "geld", String.valueOf(end_money_player));
            setMoney(target, "geld", String.valueOf(end_money_target));

        } else {

            player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Geld");

        }

    }

    public void addMoney(Player player, String geld, int money) {

        int akt_money = Integer.parseInt(getMoney(player, "geld"));

        int end_money = akt_money + money;

        setMoney(player, geld, String.valueOf(end_money));

    }

    public void removeMoney(Player player, String geld, int money) {

        int akt_money = Integer.parseInt(getMoney(player, "geld"));

        int end_money = akt_money - money;

        setMoney(player, geld, String.valueOf(end_money));

    }
}

