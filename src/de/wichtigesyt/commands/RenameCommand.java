package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_rename)) {

                if (args.length >= 1) {

                    String message = "";

                    for (int i = 1; i < args.length; i++) {
                        message = message + args[i] + " ".replace("&", "3");
                    }

                    if (!(player.getInventory().getItemInMainHand() == null)) {

                        ItemStack istack = player.getInventory().getItemInMainHand();
                        ItemMeta istack_meta = player.getInventory().getItemInMainHand().getItemMeta();
                        istack_meta.setDisplayName(message);
                        istack.setItemMeta(istack_meta);

                        player.setItemInHand(istack);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Item in deiner Hand umgenannt in: " + message);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast kein Item in der Hand");

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/rename <Name>");

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
