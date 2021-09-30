package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.BelohnungsManager;
import javafx.print.PageLayout;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BelohnungCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                if (Main.belohnungsManager.getAllowBelohnung(player)) {

                    Main.belohnungsManager.setBelohnung(player);

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast deine Belohnung bekommen");

                } else {

                    long current = System.currentTimeMillis();
                    long release = BelohnungsManager.getInstance().getTime(player);
                    long millis = release - current;
                    player.sendMessage(Main.fileManager.messages_prefix + "Du kannst deine Belohnung in " + Main.belohnungsManager.getRemainingTime(millis) + " abholen");

                }

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/belohnung");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
