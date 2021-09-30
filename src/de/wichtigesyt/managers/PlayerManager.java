package de.wichtigesyt.managers;

import de.wichtigesyt.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerManager {

    public static File file = new File(Main.getInstance().getDataFolder(), "player-join.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public void PlayerJoinFile(){

        if (!file.exists()) {
            try {
                config.set("null", "null");
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void addPlayer(Player player) {

        try {
            config.set(player.getUniqueId().toString(), "true");
            config.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
