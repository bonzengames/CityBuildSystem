package de.wichtigesyt.commands.tpa;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpahereCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1) {

                Player target = Bukkit.getPlayer(args[0]);

                if (target == null) {

                    player.sendMessage(Main.fileManager.messages_offline);

                } else if (target == player) {

                    player.sendMessage(Main.fileManager.messages_prefix + "Du kannst dir keine TPA selber schicken");

                } else {

                    if (!TpaCommand.tpa.containsKey(player) && !TpaCommand.tpa.containsKey(target)) {

                        TpaCommand.tpa.put(player, target);
                        TpaCommand.tpa.put(target, player);
                        TpaCommand.tpa_here.put(player, "here");

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " eine TPA anfrage geschickt.");

                        target.sendMessage(Main.fileManager.messages_prefix + "Du hast eine TPA anfrage von " + player.getName() + " bekommen.");
                        target.sendMessage(Main.fileManager.messages_prefix + " Du kannst die TPA mit /tpaccept annehmen oder mit /tpadeny ablehen");

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast zu diesem Spieler bereits eine TPA anfrage geschickt.");

                    }

                }

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/tpa <Spieler>");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
