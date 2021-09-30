package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import javafx.print.PageLayout;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_gm)) {

                if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("0")) {

                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(Main.fileManager.messages_prefix + "Du bist nun im Gamemode Survival");

                    } else if (args[0].equalsIgnoreCase("1")) {

                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(Main.fileManager.messages_prefix + "Du bist nun im Gamemode Creative");

                    } else if (args[0].equalsIgnoreCase("2")) {

                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(Main.fileManager.messages_prefix + "Du bist nun im Gamemode Adventure");

                    } else if (args[0].equalsIgnoreCase("3")) {

                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(Main.fileManager.messages_prefix + "Du bist nun im Gamemode Spectator");

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Es stehen nur Gamemode 0,1,2 und 3 zzur verfügung");

                    }

                } else if (args.length == 2) {

                    if (player.hasPermission(Main.fileManager.permissions_gm_other)) {

                        Player target = Bukkit.getPlayer(args[1]);

                        if (target == null) {

                            player.sendMessage(Main.fileManager.messages_offline);

                        } else if (target == player) {

                            player.sendMessage(Main.fileManager.messages_prefix + "Du kannst auch einfach /gm benutzen");

                        } else {

                            if (args[0].equalsIgnoreCase("0")) {

                                target.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " in den Gamemode Survival gesetzt");
                                target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + player.getName() + " in den Gamemode Survival gesetzt");

                            } else if (args[0].equalsIgnoreCase("1")) {

                                target.setGameMode(GameMode.CREATIVE);
                                player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " in den Gamemode Creative gesetzt");
                                target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + player.getName() + " in den Gamemode Creative gesetzt");

                            } else if (args[0].equalsIgnoreCase("2")) {

                                target.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " in den Gamemode Adventure gesetzt");
                                target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + player.getName() + " in den Gamemode Adventure gesetzt");

                            } else if (args[0].equalsIgnoreCase("3")) {

                                target.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " in den Gamemode Spectator gesetzt");
                                target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + player.getName() + " in den Gamemode Spectator gesetzt");

                            } else {

                                player.sendMessage(Main.fileManager.messages_prefix + "Es stehen nur Gamemode 0,1,2 und 3 zur verfügung");

                            }

                        }
                    } else {

                        player.sendMessage(Main.fileManager.messages_noperms);

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/gm <0,1,2,3> §3oder §b/gm <0,1,2,3> <Spieler>");

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
