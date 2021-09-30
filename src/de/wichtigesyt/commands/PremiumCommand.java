package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.PremiumManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PremiumCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_premium)) {

                if (args.length == 1) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                    } else if (player == target) {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst dir nicht selber den Premium Rang geben");

                    } else if (player.getAddress() == target.getAddress()) {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst deinem Zweit account den Premium Rang nicht geben");

                    } else {

                        if (!target.hasPermission(Main.fileManager.permissions_premium_have)) {

                            if (Main.premiumManager.getAllowBelohnung(player)) {

                                Main.premiumManager.setBelohnung(player, target);

                                player.sendMessage(Main.fileManager.messages_prefix + "Du hast dem Spieler " + target.getName() + " für 14 tage den Premium Rang gegeben");

                            } else {

                                long current = System.currentTimeMillis();
                                long release = Main.premiumManager.getTime(player);
                                long millis = release - current;
                                player.sendMessage(Main.premiumManager.getRemainingTime(millis));

                            }

                        } else {

                            player.sendMessage(Main.fileManager.messages_prefix +  "Du kannst " + target.getName() + " kein Premium geben da er schon Premium hat oder einen anderen Rang");

                        }


                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/premium <Spieler>");

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
