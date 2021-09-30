package de.wichtigesyt.commands.money;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.MoneyManager;
import de.wichtigesyt.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PayCommand implements CommandExecutor {

    public static ArrayList<Player> players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            MoneyManager moneyManager = new MoneyManager(Main.mySQLMoney, "geld");

            Player player = (Player) sender;

            if (args.length == 2) {

                if (args[0].equalsIgnoreCase("all")) {

                    players.clear();

                    for (Player all : Bukkit.getOnlinePlayers()) {

                        players.add(all);

                        players.remove(player);

                    }

                    for (Player all : players) {

                        int money = Integer.parseInt(args[1]);

                        int akt_money = Integer.parseInt(moneyManager.getMoney(player, "geld"));

                        int money_all = money * players.size();

                        if (akt_money >= money_all) {

                            moneyManager.payMoney(player, all, money);

                            player.sendMessage(Main.fileManager.messages_prefix + "Du hast an " + players.size() + " Spieler spieler insgesamt " + money_all + " Geld gezahlt");

                            all.sendMessage(Main.fileManager.messages_prefix + "Der Spieler " + player.getName() + " hat an alle Spieler " + money + " Geld gegeben");

                        } else {

                            player.sendMessage(Main.fileManager.messages_prefix + "Du hast nicht genügent Geld");

                        }

                    }

                } else {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                    } else if (target == player) {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst dir selber kein Geld geben");

                    } else if (target.getAddress().toString() == player.getAddress().toString()) {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst deinem Zweit account kein Geld geben");

                    } else {

                        int money = Integer.parseInt(args[1]);

                        moneyManager.payMoney(player, target, money);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " einen betrag von " + money + " bezahlt");
                        target.sendMessage(Main.fileManager.messages_prefix + "Dir wurde von " + player.getName() + " ein betrag von " + money + " bezahlt");

                        ScoreboardManager.setLobbyScore(player);
                        ScoreboardManager.setLobbyScore(target);

                    }

                }

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/pay <Spieler> <Geld>");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}