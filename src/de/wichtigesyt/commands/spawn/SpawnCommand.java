package de.wichtigesyt.commands.spawn;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.SpawnManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                SpawnManager spawnManager = new SpawnManager();

                spawnManager.teleportSpawn(player);

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/spawn");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
