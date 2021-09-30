package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import javafx.print.PageLayout;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_hat)) {

                if (args.length == 0) {

                    if (!(player.getInventory().getItemInMainHand() == null)) {

                        if (!(player.getInventory().getHelmet() == null)) {

                            player.getInventory().addItem(player.getInventory().getHelmet());

                        }

                        if (!(player.getInventory().getItemInMainHand().getAmount() == 1)) {

                            ItemStack player_item = player.getInventory().getItemInMainHand();
                            ItemMeta player_item_meta = player.getInventory().getItemInMainHand().getItemMeta();
                            player_item.setItemMeta(player_item_meta);
                            player_item.setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);

                            player.getInventory().setItemInMainHand(player_item);

                            player_item.setAmount(1);

                            player.getInventory().setHelmet(player_item);

                        } else {

                            player.getInventory().setHelmet(player.getInventory().getItemInMainHand());
                            player.getInventory().setItemInMainHand(null);

                        }

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dir das Item aus deiner Hand auf dein Kopf gesetzt");

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du musst eine Item in der Hand haben");

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/hat");

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
