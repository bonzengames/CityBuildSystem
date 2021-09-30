package de.wichtigesyt.commands;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatBlockCommand implements CommandExecutor {

    public static boolean chat_block = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_chatblock)) {

                if (args.length == 0) {

                    if (chat_block == false) {

                        chat_block = true;

                        for (int i = 0; i <= 120; ++i) {
                            Bukkit.broadcastMessage(" ");
                        }

                        player.sendMessage(Main.fileManager.messages_prefix + "Der Chat ist nun für alle spieler blockiert");
                        player.sendMessage(" ");

                        Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "§cDer Chat ist nun gesperrt");

                    } else if (chat_block == true) {

                        chat_block = false;

                        for (int i = 0; i <= 120; ++i) {
                            Bukkit.broadcastMessage(" ");
                        }

                        player.sendMessage(Main.fileManager.messages_prefix + "Der hat ist nun wieder frei gegeben für alle Spieler");
                        player.sendMessage(" ");

                        Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "§aDer Chat ist nun wieder freigegeben");

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze nur /clearchat");

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
