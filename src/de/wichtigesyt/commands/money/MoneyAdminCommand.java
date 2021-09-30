package de.wichtigesyt.commands.money;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.MoneyManager;
import de.wichtigesyt.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyAdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_money_admin)) {

                MoneyManager moneyManager  = new MoneyManager(Main.mySQLMoney, "geld");

                if (args.length == 2) {

                    int money = Integer.parseInt(args[1]);

                    if (args[0].equalsIgnoreCase("set")) {

                        moneyManager.setMoney(player,"geld", String.valueOf(money));

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dein eigenes Geld auf " + money + " gesetzt");
                        player.sendMessage(Main.fileManager.messages_prefix + "Dein aktuelles Geld beträgt nach der änderung " + moneyManager.getMoney(player, "geld"));

                        ScoreboardManager.setLobbyScore(player);

                    } else if (args[0].equalsIgnoreCase("add")) {

                        moneyManager.addMoney(player,"geld", money);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast zu deinem Geld " + money + " hinzugefügt");
                        player.sendMessage(Main.fileManager.messages_prefix + "Dein aktuelles Geld beträgt nach der änderung " + moneyManager.getMoney(player, "geld"));

                        ScoreboardManager.setLobbyScore(player);

                    } else if (args[0].equalsIgnoreCase("remove")) {

                        moneyManager.removeMoney(player,"geld", money);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast von deinem Geld " + money + " weggenommen");
                        player.sendMessage(Main.fileManager.messages_prefix + "Dein aktuelles Geld beträgt nach der änderung " + moneyManager.getMoney(player, "geld"));

                        ScoreboardManager.setLobbyScore(player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/money-admin <set/add/remove> <geld> <Spieler>");

                    }

                } else if (args.length == 3) {

                    int money = Integer.parseInt(args[1]);

                    Player target = Bukkit.getPlayer(args[2]);

                    if (args[0].equalsIgnoreCase("set")) {

                        moneyManager.setMoney(target,"geld", String.valueOf(money));

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Geld von " + target.getName() + " auf " + money + " gesetzt");
                        target.sendMessage(Main.fileManager.messages_prefix + "Dein Geld wurde von " + player.getName() + " auf " + money + " gesetzt");
                        player.sendMessage(Main.fileManager.messages_prefix + "Das Geld von " + target.getName() + " beträgt nach der änderung " + moneyManager.getMoney(target, "geld"));
                        target.sendMessage(Main.fileManager.messages_prefix + "Dein aktuelles Geld beträgt nach der änderung " + moneyManager.getMoney(target, "geld"));

                        ScoreboardManager.setLobbyScore(player);
                        ScoreboardManager.setLobbyScore(target);

                    } else if (args[0].equalsIgnoreCase("add")) {

                        moneyManager.addMoney(player,"geld", money);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast zu dem Geld von " + target.getName() + " - " + money + " hinzugefügt");
                        target.sendMessage(Main.fileManager.messages_prefix + "Zu deinem Geld wurden von " + target.getName() + " - " + money + " hinzugefügt");
                        player.sendMessage(Main.fileManager.messages_prefix + "Das Geld von " + target.getName() + " beträgt nach der änderung " + moneyManager.getMoney(target, "geld"));
                        target.sendMessage(Main.fileManager.messages_prefix + "Dein aktuelles Geld beträgt nach der änderung " + moneyManager.getMoney(target, "geld"));

                        ScoreboardManager.setLobbyScore(player);
                        ScoreboardManager.setLobbyScore(target);

                    } else if (args[0].equalsIgnoreCase("remove")) {

                        moneyManager.removeMoney(player,"geld", money);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast von dem Geld von " + target.getName() + " - " + money + " entfernt");
                        target.sendMessage(Main.fileManager.messages_prefix + "Von deinem Geld wurde " + money + "entfert von " + player.getName());
                        player.sendMessage(Main.fileManager.messages_prefix + "Das Geld von " + target.getName() + " beträgt nach der änderung " + moneyManager.getMoney(target, "geld"));
                        target.sendMessage(Main.fileManager.messages_prefix + "Dein aktuelles Geld beträgt nach der änderung " + moneyManager.getMoney(target, "geld"));

                        ScoreboardManager.setLobbyScore(player);
                        ScoreboardManager.setLobbyScore(target);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/money-admin <set/add/remove> <geld> <Spieler>");

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/money-admin <set/add/remove> <geld> <Spieler>");

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
