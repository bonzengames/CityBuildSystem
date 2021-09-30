package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.perks.PerksManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PerksCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                PerksManager.openInv(player);

            } else {

                player.sendMessage(Main.fileManager.messages_prefix);

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
