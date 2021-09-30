package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {

    public static ArrayList<Player> vanish = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_vanish)) {

                if (args.length == 0) {

                    if (vanish.contains(player)) {

                        vanish.remove(player);

                        player.sendMessage(Main.fileManager.messages_prefix + "Dich sehen andere Spieler wieder");

                        Main.players.add(player);

                        for (Player all : Bukkit.getOnlinePlayers()) {

                            all.showPlayer(player);

                            ScoreboardManager.setLobbyScore(all);

                        }

                    } else {

                        vanish.add(player);

                        Main.players.remove(player);

                        player.sendMessage(Main.fileManager.messages_prefix + "Dich sieht kein anderer Spieler mehr");

                        for (Player all : Bukkit.getOnlinePlayers()) {

                            all.hidePlayer(player);

                            if (all.hasPermission(Main.fileManager.permissions_vanish_seeother)){

                                all.showPlayer(player);

                            }

                            ScoreboardManager.setLobbyScore(all);

                        }

                    }

                } else if (args.length == 1){

                    if (player.hasPermission(Main.fileManager.permissions_vanish_other)) {

                        Player target = Bukkit.getPlayer(args[0]);

                        if (target == null) {

                            player.sendMessage(Main.fileManager.messages_offline);

                        } else if (target == player) {

                            player.sendMessage(Main.fileManager.messages_prefix);

                        } else {

                            if (vanish.contains(target)) {

                                vanish.add(target);

                                Main.players.remove(target);

                                player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " aus dem Vanish gesetzt");
                                target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + player.getName() + " aus dem Vanish gesetzt");

                                for (Player all : Bukkit.getOnlinePlayers()) {

                                    all.showPlayer(target);

                                    ScoreboardManager.setLobbyScore(all);

                                }

                            } else {

                                vanish.add(target);

                                Main.players.remove(target);

                                player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " in den Vanish gesetzt");
                                target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + player.getName() + " in den Vanish gesetzt");

                                for (Player all : Bukkit.getOnlinePlayers()) {

                                    all.hidePlayer(target);

                                    if (all.hasPermission(Main.fileManager.permissions_vanish_seeother)){

                                        all.showPlayer(target);

                                    }

                                    ScoreboardManager.setLobbyScore(all);

                                }

                            }

                        }

                    } else {

                        player.sendMessage(Main.fileManager.messages_noperms);

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/v");

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
