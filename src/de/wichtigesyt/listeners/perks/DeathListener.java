package de.wichtigesyt.listeners.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.mysql.manager.PerksMySQLManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(event.getEntity().getUniqueId()), "keepInvsee").equalsIgnoreCase("aktive")) {

            event.setKeepInventory(true);

        }

        if (perksMySQLManager.getPerks(String.valueOf(event.getEntity().getUniqueId()), "keepXp").equalsIgnoreCase("aktive")) {

            event.setNewExp(event.getDroppedExp());

        }

    }

}
