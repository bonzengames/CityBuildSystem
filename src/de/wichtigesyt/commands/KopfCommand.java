package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class KopfCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_kopf)) {

                if (args.length == 1) {

                    ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
                    SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
                    skullMeta.setDisplayName(args[0]);
                    skullMeta.setOwner(args[0]);
                    skull.setItemMeta(skullMeta);

                    player.getInventory().addItem(skull);

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir den Kopf von " + args[0] + " geholt");

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/kopf <Name>");

                }

            } else {

                player.sendMessage(Main.fileManager.messages_noperms);

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
