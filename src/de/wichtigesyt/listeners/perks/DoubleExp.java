package de.wichtigesyt.listeners.perks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class DoubleExp implements Listener {

    @EventHandler
    public void onExpChange(PlayerExpChangeEvent event) {

        int exp = event.getAmount() * event.getAmount();

        event.setAmount(exp);

    }

}
