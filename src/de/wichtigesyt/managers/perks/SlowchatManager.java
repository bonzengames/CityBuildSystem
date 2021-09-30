package de.wichtigesyt.managers.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.BelohnungsManager;
import de.wichtigesyt.managers.MoneyManager;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class SlowchatManager {

    public static SlowchatManager instance;

    public static boolean slowchat = false;

    public void setBelohnung(Player player) {
        instance = this;
        FileConfiguration config = YamlConfiguration.loadConfiguration(getRewardFile());
        long toSet = System.currentTimeMillis() + 43200000;
        config.set(player.getUniqueId() + ".millis", toSet);
        try {
            config.save(getRewardFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (slowchat == false) {

            slowchat = true;

            player.sendMessage(Main.fileManager.messages_prefix + "Du hast den Slowchat aktiviert");

        } else if (slowchat == true) {

            slowchat = false;

            player.sendMessage(Main.fileManager.messages_prefix + "Du hast den Slowchat deaktiviert");

        }

    }

    public boolean getAllowBelohnung(Player player) {
        instance = this;
        long current = System.currentTimeMillis();
        long millis =+ getTime(player);
        return current > millis;

    }

    public File getRewardFile() {
        instance = this;
        return new File(Main.getInstance().getDataFolder(), "slowchat.yml");
    }

    public void createFile() {

        File file = new File(Main.getInstance().getDataFolder(), "slowchat.yml");

        if (!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public long getTime(Player player) {
        instance = this;
        FileConfiguration config = YamlConfiguration.loadConfiguration(getRewardFile());
        return config.getLong(player.getUniqueId() + ".millis");
    }

    public String getRemainingTime( long millis) {
        instance = this;
        long seconds = millis/1000;
        long minutes = 0;
        while(seconds > 60) {
            seconds -= 60;
            minutes++;
        }
        long hours = 0;
        while(minutes >60) {
            minutes -= 60;
            hours++;
        }
        return "§e" + hours + " Stunde(n) " + minutes + " Minute(n) " + seconds + "Sekunde(n) ";
    }

    public static SlowchatManager getInstance() {
        return instance;
    }

}
