package de.wichtigesyt.commands.home;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.HomeManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                player.sendMessage(Main.fileManager.messages_prefix + "Bitte gib noch einen Namen an");

            } else if (args.length == 1) {

                HomeManager.setHome(player, args[0]);

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/sethome <Name>");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}