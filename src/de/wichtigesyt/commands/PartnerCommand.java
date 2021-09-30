package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartnerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {



            } else if (args.length == 1) {



            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/partner <Server Name>");

            }

        }

        return false;
    }
}
