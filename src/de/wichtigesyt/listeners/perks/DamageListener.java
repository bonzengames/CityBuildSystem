package de.wichtigesyt.listeners.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.mysql.manager.PerksMySQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {

        if (event.getEntity() instanceof Player) {

            Player player = (Player) event.getEntity();

            PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

            if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {

                if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noFall").equalsIgnoreCase("aktive")) {

                    event.setCancelled(true);

                }

            } else if (event.getCause().equals(EntityDamageEvent.DamageCause.FIRE) || event.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK) || event.getCause().equals(EntityDamageEvent.DamageCause.LAVA)) {

                if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noFeuerschaden").equalsIgnoreCase("aktive")) {

                    event.setCancelled(true);

                }

            } else if (event.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)) {

                if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noErtrinken").equalsIgnoreCase("aktive")) {

                    event.setCancelled(true);

                }

            } else if (event.getCause().equals(EntityDamageEvent.DamageCause.POISON)) {

                if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noVergiftung").equalsIgnoreCase("aktive")) {

                    event.setCancelled(true);

                }

            } else if (event.getCause().equals(EntityDamageEvent.DamageCause.WITHER)) {

                if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noWither").equalsIgnoreCase("aktive")) {

                    event.setCancelled(true);

                }

            }

        }

    }

}
