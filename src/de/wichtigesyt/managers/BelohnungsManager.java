package de.wichtigesyt.managers;

import de.wichtigesyt.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class BelohnungsManager {

    public static BelohnungsManager instance;

    public void setBelohnung(Player player) {
        instance = this;
        FileConfiguration config = YamlConfiguration.loadConfiguration(getRewardFile());
        long toSet = System.currentTimeMillis()+86400000;
        config.set(player.getUniqueId() + ".millis", toSet);
        try {
            config.save(getRewardFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        MoneyManager moneyManager = new MoneyManager(Main.mySQLMoney, "geld");

        ItemStack steak = new ItemStack(Material.COOKED_BEEF);
        ItemStack xp = new ItemStack(Material.EXP_BOTTLE);
        moneyManager.addMoney(player, "geld", 50);
        steak.setAmount(64);
        xp.setAmount(32);
        player.getInventory().addItem(steak);
        player.getInventory().addItem(xp);

    }

    public boolean getAllowBelohnung(Player player) {
        instance = this;
        long current = System.currentTimeMillis();
        long millis =+ getTime(player);
        return current > millis;

    }

    public File getRewardFile() {
        instance = this;
        return new File(Main.getInstance().getDataFolder(), "belohnungs.yml");
    }

    public void createFile() {

        File file = new File(Main.getInstance().getDataFolder(), "belohnungs.yml");

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

    public static BelohnungsManager getInstance() {
        return instance;
    }

}
