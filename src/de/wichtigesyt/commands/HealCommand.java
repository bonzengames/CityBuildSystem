package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import javafx.print.PageLayout;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_heal_self)) {

                if (args.length == 0) {

                    player.setHealth(20);
                    player.setFoodLevel(40);

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast dich geheilt");

                } else if (args.length == 1) {

                    if (player.hasPermission(Main.fileManager.permissions_heal_other)) {

                        Player target = Bukkit.getPlayer(args[0]);

                        if (target == null) {

                            player.sendMessage(Main.fileManager.messages_offline);

                        } else {

                            target.setHealth(20);
                            target.setFoodLevel(40);

                            target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + player.getName() + " geheilt");
                            player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " geheilt");

                        }

                    } else {

                        player.sendMessage(Main.fileManager.messages_noperms);

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benute §b/heal <Name>");

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
