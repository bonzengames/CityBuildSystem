package de.wichtigesyt.managers.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.commands.perks.PMuteCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class MuteManager {

    public static MuteManager instance;

    public void setMutePerkUsed(Player player, Player target) {
        instance = this;
        FileConfiguration config = YamlConfiguration.loadConfiguration(getMutePerkUsed());
        long toSet = System.currentTimeMillis()+86400000;
        config.set(player.getUniqueId() + ".millis", toSet);
        try {
            config.save(getMutePerkUsed());
        } catch (IOException e) {
            e.printStackTrace();
        }

        PMuteCommand.muted.add(target);

        player.sendMessage(Main.fileManager.messages_prefix + "Du hast den Spieler " + target.getName() + " für 24 Stunden gemuted");

    }

    public void setMute(Player player, Player target) {
        instance = this;
        FileConfiguration config = YamlConfiguration.loadConfiguration(getMutedPlayer());
        long toSet = System.currentTimeMillis()+86400000;
        config.set(player.getUniqueId() + ".millis", toSet);
        try {
            config.save(getMutedPlayer());
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + target.getName() + " gemuted für 24 Stunden");

    }

    public boolean getAllowBelohnung(Player player) {
        instance = this;
        long current = System.currentTimeMillis();
        long millis =+ getTime(player);
        return current > millis;

    }

    public boolean getMuteAllow(Player player) {
        instance = this;
        long current = System.currentTimeMillis();
        long millis =+ getMuteTime(player);
        return current > millis;

    }

    public File getMutePerkUsed() {
        instance = this;
        return new File(Main.getInstance().getDataFolder(), "muteperkused.yml");
    }

    public File getMutedPlayer() {
        instance = this;
        return new File(Main.getInstance().getDataFolder(), "mutedplayer.yml");
    }

    public void createFile() {

        File file = new File(Main.getInstance().getDataFolder(), "muteperkused.yml");
        File file2 = new File(Main.getInstance().getDataFolder(), "mutedplayer.yml");

        if (!file.exists() && !file.exists()) {

            try {
                file.createNewFile();
                file2.createNewFile();
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

    public long getMuteTime(Player player) {
        instance = this;
        FileConfiguration config = YamlConfiguration.loadConfiguration(getMutedPlayer());
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

    public static MuteManager getInstance() {
        return instance;
    }

}
