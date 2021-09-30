package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ECCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                player.openInventory(player.getEnderChest());
                player.sendMessage(Main.fileManager.messages_prefix + "Du hast deine Enderchest geöffnet");

            } else if (args.length == 1){

                if (player.hasPermission(Main.fileManager.permissions_ec_other)) {

                    Player target = Bukkit.getPlayer(args[0]);

                    player.openInventory(target.getEnderChest());
                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast die Enderchest von " + target.getName() + " geöffnet");

                } else if (player.hasPermission(Main.fileManager.permissions_ec_other)) {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/ec §3oder §b/ec <Spieler>");

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/ec");

                }

            } else {

                if (player.hasPermission(Main.fileManager.permissions_ec_other)) {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/ec §3oder §b/ec <Spieler>");

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/ec");

                }

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
