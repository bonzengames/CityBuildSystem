package de.wichtigesyt.commands.tpa;

import de.wichtigesyt.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaAcceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                Player target = TpaCommand.tpa.get(player);

                if (TpaCommand.tpa.containsKey(player) && TpaCommand.tpa.containsKey(target)) {

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                    } else {

                        target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest zu " + player.getName() + " teleportiert");
                        player.sendMessage(Main.fileManager.messages_prefix + "Der Spieler " + target.getName() + " wurde zu dir teleportiert");

                        target.teleport(player.getLocation());

                        TpaCommand.tpa.remove(player);
                        TpaCommand.tpa.remove(target);

                    }

                } else if (TpaCommand.tpa_here.containsKey(player)) {

                    if (TpaCommand.tpa.containsKey(player) && TpaCommand.tpa.containsKey(target)) {

                        if (target == null) {

                            player.sendMessage(Main.fileManager.messages_offline);

                        } else {

                            player.sendMessage(Main.fileManager.messages_prefix + "Du wurdest zu " + player.getName() + " teleportiert");
                            target.sendMessage(Main.fileManager.messages_prefix + "Der Spieler " + target.getName() + " wurde zu dir teleportiert");

                            player.teleport(target.getLocation());

                            TpaCommand.tpa.remove(player);
                            TpaCommand.tpa.remove(target);

                        }

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast keine TPA anfrage bekommen");

                }

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze /§b/tpaccept");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
