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

public class SpawnManager {

    public static File file = new File(Main.getInstance().getDataFolder(), "spawn.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void setSpawn(Player player) throws IOException {

        cfg.set("spawn.world", player.getWorld().getName());
        cfg.set("spawn.x", player.getLocation().getX());
        cfg.set("spawn.y", player.getLocation().getY());
        cfg.set("spawn.z", player.getLocation().getZ());
        cfg.save(file);

        player.sendMessage(Main.fileManager.messages_prefix + "Du hast den Spawn gesetzt");

    }

    public void teleportSpawn(Player player) {

        if (cfg.contains("spawn.world")) {

            World world = Bukkit.getWorld(cfg.getString("spawn.world"));
            double x = cfg.getDouble("spawn.x");
            double y = cfg.getDouble("spawn.y");
            double z = cfg.getDouble("spawn.z");

            Location loc = new Location(world, x, y, z);

            player.teleport(loc);

        } else {

            player.sendMessage(Main.fileManager.messages_prefix + "Der Spawn wurde noch nicht gesetzt!");

        }

    }

}
