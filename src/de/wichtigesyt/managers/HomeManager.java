package de.wichtigesyt.managers;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HomeManager {

    public static File file = new File(Main.getInstance().getDataFolder(), "home.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private static void safeFile() {

        try {
            cfg.save(file);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(Main.fileManager.messages_prefix + "§cDas Home konnte nicht gesetzt werden!");
        }

    }

    public static boolean isHomeExist(Player player, String name) {

        String home = name.toLowerCase();
        return cfg.contains(player.getUniqueId().toString() + "." + home);

    }

    public static boolean isPlayerExist(Player player, String name) {

        return cfg.contains(player.getUniqueId().toString());

    }

    public static void setHome(Player player, String name) {

        String home = name.toLowerCase();

        if (isHomeExist(player, home)) {

            player.sendMessage(Main.fileManager.messages_prefix + "Das Home existiert schon");

        } else {

            cfg.set(player.getUniqueId().toString() + "." + home + ".world", player.getLocation().getWorld().getName());
            cfg.set(player.getUniqueId().toString() + "." + home + ".x", player.getLocation().getX());
            cfg.set(player.getUniqueId().toString() + "." + home + ".y", player.getLocation().getY());
            cfg.set(player.getUniqueId().toString() + "." + home + ".z", player.getLocation().getZ());

            List<String> homes = cfg.getStringList("AllHomes" + "." + player.getUniqueId().toString());
            homes.add(home);
            cfg.set("AllHomes" + "." + player.getUniqueId().toString(), homes);

            safeFile();

            player.sendMessage(Main.fileManager.messages_prefix + "Das Home " + name + " wurde gespeichert");

        }

    }

    public static void tpHome(Player player, String name) {

        String home = name.toLowerCase();

        if (isHomeExist(player, home)) {

            World world = Bukkit.getWorld(cfg.getString(player.getUniqueId().toString() + "." + home + ".world"));
            double x = Double.parseDouble(cfg.getString(player.getUniqueId().toString() + "." + home + ".x"));
            double y = Double.parseDouble(cfg.getString(player.getUniqueId().toString() + "." + home + ".y"));
            double z = Double.parseDouble(cfg.getString(player.getUniqueId().toString() + "." + home + ".z"));

            Location loc = new Location(world, x, y, z);

            player.teleport(loc);

            player.sendMessage(Main.fileManager.messages_prefix + "Du wurdest zu deinem Home teleportiert");

        } else {

            player.sendMessage(Main.fileManager.messages_prefix + "Das Home existiert nicht");

        }

    }

    public static void getHome(Player player) {

        List<String> homes = cfg.getStringList("AllHomes" + "." + player.getUniqueId().toString());


        if (homes.isEmpty() == true) {

            player.sendMessage(Main.fileManager.messages_prefix + "Du hast noch keine Homes");

        } else {
    
            player.sendMessage(Main.fileManager.messages_prefix + "Das sind deine Homes:");

            for (String s : homes) {

                player.sendMessage(Main.fileManager.messages_prefix + "§8- §3" + s);

            }

        }

    }

    public static void delHome(Player player, String name) {

        String home = name.toLowerCase();

        if (isHomeExist(player, home)) {

            cfg.set(player.getUniqueId().toString() + "." + home, null);

            List<String> homes = cfg.getStringList("AllHomes" + "." + player.getUniqueId().toString());
            homes.remove(home);
            cfg.set("AllHomes" + "." + player.getUniqueId().toString(), homes);

            safeFile();

            player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Home " + name + " gelöscht");

        } else {

            player.sendMessage(Main.fileManager.messages_prefix + "Das Home existiert nicht");

        }

    }

}
