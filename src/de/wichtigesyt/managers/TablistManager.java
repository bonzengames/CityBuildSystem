package de.wichtigesyt.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Iterator;

public class TablistManager {

    private static Scoreboard sb;

    public static void setSb() {

        sb = Bukkit.getScoreboardManager().getNewScoreboard();

        sb.registerNewTeam("001Owner");
        sb.registerNewTeam("002Admin");
        sb.registerNewTeam("003TeamLeitung");
        sb.registerNewTeam("004Developer");
        sb.registerNewTeam("005EventManager");
        sb.registerNewTeam("006Content");
        sb.registerNewTeam("007MasterBuilder");
        sb.registerNewTeam("008Moderator");
        sb.registerNewTeam("009Supporter");
        sb.registerNewTeam("010TestSupporter");
        sb.registerNewTeam("011Builder");
        sb.registerNewTeam("012TestBuilder");
        sb.registerNewTeam("013Partner");
        sb.registerNewTeam("014Freund");
        sb.registerNewTeam("015StreamerPlus");
        sb.registerNewTeam("016Streamer");
        sb.registerNewTeam("017King");
        sb.registerNewTeam("018Hero");
        sb.registerNewTeam("019Bonze");
        sb.registerNewTeam("020Prime");
        sb.registerNewTeam("021Master");
        sb.registerNewTeam("022Ultra");
        sb.registerNewTeam("023Premium");
        sb.registerNewTeam("024Spieler");

        sb.getTeam("001Owner").setPrefix("§4Owner §7| ");
        sb.getTeam("002Admin").setPrefix("§cAdmin §7| ");
        sb.getTeam("003TeamLeitung").setPrefix("§fTLeitung §7| ");
        sb.getTeam("004Developer").setPrefix("§bDeveloper §7| ");
        sb.getTeam("005EventManager").setPrefix("§9EManager §7| ");
        sb.getTeam("006Content").setPrefix("§6Content §7| ");
        sb.getTeam("007MasterBuilder").setPrefix("§3MBuilder §7| ");
        sb.getTeam("008Moderator").setPrefix("§1Moderator §7| ");
        sb.getTeam("009Supporter").setPrefix("§2Supporter §7| ");
        sb.getTeam("010TestSupporter").setPrefix("§2T-Support §7| ");
        sb.getTeam("011Builder").setPrefix("§3Builder §7| ");
        sb.getTeam("012TestBuilder").setPrefix("§3TBuilder §7| ");
        sb.getTeam("013Partner").setPrefix("§2Partner §7| ");
        sb.getTeam("014Freund").setPrefix("§cFreund §7| ");
        sb.getTeam("015StreamerPlus").setPrefix("§5Streamer+ §7| ");
        sb.getTeam("016Streamer").setPrefix("§5Streamer §7| ");
        sb.getTeam("017King").setPrefix("§6King §7| ");
        sb.getTeam("018Hero").setPrefix("§cHero §7| ");
        sb.getTeam("019Bonze").setPrefix("§4Bonze §7| ");
        sb.getTeam("020Prime").setPrefix("§9Prime §7| ");
        sb.getTeam("021Master").setPrefix("§cMaster §7| ");
        sb.getTeam("022Ultra").setPrefix("§bUltra §7| ");
        sb.getTeam("023Premium").setPrefix("§6Premium §7| ");
        sb.getTeam("024Spieler").setPrefix("§7Spieler §7| ");

        Iterator var1 = Bukkit.getOnlinePlayers().iterator();
        while(var1.hasNext()) {
            Player all = (Player)var1.next();
            setPrefix(all);
        }
    }

    public static void setPrefix(Player player) {
        String team = "";
        if (player.hasPermission("tab.owner")) {
            team = "001Owner";
        } else if (player.hasPermission("tab.admin")) {
            team = "002Admin";
        } else if (player.hasPermission("tab.team-leitung")) {
            team = "003TeamLeitung";
        } else if (player.hasPermission("tab.developer")) {
            team = "004Developer";
        } else if (player.hasPermission("tab.eventmanager")) {
            team = "005EventManager";
        } else if (player.hasPermission("tab.content")) {
            team = "006Content";
        } else if (player.hasPermission("tab.mbuilder")) {
            team = "007MasterBuilder";
        } else if (player.hasPermission("tab.moderator")) {
            team = "008Moderator";
        } else if (player.hasPermission("tab.supporter")) {
            team = "009Supporter";
        } else if (player.hasPermission("tab.tsupporter")) {
            team = "010TestSupporter";
        } else if (player.hasPermission("tab.builder")) {
            team = "011Builder";
        } else if (player.hasPermission("tab.testbuilder")) {
            team = "012TestBuilder";
        } else if (player.hasPermission("tab.partner")) {
            team = "013Partner";
        } else if (player.hasPermission("tab.freund")) {
            team = "014Freund";
        } else if (player.hasPermission("tab.streamer+")) {
            team = "015StreamerPlus";
        } else if (player.hasPermission("tab.streamer")) {
            team = "016Streamer";
        } else if (player.hasPermission("tab.king")) {
            team = "017King";
        } else if (player.hasPermission("tab.hero")) {
            team = "018Hero";
        } else if (player.hasPermission("tab.bonze")) {
            team = "019Bonze";
        } else if (player.hasPermission("tab.prime")) {
            team = "020Prime";
        } else if (player.hasPermission("tab.master")) {
            team = "021Master";
        } else if (player.hasPermission("tab.ultra")) {
            team = "022Ultra";
        } else if (player.hasPermission("tab.premium")) {
            team = "023Premium";
        } else {
            team = "024Spieler";
        }

        sb.getTeam(team).addPlayer(player);
        player.setScoreboard(sb);
    }

}