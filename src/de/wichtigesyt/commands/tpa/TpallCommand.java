package de.wichtigesyt.commands.tpa;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpallCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_tpall)) {

                if (args.length == 0) {

                    for (Player all : Bukkit.getOnlinePlayers()) {

                        if (!TpaCommand.tpa.containsKey(player) && !TpaCommand.tpa.containsKey(all)) {

                            TpaCommand.tpa.put(player, all);
                            TpaCommand.tpa.put(all, player);

                            player.sendMessage(Main.fileManager.messages_prefix + "Du hast eine TPA anfrage an " + Main.players.size() + " Spieler geschickt.");

                            all.sendMessage(Main.fileManager.messages_prefix + "Du hast eine TPA anfrage von " + player.getName() + " bekommen.");
                            all.sendMessage(Main.fileManager.messages_prefix + " Du kannst die TPA mit /tpaccept annehmen oder mit /tpadeny ablehen");

                        } else {

                            player.sendMessage(Main.fileManager.messages_prefix + "Du hast zu diesem Spieler bereits eine TPA anfrage geschickt.");

                        }

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/tpall");

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
