package de.wichtigesyt.managers;

import de.wichtigesyt.Main;
import org.apache.logging.log4j.core.jmx.LoggerConfigAdmin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class WarpManager {

    public static File file = new File(Main.getInstance().getDataFolder(), "warps.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private static void saveFile() {

        try {
            cfg.save(file);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(Main.fileManager.messages_prefix + "Das Warp konnte nicht gespeichert werden");
        }

    }

    public static void getWarps(Player player) {

        List<String> warps = cfg.getStringList("AllWarps");

        if (warps.isEmpty() == true) {

            player.sendMessage(Main.fileManager.messages_prefix + "Es gibt noch keine Warps");

        } else {

            player.sendMessage(Main.fileManager.messages_prefix + "Das sind die Warps:");

            for (String s : warps) {

                player.sendMessage(Main.fileManager.messages_prefix + "§8- §3" + s);

            }

        }

    }

    public static boolean isWarpExists(String name) {

        String warp = name.toLowerCase();

        return cfg.contains(warp);

    }

    public static void createWarp(Player player, String name) {

        String warp = name.toLowerCase();

        if (isWarpExists(warp)) {

            player.sendMessage(Main.fileManager.messages_prefix + "Das Warp existiert schon");

        } else {

            cfg.set(warp + ".world", player.getLocation().getWorld().getName());
            cfg.set(warp + ".x", player.getLocation().getX());
            cfg.set(warp + ".y", player.getLocation().getY());
            cfg.set(warp + ".z", player.getLocation().getZ());

            List<String> warps = cfg.getStringList("AllWarps");
            warps.add(warp);
            cfg.set("AllWarps", warps);

            saveFile();

            player.sendMessage(Main.fileManager.messages_prefix + "Du hast nun den Warp " + name + " gesetzt");

        }

    }

    public static void deleteWarp(Player player, String name) {

        String warp = name.toLowerCase();

        if (isWarpExists(warp)) {

            cfg.set(warp, null);

            List<String> warps = cfg.getStringList("AllWarps");
            warps.remove(warp);
            cfg.set("AllWarps", warps);
            saveFile();

            player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Warp " + name + " gelöscht");

        } else {

            player.sendMessage(Main.fileManager.messages_prefix + "Das Warp gibt es nicht");

        }

    }

    public static void teleportWarp(Player player, String name) {

        String warp = name.toLowerCase();

        if (isWarpExists(warp)) {

            World world = Bukkit.getWorld(cfg.getString(warp + ".world"));
            double x = cfg.getDouble(warp + ".x");
            double y = cfg.getDouble(warp + ".y");
            double z = cfg.getDouble(warp + ".z");

            Location loc = new Location(world, x, y, z);

            player.teleport(loc);

            player.sendMessage(Main.fileManager.messages_prefix + "Du wurdest zum warp " + name + " teleport");

        } else {

            player.sendMessage(Main.fileManager.messages_prefix + "Das Warp " + name + " exestiert nicht");

        }

    }

}
