package de.wichtigesyt.managers;

import de.wichtigesyt.Main;
import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ScoreboardManager {

    private static int sec = 30;
    public static int Task;

    public static void setLobbyScore(Player p){
        MoneyManager moneyManager = new MoneyManager(Main.mySQLMoney,"geld");
        Scoreboard sb = new Scoreboard();
        ScoreboardObjective obj = sb.registerObjective("Lobby", IScoreboardCriteria.b);
        obj.setDisplayName("§4§lBonzen§5§lGames");
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj,0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1,obj);

        ScoreboardScore a1 = new ScoreboardScore(sb,obj,"§6");
        ScoreboardScore a2 = new ScoreboardScore(sb,obj,"§7Dein Rang:");
        ScoreboardScore a3 = new ScoreboardScore(sb,obj,"§6"+getRang(p));
        ScoreboardScore a4 = new ScoreboardScore(sb,obj,"§9");
        ScoreboardScore a5 = new ScoreboardScore(sb,obj,"§7Dein Geld:");
        ScoreboardScore a6 = new ScoreboardScore(sb,obj,"§6"+moneyManager.getMoney(p, "geld"));
        ScoreboardScore a7 = new ScoreboardScore(sb,obj,"§5");
        ScoreboardScore a8 = new ScoreboardScore(sb,obj,"§7Spieleranzahl:");
        ScoreboardScore a9 = new ScoreboardScore(sb,obj,"§6"+ Main.players.size() + "/" + Bukkit.getServer().getMaxPlayers());
        ScoreboardScore a10 = new ScoreboardScore(sb,obj,"§4");

        a1.setScore(10);
        a2.setScore(9);
        a3.setScore(8);
        a4.setScore(7);
        a5.setScore(6);
        a6.setScore(5);
        a7.setScore(4);
        a8.setScore(3);
        a9.setScore(2);
        a10.setScore(1);

        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(a1);
        PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
        PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(a3);
        PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(a4);
        PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(a5);
        PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(a6);
        PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(a7);
        PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(a8);
        PacketPlayOutScoreboardScore pa9 = new PacketPlayOutScoreboardScore(a9);
        PacketPlayOutScoreboardScore pa10 = new PacketPlayOutScoreboardScore(a10);

        sendPacket(p, removePacket);
        sendPacket(p, createPacket);
        sendPacket(p, display);

        sendPacket(p, pa1);
        sendPacket(p, pa2);
        sendPacket(p, pa3);
        sendPacket(p, pa4);
        sendPacket(p, pa5);
        sendPacket(p, pa6);
        sendPacket(p, pa7);
        sendPacket(p, pa8);
        sendPacket(p, pa9);
        sendPacket(p, pa10);

    }

    private static void sendPacket(Player p, Packet packet){
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }

    public static String getRang(Player p) {
        String rang = null;
        if (p.hasPermission("tab.owner")) {
            rang = "§4Owner";
            return rang;
        } else if (p.hasPermission("tab.admin")) {
            rang = "§cAdmin";
            return rang;
        } else if (p.hasPermission("tab.team-leitung")) {
            rang = "§fTeamLeitung";
            return rang;
        } else if (p.hasPermission("tab.developer")) {
            rang = "§bDeveloper";
            return rang;
        } else if (p.hasPermission("tab.eventmanager")) {
            rang = "§9Event Manager";
            return rang;
        } else if (p.hasPermission("tab.content")) {
            rang = "§6Content";
            return rang;
        } else if (p.hasPermission("tab.mbuilder")) {
            rang = "§3Master Builder";
            return rang;
        } else if (p.hasPermission("tab.moderator")) {
            rang = "§1Moderator";
            return rang;
        } else if (p.hasPermission("tab.supporter")) {
            rang = "§2Supporter";
            return rang;
        } else if (p.hasPermission("tab.tsupporter")) {
            rang = "§2Test Supporter";
            return rang;
        } else if (p.hasPermission("tab.builder")) {
            rang = "§3Builder";
            return rang;
        } else if (p.hasPermission("tab.testbuilder")) {
            rang = "§3Test Builder";
            return rang;
        } else if (p.hasPermission("tab.partner")) {
            rang = "§2Partner";
            return rang;
        } else if (p.hasPermission("tab.freund")) {
            rang = "§cFreund";
            return rang;
        } else if (p.hasPermission("tab.streamer+")) {
            rang = "§5Streamer+";
            return rang;
        } else if (p.hasPermission("tab.streamer")) {
            rang = "§5Streamer";
            return rang;
        } else if (p.hasPermission("tab.king")) {
            rang = "§6King";
            return rang;
        } else if (p.hasPermission("tab.hero")) {
            rang = "§cHero";
            return rang;
        } else if (p.hasPermission("tab.bonze")) {
            rang = "§4Bonze";
            return rang;
        } else if (p.hasPermission("tab.prime")) {
            rang = "§9Prime";
            return rang;
        } else if (p.hasPermission("tab.master")) {
            rang = "§cMaster";
            return rang;
        } else if (p.hasPermission("tab.ultra")) {
            rang = "§bUltra";
            return rang;
        } else if (p.hasPermission("tab.premium")) {
            rang = "§6Premium";
            return rang;
        } else {
            rang = "§7Spieler";
            return rang;
        }

    }

    public static void startupdate(){

        Task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                if (sec == 0){

                    for (Player all : Bukkit.getOnlinePlayers()){

                        ScoreboardManager.setLobbyScore(all);

                    }

                    Bukkit.getScheduler().cancelTask(Task);

                    startupdate();

                }

                sec--;

            }
        }, 0L, 20L);

    }

}
