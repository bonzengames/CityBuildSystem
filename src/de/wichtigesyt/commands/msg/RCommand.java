package de.wichtigesyt.commands.msg;

import de.wichtigesyt.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length >= 0) {

                if (MSGCommand.msg.containsKey(player)) {

                    Player target = MSGCommand.msg.get(player);

                    if (!(target == null)) {

                        String message = "";

                        for(int i = 0; i < args.length; i++) {
                            message += args[i] + " ";
                        }

                        message = message.trim();

                        player.sendMessage(Main.fileManager.messages_prefix + "§8[§6Du §a» §9" + target.getDisplayName() + "§8] §7" + message);
                        target.sendMessage(Main.fileManager.messages_prefix + "§8[§9" + player.getDisplayName() + " §a» §6Dir§8] §7" + message);

                    } else {

                        player.sendMessage(Main.fileManager.messages_prefix + "Der Spieler mit dem du geschriben hast ist offline gegangen");

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast noch mit niemandem geschrieben");

                }

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/r <Nachicht>");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
