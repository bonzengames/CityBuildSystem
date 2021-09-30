package de.wichtigesyt.commands.tpa;

import de.wichtigesyt.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class TpaCommand implements CommandExecutor {

    public static HashMap<Player, Player> tpa = new HashMap<>();
    public static HashMap<Player, String> tpa_here = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1) {

                Player target = Bukkit.getPlayer(args[0]);

                if (target == null) {

                    player.sendMessage(Main.fileManager.messages_offline);

                } else if (target == player) {

                    player.sendMessage(Main.fileManager.messages_prefix + "Du kannst dir keine TPA selber schicken");

                } else {

                    if (!tpa.containsKey(player) && !tpa.containsKey(target)) {

                        tpa.put(player, target);
                        tpa.put(target, player);

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " eine TPA anfrage geschickt.");

                        target.sendMessage(Main.fileManager.messages_prefix + "Du hast eine TPA anfrage von " + player.getName() + " bekommen.");
                        target.sendMessage(Main.fileManager.messages_prefix + " Du kannst die TPA mit /tpaccept annehmen oder mit /tpadeny ablehen");

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast zu diesem Spieler bereits eine TPA anfrage geschickt.");

                    }

                }

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/tpa <Spieler>");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
