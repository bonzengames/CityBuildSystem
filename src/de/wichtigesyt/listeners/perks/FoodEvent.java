package de.wichtigesyt.listeners.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.mysql.manager.PerksMySQLManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodEvent implements Listener {

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(event.getEntity().getUniqueId()), "noHunger").equalsIgnoreCase("aktive")) {

            event.setCancelled(true);
            event.setFoodLevel(40);

        }

    }

}
