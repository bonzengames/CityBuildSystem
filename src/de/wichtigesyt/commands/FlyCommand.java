package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                if (player.getAllowFlight() == true) {

                    player.setFlying(false);
                    player.setAllowFlight(false);
                    player.sendMessage(Main.fileManager.messages_prefix + "Du kannst nun nicht mehr fliegen");

                } else if (player.getAllowFlight() == false) {

                    ///player.setFlying(true);
                    player.setAllowFlight(true);
                    player.sendMessage(Main.fileManager.messages_prefix + "Du kannst nun fliegen");

                }

            } else if (args.length == 1) {

                if (player.hasPermission(Main.fileManager.permissions_fly_other)) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == player) {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst auch einfach /fly benutzen");

                    } else if (target.getAllowFlight() == true) {

                        target.setFlying(false);
                        target.setAllowFlight(false);
                        player.sendMessage(Main.fileManager.messages_prefix + "Der Spieler " + target.getName() + " kann nun nicht mehr fliegen");
                        target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + player.getName() + " aus dem Flugmodus gesetzt");

                    } else if (target.getAllowFlight() == false) {

                        target.setFlying(true);
                        target.setAllowFlight(true);
                        player.sendMessage(Main.fileManager.messages_prefix + "Der Spieler " + target.getName() + " kann nun fliegen");
                        target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + player.getName() + " in den Flugmodus gesetzt");

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_noperms);

                }

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/fly <Spieler>");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
