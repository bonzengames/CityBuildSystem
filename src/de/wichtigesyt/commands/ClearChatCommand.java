package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_chatclear)) {

                if (args.length == 0) {

                    for (int i = 0; i <= 120; ++i) {
                        Bukkit.broadcastMessage(" ");
                    }

                    Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "Der Spieler " + player.getName() + " hat den Chat gelöscht");

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze nur /chatclear");

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
