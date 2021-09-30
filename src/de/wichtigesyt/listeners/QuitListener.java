package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    private static int task;

    private static int sek = 2;

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();

        event.setQuitMessage("");

        Main.players.remove(player);

        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                if (sek == 0) {

                    sek = 2;

                    for (Player all : Bukkit.getOnlinePlayers()) {

                        ScoreboardManager.setLobbyScore(all);

                    }

                    Bukkit.getScheduler().cancelTask(task);

                }

                sek--;

            }
        }, 0, 20);

    }

}
