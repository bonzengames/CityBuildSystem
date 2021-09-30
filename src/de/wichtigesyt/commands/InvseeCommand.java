package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_invsee)) {

                if (args.length == 1) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                    } else {

                        player.openInventory(target.getInventory());
                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Inventar nun von " + target.getName() + " geöffnet");

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/invsee <Spieler>");

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
