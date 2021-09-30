package de.wichtigesyt.managers.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.commands.perks.PMuteCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class StartkickManager {

    public static StartkickManager instance;

    public void setStartKickUsed(Player player) {
        instance = this;
        FileConfiguration config = YamlConfiguration.loadConfiguration(getMutePerkUsed());
        long toSet = System.currentTimeMillis()+43200000;
        config.set(player.getUniqueId() + ".millis", toSet);
        try {
            config.save(getMutePerkUsed());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean getAllowBelohnung(Player player) {
        instance = this;
        long current = System.currentTimeMillis();
        long millis =+ getTime(player);
        return current > millis;

    }

    public File getMutePerkUsed() {
        instance = this;
        return new File(Main.getInstance().getDataFolder(), "startkick.yml");
    }

    public void createFile() {

        File file = new File(Main.getInstance().getDataFolder(), "startkick.yml");

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
        FileConfiguration config = YamlConfiguration.loadConfiguration(getMutePerkUsed());
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

    public static StartkickManager getInstance() {
        return instance;
    }

}
