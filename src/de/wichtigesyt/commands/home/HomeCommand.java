package de.wichtigesyt.commands.home;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.HomeManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                HomeManager.getHome(player);

            } else if (args.length == 1) {

                HomeManager.tpHome(player, args[0]);

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/home <Name>");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
