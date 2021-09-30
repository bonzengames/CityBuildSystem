package de.wichtigesyt.commands.msg;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MSGCommand implements CommandExecutor {

    public static HashMap<Player, Player> msg = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length >= 2) {

                Player target = Bukkit.getPlayer(args[0]);

                if (!(target == null)) {

                    if (!(target == player)) {

                        String message = "";

                        for (int i = 1; i < args.length; i++) {
                            message = message + args[i] + " ";
                        }

                        player.sendMessage(Main.fileManager.messages_prefix + "§8[§6Du §a» §9" + target.getDisplayName() + "§8] §7" + message);
                        target.sendMessage(Main.fileManager.messages_prefix + "§8[§9" + player.getDisplayName() + " §a» §6Dir§8] §7" + message);

                        msg.put(player, target);
                        msg.put(target, player);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst dir nicht selber schreiben");

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Der Spieler ist offline");

                }

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/msg <Spieler> <Nachicht>");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
