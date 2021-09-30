package de.wichtigesyt.commands.money;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.MoneyManager;
import de.wichtigesyt.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            MoneyManager moneyManager  = new MoneyManager(Main.mySQLMoney, "geld");

            Player player = (Player) sender;

            if (args.length == 0) {

                player.sendMessage(Main.fileManager.messages_prefix + " Dein Geld beträgt aktuell " + moneyManager.getMoney(player, "geld"));

            } else if (args.length == 1) {

                if (player.hasPermission(Main.fileManager.permissions_money_other)) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + " Das Geld von " + target.getName() + " beträgt aktuell " + moneyManager.getMoney(target, "geld"));

                        ScoreboardManager.setLobbyScore(player);

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_noperms);

                }

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + " Benutze §b/money <Spieler>");

            }

        }

        return false;
    }
}