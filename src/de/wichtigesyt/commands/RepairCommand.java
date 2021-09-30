package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RepairCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_repair)) {

                if (args.length == 0) {

                    if (player.getItemInHand().equals(null)) {

                        player.getItemInHand().setDurability((short) 0);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Item in deiner Hand repariert");

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du musst ein Item in der Hand haben");

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/repair");

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
