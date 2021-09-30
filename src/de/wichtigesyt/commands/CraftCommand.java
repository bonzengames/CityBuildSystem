package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.CraftingInventory;

public class CraftCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                player.openWorkbench(player.getLocation(), true);
                player.sendMessage(Main.fileManager.messages_prefix + "Du hast deine Craftingtable geöffnet");

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/craft");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
