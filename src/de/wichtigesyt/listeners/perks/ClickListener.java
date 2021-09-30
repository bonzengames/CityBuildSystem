package de.wichtigesyt.listeners.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.MoneyManager;
import de.wichtigesyt.managers.perks.PerksManager;
import de.wichtigesyt.managers.mysql.manager.PerksMySQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getCurrentItem().getItemMeta().getDisplayName() != null) {

            if (event.getInventory().getName().equalsIgnoreCase("§6§lPerks")) {

                event.setCancelled(true);

                MoneyManager moneyManager  = new MoneyManager(Main.mySQLMoney, "geld");

                PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

                int money = Integer.parseInt(moneyManager.getMoney(player, "Coins"));

                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Mute §7➤ §cNicht gekauft")) {

                    if (money >= 120000) {

                        moneyManager.removeMoney(player, "geld", 120000);

                        perksMySQLManager.setPerk(player, "mute", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Mute Perk für 120.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Mute §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "mute", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Mute Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Mute §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "mute", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Mute Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6SlowChat §7➤ §cNicht gekauft")) {

                    if (money >= 150000) {

                        moneyManager.removeMoney(player, "geld", 150000);

                        perksMySQLManager.setPerk(player, "slowChat", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Slowchat Perk für 150.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6SlowChat §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "slowChat", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Slowchat Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6SlowChat §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "slowChat", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Slowchat Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6StartKick §7➤ §cNicht gekauft")) {

                    if (money >= 200000) {

                        moneyManager.removeMoney(player, "geld", 200000);

                        perksMySQLManager.setPerk(player, "startKick", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Startkick Perk für 200.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6StartKick §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "startKick", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Startkick Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6StartKick §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "startKick", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Startkick Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Hunger §7➤ §cNicht gekauft")) {

                    if (money >= 120000) {

                        moneyManager.removeMoney(player, "geld", 120000);

                        perksMySQLManager.setPerk(player, "noHunger", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Kein Hunger Perk für 120.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Hunger §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "noHunger", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Hunger Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Hunger §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "noHunger", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Hunger Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Fallschaden §7➤ §cNicht gekauft")) {

                    if (money >= 70000) {

                        moneyManager.removeMoney(player, "geld", 70000);

                        perksMySQLManager.setPerk(player, "noFall", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Kein Fallscahden Perk für 70.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Fallschaden §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "noFall", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Fallschaden Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Fallschaden §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "noFall", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Fallschaden Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Ertrinken §7➤ §cNicht gekauft")) {

                    if (money >= 100000) {

                        moneyManager.removeMoney(player, "geld", 100000);

                        perksMySQLManager.setPerk(player, "noErtrinken", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Kein Ertrinken Perk für 100.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Ertrinken §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "noErtrinken", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Ertrinken Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Ertrinken §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "noErtrinken", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Ertrinken Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Feuerschaden §7➤ §cNicht gekauft")) {

                    if (money >= 70000) {

                        moneyManager.removeMoney(player, "geld", 70000);

                        perksMySQLManager.setPerk(player, "noFeuerschaden", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Kein Feuerschaden Perk für 70.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Feuerschaden §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "noFeuerschaden", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Feuerschaden Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kein Feuerschaden §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "noFeuerschaden", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Feuerschaden Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Keine Vergiftung §7➤ §cNicht gekauft")) {

                    if (money >= 70000) {

                        moneyManager.removeMoney(player, "geld", 70000);

                        perksMySQLManager.setPerk(player, "noVergiftung", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Kein Vergiftung Perk für 70.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Keine Vergiftung §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "noVergiftung", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Vergiftung Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Keine Vergiftung §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "noVergiftung", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Vergiftung Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Inventar nach Tot behalten §7➤ §cNicht gekauft")) {

                    if (money >= 200000) {

                        moneyManager.removeMoney(player, "geld", 200000);

                        perksMySQLManager.setPerk(player, "keepInvsee", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Inventar nach Tot behalten Perk für 200.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Inventar nach Tot behalten §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "keepInvsee", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Inventar nach Tot behalten Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Inventar nach Tot behalten §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "keepInvsee", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Inventar nach Tot behalten Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Keine Abbaulähmung §7➤ §cNicht gekauft")) {

                    if (money >= 100000) {

                        moneyManager.removeMoney(player, "geld", 100000);

                        perksMySQLManager.setPerk(player, "noAbbaulaemung", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Kein Abbaulähmung Perk für 100.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Keine Abbaulähmung §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "noAbbaulaemung", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Abbaulähmung Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Keine Abbaulähmung §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "noAbbaulaemung", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Abbaulähmung Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Keine Wither §7➤ §cNicht gekauft")) {

                    if (money >= 70000) {

                        moneyManager.removeMoney(player, "geld", 70000);

                        perksMySQLManager.setPerk(player, "noWither", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Kein Wither Perk für 70.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Keine Wither §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "noWither", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Wither Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Keine Wither §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "noWither", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Kein Wither Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Doppelte XP §7➤ §cNicht gekauft")) {

                    if (money >= 130000) {

                        moneyManager.removeMoney(player, "geld", 130000);

                        perksMySQLManager.setPerk(player, "dobbleXp", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Doppelte XP Perk für 130.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Doppelte XP §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "dobbleXp", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Doppelte XP Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Doppelte XP §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "dobbleXp", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Doppelte XP Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6XP nach Tot behalten §7➤ §cNicht gekauft")) {

                    if (money >= 100000) {

                        moneyManager.removeMoney(player, "geld", 100000);

                        perksMySQLManager.setPerk(player, "keepXp", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das XP nach Tot behalten Perk für 100.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6XP nach Tot behalten §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "keepXp", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das XP nach Tot behalten Perk nun aktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6XP nach Tot behalten §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "keepXp", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das XP nach Tot behalten Perk nun deaktiviert");

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Schnelleres abbauen §7➤ §cNicht gekauft")) {

                    if (money >= 200000) {

                        moneyManager.removeMoney(player, "geld", 200000);

                        perksMySQLManager.setPerk(player, "speedAbbau", "true");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Schnelleres abbauen Perk für 200.000 Coins gekauft");

                        player.closeInventory();

                        PerksManager.openInv(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügend Coins");

                    }

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Schnelleres abbauen §7➤ §cDeaktiviert")) {

                    perksMySQLManager.setPerk(player, "speedAbbau", "aktive");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Schnelleres abbauen Perk nun aktiviert");

                    player.addPotionEffect(PotionEffectType.FAST_DIGGING.createEffect(9999999, 4));

                    player.closeInventory();

                    PerksManager.openInv(player);

                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Schnelleres abbauen §7➤ §aAktiviert")) {

                    perksMySQLManager.setPerk(player, "speedAbbau", "true");

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Schnelleres abbauen Perk nun deaktiviert");

                    player.removePotionEffect(PotionEffectType.FAST_DIGGING);

                    player.closeInventory();

                    PerksManager.openInv(player);

                }


            }

        }

    }

}
