package de.wichtigesyt.managers;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.perks.MuteManager;
import de.wichtigesyt.managers.perks.SlowchatManager;
import de.wichtigesyt.managers.perks.StartkickManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.text.FieldPosition;

public class FileManager {

    public String lizens;

    public String money_mysql_ip;
    public String money_mysql_port;
    public String money_mysql_user;
    public String money_mysql_password;
    public String money_mysql_database;

    public String perks_mysql_ip;
    public String perks_mysql_port;
    public String perks_mysql_user;
    public String perks_mysql_password;
    public String perks_mysql_database;

    public String clan_mysql_ip;
    public String clan_mysql_port;
    public String clan_mysql_user;
    public String clan_mysql_password;
    public String clan_mysql_database;

    public String messages_prefix;
    public String messages_noperms;
    public String messages_noplayer;
    public String messages_offline;

    public String permissions_gm;
    public String permissions_gm_other;
    public String permissions_fly_other;
    public String permissions_invsee;
    public String permissions_ec_other;
    public String permissions_chatblock;
    public String permissions_clear;
    public String permissions_chatclear;
    public String permissions_money_other;
    public String permissions_money_admin;
    public String permissions_hat;
    public String permissions_tp;
    public String permissions_premium;
    public String permissions_premium_have;
    public String premissions_setspawn;
    public String permissions_tpall;
    public String permissions_vanish;
    public String permissions_vanish_other;
    public String permissions_vanish_seeother;
    public String permissions_tphere;
    public String permissions_kopf;
    public String permissions_speed_self;
    public String permissions_speed_other;
    public String permissions_heal_self;
    public String permissions_heal_other;
    public String permissions_repair;
    public String permissions_rename;

    public void LizensFile() {

        File file = new File(Main.getInstance().getDataFolder(), "lizens.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                config.set("lizens", "DEINE LIZENS");
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            lizens = config.getString("lizens");
        }

    }

    public void MySQLFile(){

        File file = new File(Main.getInstance().getDataFolder(), "mysql.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                ///money
                config.set("money.ip", "127.0.0.1");
                config.set("money.port", 3306);
                config.set("money.user", "USERNAME");
                config.set("money.password", "PASSWORD");
                config.set("money.database", "DATABASE");

                ///perks
                config.set("perks.ip", "127.0.0.1");
                config.set("perks.port", 3306);
                config.set("perks.user", "USERNAME");
                config.set("perks.password", "PASSWORD");
                config.set("perks.database", "DATABASE");

                ///clan
                config.set("clan.ip", "127.0.0.1");
                config.set("clan.port", 3306);
                config.set("clan.user", "USERNAME");
                config.set("clan.password", "PASSWORD");
                config.set("clan.database", "DATABASE");
                config.save(file);

                loadMysql();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            loadMysql();

        }

    }

    public void loadMysql() {
        File file = new File(Main.getInstance().getDataFolder(), "mysql.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        ///money
        money_mysql_ip = config.getString("money.ip");
        money_mysql_port = config.getString("money.port");
        money_mysql_user = config.getString("money.user");
        money_mysql_password = config.getString("money.password");
        money_mysql_database = config.getString("money.database");

        ///perks
        perks_mysql_ip = config.getString("perks.ip");
        perks_mysql_port = config.getString("perks.port");
        perks_mysql_user = config.getString("perks.user");
        perks_mysql_password = config.getString("perks.password");
        perks_mysql_database = config.getString("perks.database");

        ///clan
        clan_mysql_ip = config.getString("clan.ip");
        clan_mysql_port = config.getString("clan.port");
        clan_mysql_user = config.getString("clan.user");
        clan_mysql_password = config.getString("clan.password");
        clan_mysql_database = config.getString("clan.database");

    }

    public void MessageFile(){

        File file = new File(Main.getInstance().getDataFolder(), "messages.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                config.set("messages.prefix", "&4&lBonzen&5&lGames §8| §3");
                config.set("messages.nopermissions", "%prefix% Du hast keine Rechte dazu");
                config.set("messages.noplayer", "%prefix% Du bist kein Spieler");
                config.set("messages.offlineplayer", "%prefix% Der Spieler ist offline");
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            messages_prefix = config.getString("messages.prefix").replace("&","§");
            messages_noperms = config.getString("messages.nopermissions").replace("&", "§").replaceAll("%prefix%", messages_prefix);
            messages_noplayer = config.getString("messages.noplayer").replace("&", "§").replaceAll("%prefix%", messages_prefix);
            messages_offline = config.getString("messages.offlineplayer").replace("&", "§").replaceAll("%prefix%", messages_prefix);
        }

    }

    public void PermissionsFile(){

        File file = new File(Main.getInstance().getDataFolder(), "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                config.set("commands.money.other", "bonzengames.money.other");
                config.set("commands.money.admin", "bonzengames.money.admin");
                config.set("commands.gamemode.self", "bonzengames.commands.gamemode.self");
                config.set("commands.gamemode.other", "bonzengames.commands.gamemode.other");
                config.set("commands.fly.other", "bonzengames.commands.fly.other");
                config.set("commands.invsee", "bonzengames.commands.invsee");
                config.set("commands.ec.other", "bonzengames.commands.ec.other");
                config.set("commands.chatblock", "bonzengames.commands.chatblock");
                config.set("commands.clear", "bonzengames.commands.clear");
                config.set("commands.chatclear", "bonzengames.commands.chatclear");
                config.set("commands.hat", "bonzengames.commands.hat");
                config.set("commands.tp", "bonzengames.tp");
                config.set("commands.premium.set", "bonzengames.premium");
                config.set("commands.premium.have", "bonzengames.premium.haveit");
                config.set("commands.setspawn", "bonzengames.setspawn");
                config.set("commands.tpall", "bonzengames.tpall");
                config.set("commands.vanish.self", "bonzengames.vanish");
                config.set("commands.vanish.other", "bonzengames.vanish.other");
                config.set("commands.vanish.seeother", "bonzengames.vanish.see");
                config.set("commands.tphere", "bonzengames.tphere");
                config.set("commands.kopf", "bonzengames.kopf");
                config.set("commands.speed.self", "bonzengames.speed");
                config.set("commands.speed.other", "bonzengames.speed.other");
                config.set("commands.heal.self", "bonzengames.heal");
                config.set("commands.heal.other", "bonzengames.heal.other");
                config.set("commands.repair", "bonzengames.repair");
                config.set("commands.rename", "bonzengames.rename");
                config.save(file);

                loadConfig();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            loadConfig();

        }

    }

    public void loadConfig() {

        File file = new File(Main.getInstance().getDataFolder(), "permissions.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        permissions_gm = config.getString("commands.gamemode.self");
        permissions_gm_other = config.getString("commands.gamemode.other");
        permissions_fly_other = config.getString("commands.fly.other");
        permissions_invsee = config.getString("commands.invsee");
        permissions_ec_other = config.getString("commands.ec.other");
        permissions_chatblock = config.getString("commands.chatblock");
        permissions_clear = config.getString("commands.clear");
        permissions_chatclear = config.getString("commands.chatclear");
        permissions_money_other = config.getString("commands.money.other");
        permissions_money_admin = config.getString("commands.money.admin");
        permissions_hat = config.getString("commands.hat");
        permissions_tp = config.getString("commands.tp");
        permissions_premium = config.getString("commands.premium.set");
        permissions_premium_have = config.getString("commands.premium.have");
        premissions_setspawn = config.getString("commands.setspawn");
        permissions_tpall = config.getString("commands.tpall");
        permissions_vanish = config.getString("commands.vanish.self");
        permissions_vanish_other = config.getString("commands.vanish.other");
        permissions_vanish_seeother = config.getString("commands.vanish.seeother");
        permissions_tphere = config.getString("commands.tphere");
        permissions_kopf = config.getString("commands.kopf");
        permissions_speed_self = config.getString("commands.speed.self");
        permissions_speed_other = config.getString("commands.speed.other");
        permissions_heal_self = config.getString("commands.heal.self");
        permissions_heal_other = config.getString("commands.heal.other");
        permissions_repair = config.getString("commands.repair");
        permissions_rename = config.getString("commands.rename");

    }

    public void createFiles() {

        LizensFile();
        MySQLFile();
        MessageFile();
        PermissionsFile();

        PartnerManager partnerManager = new PartnerManager();
        partnerManager.createPartnerFile();

        PlayerManager playerManager = new PlayerManager();
        playerManager.PlayerJoinFile();

        BelohnungsManager belohnungsManager = new BelohnungsManager();
        belohnungsManager.createFile();

        MuteManager muteManager = new MuteManager();
        muteManager.createFile();

        SlowchatManager slowchatManager = new SlowchatManager();
        slowchatManager.createFile();

        StartkickManager startkickManager = new StartkickManager();
        startkickManager.createFile();

    }

}
