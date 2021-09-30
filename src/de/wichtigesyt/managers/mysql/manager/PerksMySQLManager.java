package de.wichtigesyt.managers.mysql.manager;

import de.wichtigesyt.managers.mysql.MySQLPerks;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;

public class PerksMySQLManager {
    private MySQLPerks mySQL = null;
    private Connection conn = null;
    private String tablename;

    public PerksMySQLManager(MySQLPerks mySQL, String tablename) {

        this.mySQL = mySQL;
        conn = mySQL.getConnection();
        this.tablename = tablename;

    }

    public void addPlayer(Player player) {

        if(getPunkte(player, "PlayerUUID") == null) {

            mySQL.qeryUpdate("CREATE TABLE IF NOT EXISTS " + tablename + " (PlayerUUID varchar(200), perkName varchar(200), havePerk varchar(200))");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','mute', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','slowChat', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','startKick', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','noHunger', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','noFall', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','noErtrinken', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','noFeuerschaden', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','noVergiftung', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','keepInvsee', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','noAbbaulaemung', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','noWither', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','dobbleXp', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','keepXp', 'false')");
            mySQL.qeryUpdate("INSERT INTO " + tablename + " (`PlayerUUID`, `perkName`, `havePerk`) VALUES ('" + player.getUniqueId().toString() + "','speedAbbau', 'false')");

        }

    }

    public String getPunkte(Player player, String stat) {
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
                statvalue = rs.getString(stat);
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        } finally {
            mySQL.closeRessources(rs, st);
        }

        return statvalue;

    }

    public String getPerks(String uuid, String perkName) {
        ResultSet rs = null;
        PreparedStatement st = null;
        String statvalue = null;
        try {
            st = conn.prepareStatement("SELECT * FROM " + tablename + " WHERE PlayerUUID=? AND perkName='" + perkName + "'");
            st.setString(1, uuid);
            rs = st.executeQuery();
            rs.last();
            if (rs.getRow() != 0) {
                rs.first();
                statvalue = rs.getString("havePerk");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        } finally {
            mySQL.closeRessources(rs, st);
        }

        return statvalue;
    }

    public void setPerk(Player player, String perkName, String state) {

        mySQL.qeryUpdate("UPDATE " + tablename + " SET havePerk='" + state + "' WHERE PlayerUUID='" + player.getUniqueId().toString() + "' AND perkName='" + perkName + "'");

    }

}
