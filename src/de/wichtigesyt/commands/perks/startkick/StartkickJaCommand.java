package de.wichtigesyt.commands.perks.startkick;

import de.wichtigesyt.Main;
import de.wichtigesyt.commands.perks.StartkickCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class StartkickJaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (StartkickCommand.startkick_aktive == true) {

                if (StartkickCommand.ja.contains(player)) {

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast bereits abgestimmt");

                } else if (!StartkickCommand.ja.contains(player)) {

                    StartkickCommand.nein.add(player);

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast für JA abgestimmt");

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast bereits abgestimmt");

                }

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Es ist kein Startkick ");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
