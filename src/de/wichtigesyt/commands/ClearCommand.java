package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_clear)) {

                if (args.length == 0) {

                    player.getInventory().clear();

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast dein Inventar gelehrt");

                } if (args.length == 1) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                    } else {

                        target.getInventory().clear();

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast Inventar von " + target.getName() + " gelehrt");

                        target.sendMessage(Main.fileManager.messages_prefix + "Dein Inventar wurde von " + player.getName() + " gelehrt");

                    }


                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/clear <Spieler>");

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
