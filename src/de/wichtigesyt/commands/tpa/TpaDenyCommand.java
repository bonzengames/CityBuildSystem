package de.wichtigesyt.commands.tpa;

import de.wichtigesyt.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaDenyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                Player target = TpaCommand.tpa.get(player);

                if (TpaCommand.tpa.containsKey(player) && TpaCommand.tpa.containsKey(target)) {

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                        TpaCommand.tpa.remove(player);
                        TpaCommand.tpa.remove(target);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast die TPA anfrage von " + target.getName() + " abgelehnt");
                        target.sendMessage(Main.fileManager.messages_prefix + "Deine TPA anfrage von " + player.getName() + " abgelehnt");

                        TpaCommand.tpa.remove(player);
                        TpaCommand.tpa.remove(target);

                    }

                }

            }

        }

        return false;
    }
}
