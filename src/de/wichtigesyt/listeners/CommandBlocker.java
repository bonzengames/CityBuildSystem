package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Locale;

public class CommandBlocker implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {

        Player player = event.getPlayer();

        if (event.getMessage().toLowerCase(Locale.ROOT).startsWith("/rl") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/reload") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/bukkit:reload") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/bukkit:rl")) {

            if (player.hasPermission("bonzenagames.reload")) {

                event.setCancelled(true);
                player.sendMessage(Main.fileManager.messages_prefix + "§cDu darfst den Server nicht reloaden!");
                return;

            } else {

                event.setCancelled(true);

                player.sendMessage(Main.fileManager.messages_noperms);


            }

            if (event.getMessage().toLowerCase(Locale.ROOT).startsWith("/bukkit:plugins") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/bukkit:pl") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/plugins") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/pl")) {

                if (player.hasPermission("bonzengames.plugins")) {

                    event.setCancelled(false);

                } else {

                    event.setCancelled(true);

                    player.sendMessage(Main.fileManager.messages_noperms);

                }

            }

            if (event.getMessage().toLowerCase(Locale.ROOT).startsWith("/minecraft:me") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/me") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/bukkit:about") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/about")) {

                event.setCancelled(true);

                player.sendMessage(Main.fileManager.messages_noperms);

            }

            if (event.getMessage().toLowerCase(Locale.ROOT).startsWith("/version") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/ver") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/bukkit:ver") || event.getMessage().toLowerCase(Locale.ROOT).startsWith("/bukkit:version")) {

                event.setCancelled(true);

                player.sendMessage(Main.fileManager.messages_noperms);

            }

            if (event.getMessage().toLowerCase(Locale.ROOT).startsWith("//calculate")) {

                event.setCancelled(true);

                player.sendMessage(Main.fileManager.messages_noperms);

            }

        }

    }

}
