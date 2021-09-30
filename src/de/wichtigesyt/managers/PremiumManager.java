package de.wichtigesyt.managers;

import de.wichtigesyt.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PremiumManager {

    public void setBelohnung(Player player, Player target) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(getRewardFile());
        long toSet = System.currentTimeMillis()+86400000;
        config.set(player.getUniqueId() + ".millis", toSet);
        try {
            config.save(getRewardFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + target.getName() + " parent addtemp Premium 14d");

    }

    public boolean getAllowBelohnung(Player player) {
        long current = System.currentTimeMillis();
        long millis =+ getTime(player);
        return current > millis;

    }

    public File getRewardFile() {
        return new File(Main.getInstance().getDataFolder(), "premium.yml");
    }


    public long getTime(Player player) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(getRewardFile());
        return config.getLong(player.getUniqueId() + ".millis");
    }

    public String getRemainingTime( long millis) {
        long seconds = millis / 1000L;

        long minutes;
        for(minutes = 0L; seconds > 60L; ++minutes) {
            seconds -= 60L;
        }

        long hours;
        for(hours = 0L; minutes > 60L; ++hours) {
            minutes -= 60L;
        }

        long days;
        for(days = 0L; hours > 24L; ++days) {
            hours -= 24L;
        }
        return Main.fileManager.messages_prefix + "Du musst noch §c" + days + " Tag(e) " + hours + " Stunde(n) " + minutes + " Minute(n) " + seconds + "Sekunde(n) §cwarten";
    }

}
