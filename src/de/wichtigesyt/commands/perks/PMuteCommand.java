package de.wichtigesyt.commands.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.perks.MuteManager;
import de.wichtigesyt.managers.mysql.manager.PerksMySQLManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PMuteCommand implements CommandExecutor {

    public static ArrayList<Player> muted = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

            if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "mute").equalsIgnoreCase("aktive")) {

                if (args.length == 1) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                    } else if (target == player) {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst dich nicht selber Muten");

                    } else {

                        if (Main.muteManager.getAllowBelohnung(player)) {

                            Main.muteManager.setMutePerkUsed(player, target);

                            Main.muteManager.setMute(target, player);

                        } else {

                            long current = System.currentTimeMillis();
                            long release = MuteManager.getInstance().getTime(player);
                            long millis = release - current;
                            player.sendMessage(Main.fileManager.messages_prefix + "Du kannst den nächsten Spieler erst in " + Main.muteManager.getRemainingTime(millis) + " wieder muten");

                        }

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benute §b/pmute <Spieler>");

                }

            } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "mute").equalsIgnoreCase("true")) {

                player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Mute Perk nicht aktiviert");

            } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "mute").equalsIgnoreCase("false")) {

                player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Mute Perk noch nicht gekauft");

            }

        } else {

            sender.sendMessage(Main.fileManager.messages_noplayer);

        }

        return false;
    }
}
