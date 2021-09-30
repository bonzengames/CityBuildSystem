package de.wichtigesyt.commands.tp;

import de.wichtigesyt.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission(Main.fileManager.permissions_tp)) {

                if (args.length == 1) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                    } else if (player == target) {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst dich nicht zu dir selber teleportieren");

                    } else {

                        player.teleport(target.getLocation());

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast dich zu " + target.getName() + " teleportiert");

                    }

                } else if (args.length == 2) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                    } else if (player == target) {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst dich nicht zu dir selber teleportieren");

                    } else {

                        target.teleport(player.getLocation());

                        player.sendMessage(Main.fileManager.messages_prefix + "Du hast " + target.getName() + " zu dir teleportiert");

                        target.sendMessage(Main.fileManager.messages_prefix + "Du wurdest von " + player.getName() + " teleportiert");

                    }

                } else if (args.length == 3) {

                    World world = player.getWorld();
                    double x = Double.parseDouble(args[0]);
                    double y = Double.parseDouble(args[1]);
                    double z = Double.parseDouble(args[2]);

                    Location loc = new Location(world, x, y, z);

                    player.teleport(loc);

                    player.sendMessage(Main.fileManager.messages_prefix + "Du hast dich zu " + x + " " + y + " " + z + " teleportiert");

                }

            }

        }

        return false;
    }
}
