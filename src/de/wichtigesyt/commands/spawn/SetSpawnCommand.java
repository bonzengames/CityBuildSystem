package de.wichtigesyt.commands.spawn;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.SpawnManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.premissions_setspawn)) {

                if (args.length == 0) {

                    SpawnManager spawnManager = new SpawnManager();

                    try {
                        spawnManager.setSpawn(player);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/setspawn");

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
