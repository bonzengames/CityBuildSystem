package de.wichtigesyt.commands.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.BelohnungsManager;
import de.wichtigesyt.managers.mysql.manager.PerksMySQLManager;
import de.wichtigesyt.managers.perks.SlowchatManager;
import javafx.print.PageLayout;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class SlowchatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

            if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "slowChat").equalsIgnoreCase("false")) {

                player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Slowchat Perk noch nicht gekauft");

            } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "slowChat").equalsIgnoreCase("true")) {

                player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Slowchat Perk nicht aktiviert");

            } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "slowChat").equalsIgnoreCase("aktive")) {

                if (args.length == 0) {

                    if (Main.slowchatManager.getAllowBelohnung(player)) {

                        SlowchatManager.getInstance().setBelohnung(player);

                    } else {

                        long current = System.currentTimeMillis();
                        long release = SlowchatManager.getInstance().getTime(player);
                        long millis = release - current;
                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst den Slowchat erst wieder in " + SlowchatManager.getInstance().getRemainingTime(millis) + " aktivieren/deaktivieren");

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/slowchat");

                }

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
