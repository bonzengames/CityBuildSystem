package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_speed_self)) {

                if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("1")) {

                        player.setFlySpeed((float) 0.2);
                        player.setWalkSpeed((float) 0.15);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast jetzt eine geschwindigkeit von 1 eingestllet");

                    } else if (args[0].equalsIgnoreCase("2")) {

                        player.setFlySpeed((float) 0.3);
                        player.setWalkSpeed((float) 0.3);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast jetzt eine geschwindigkeit von 2 eingestllet");

                    } else if (args[0].equalsIgnoreCase("3")) {

                        player.setFlySpeed((float) 0.4);
                        player.setWalkSpeed((float) 0.4);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast jetzt eine geschwindigkeit von 3 eingestllet");

                    } else if (args[0].equalsIgnoreCase("4")) {

                        player.setFlySpeed((float) 0.5);
                        player.setWalkSpeed((float) 0.5);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast jetzt eine geschwindigkeit von 4 eingestllet");

                    } else if (args[0].equalsIgnoreCase("5")) {

                        player.setFlySpeed((float) 0.5);
                        player.setWalkSpeed((float) 0.5);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast jetzt eine geschwindigkeit von 5 eingestllet");

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Es stehen nur 1 bis 5 nur verfügung");

                    }

                } else {

                   player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/speed <1-5>");

                }

            } else {

                player.sendMessage(Main.fileManager.messages_noperms);

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noperms);

        }

        return false;
    }
}
