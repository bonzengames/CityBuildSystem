package de.wichtigesyt;

import de.wichtigesyt.commands.*;
import de.wichtigesyt.commands.money.*;
import de.wichtigesyt.commands.home.*;
import de.wichtigesyt.commands.msg.MSGCommand;
import de.wichtigesyt.commands.msg.RCommand;
import de.wichtigesyt.commands.perks.PMuteCommand;
import de.wichtigesyt.commands.perks.SlowchatCommand;
import de.wichtigesyt.commands.perks.StartkickCommand;
import de.wichtigesyt.commands.perks.startkick.StartkickJaCommand;
import de.wichtigesyt.commands.perks.startkick.StartkickNeinCommand;
import de.wichtigesyt.commands.spawn.*;
import de.wichtigesyt.commands.tp.*;
import de.wichtigesyt.commands.tpa.*;
import de.wichtigesyt.commands.warp.*;
import de.wichtigesyt.listeners.*;
import de.wichtigesyt.listeners.perks.*;
import de.wichtigesyt.managers.*;
import de.wichtigesyt.managers.mysql.*;
import de.wichtigesyt.listeners.perks.DoubleExp;
import de.wichtigesyt.managers.perks.MuteManager;
import de.wichtigesyt.managers.perks.SlowchatManager;
import de.wichtigesyt.managers.perks.StartkickManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static Main instance;

    public static FileManager fileManager = new FileManager();
    public static MySQLMoney mySQLMoney;
    public static MySQLPerks mySQLPerks;
    public static MySQLClan mySQLClan;

    public static ArrayList<Player> players = new ArrayList<>();

    public static BelohnungsManager belohnungsManager;
    public static PremiumManager premiumManager;
    public static MuteManager muteManager;
    public static StartkickManager startkickManager;
    public static SlowchatManager slowchatManager;

    @Override
    public void onEnable() {

        instance = this;

        checkLizens();
        conncetMysqls();
        registerCommand();
        registerEvents();

        ScoreboardManager.startupdate();

        TablistManager.setSb();

        belohnungsManager = new BelohnungsManager();
        premiumManager = new PremiumManager();
        muteManager = new MuteManager();
        startkickManager = new StartkickManager();
        slowchatManager = new SlowchatManager();

    }

    private void registerEvents() {

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new CommandBlocker(), this);

        ///Perks
        Bukkit.getPluginManager().registerEvents(new ClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new FoodEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new DoubleExp(), this);
        Bukkit.getPluginManager().registerEvents(new PotionChange(), this);

    }

    private void registerCommand() {

        getCommand("delhome").setExecutor(new DelHomeCommand());
        getCommand("home").setExecutor(new HomeCommand());
        getCommand("homes").setExecutor(new HomesCommand());
        getCommand("sethome").setExecutor(new SetHomeCommand());
        getCommand("delwarp").setExecutor(new DelWarpCommand());
        getCommand("setwarp").setExecutor(new SetWarpCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("warps").setExecutor(new WarpsCommand());
        getCommand("chatblock").setExecutor(new ChatBlockCommand());
        getCommand("clear").setExecutor(new ClearCommand());
        getCommand("clearchat").setExecutor(new ClearChatCommand());
        getCommand("ec").setExecutor(new ECCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gm").setExecutor(new GMCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("msg").setExecutor(new MSGCommand());
        getCommand("r").setExecutor(new RCommand());
        getCommand("money").setExecutor(new MoneyCommand());
        getCommand("money-admin").setExecutor(new MoneyAdminCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("tpa").setExecutor(new TpaCommand());
        getCommand("tpaccept").setExecutor(new TpaAcceptCommand());
        getCommand("tpadeny").setExecutor(new TpaDenyCommand());
        getCommand("hat").setExecutor(new HatCommand());
        getCommand("tp").setExecutor(new TpCommand());
        getCommand("premium").setExecutor(new PremiumCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("tpall").setExecutor(new TpallCommand());
        getCommand("belohnung").setExecutor(new BelohnungCommand());
        getCommand("v").setExecutor(new VanishCommand());
        getCommand("tpahere").setExecutor(new TpahereCommand());
        getCommand("tphere").setExecutor(new TphereCommand());
        getCommand("kopf").setExecutor(new KopfCommand());
        getCommand("speed").setExecutor(new SpeedCommand());
        getCommand("perks").setExecutor(new PerksCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("repair").setExecutor(new RepairCommand());
        getCommand("pmute").setExecutor(new PMuteCommand());
        getCommand("slowchat").setExecutor(new SlowchatCommand());
        getCommand("startkick").setExecutor(new StartkickCommand());
        getCommand("ja").setExecutor(new StartkickJaCommand());
        getCommand("nein").setExecutor(new StartkickNeinCommand());
        getCommand("rename").setExecutor(new RenameCommand());

    }

    private void conncetMysqls() {

        connectMoneyMySQL();
        connectPerksMySQL();
        connectClanMySQL();

    }

    private void connectMoneyMySQL() {

        try {
            mySQLMoney = new MySQLMoney(fileManager.money_mysql_ip, fileManager.money_mysql_port, fileManager.money_mysql_user, fileManager.money_mysql_password, fileManager.money_mysql_database);
            Bukkit.getConsoleSender().sendMessage("§8[§7Money-MySQL§8] §aVerbindung hergestellt");
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§8[§7Money-MySQL§8] §cVerbindung konnte nicht hergestellt werden");
        }

    }

    private void connectPerksMySQL() {

        try {
            mySQLPerks = new MySQLPerks(fileManager.perks_mysql_ip, fileManager.perks_mysql_port, fileManager.perks_mysql_user, fileManager.perks_mysql_password, fileManager.perks_mysql_database);
            Bukkit.getConsoleSender().sendMessage("§8[§7Perks-MySQL§8] §aVerbindung hergestellt");
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§8[§7Perks-MySQL§8] §cVerbindung konnte nicht hergestellt werden");
        }

    }

    private void connectClanMySQL() {

        try {
            mySQLClan = new MySQLClan(fileManager.clan_mysql_ip, fileManager.clan_mysql_port, fileManager.clan_mysql_user, fileManager.clan_mysql_password, fileManager.clan_mysql_database);
            Bukkit.getConsoleSender().sendMessage("§8[§7Clan-MySQL§8] §aVerbindung hergestellt");
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§8[§7Clan-MySQL§8] §cVerbindung konnte nicht hergestellt werden");
        }

    }

    private void checkLizens() {

        fileManager.createFiles();

        if (!new LizensManager(fileManager.lizens, "https://wichtigesyt.de/lizens/verify.php", this).register()) return;

    }

    @Override
    public void onDisable() {
    }

    public static Main getInstance() {
        return instance;
    }

}
