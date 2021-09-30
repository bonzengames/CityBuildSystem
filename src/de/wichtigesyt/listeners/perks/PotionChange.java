package de.wichtigesyt.listeners.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.mysql.manager.PerksMySQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class PotionChange implements Listener {

    @EventHandler
    public void onPotionChange(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noAbbaulaemung").equalsIgnoreCase("aktive")) {

            if (player.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {

                player.removePotionEffect(PotionEffectType.SLOW_DIGGING);

            }

        }

    }

}
