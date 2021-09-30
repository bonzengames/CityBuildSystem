package de.wichtigesyt.commands.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.commands.ChatBlockCommand;
import de.wichtigesyt.managers.mysql.manager.PerksMySQLManager;
import de.wichtigesyt.managers.perks.SlowchatManager;
import de.wichtigesyt.managers.perks.StartkickManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;

public class StartkickCommand implements CommandExecutor {

    public static int task;
    public static int sek = 30;

    public static boolean startkick_aktive = false;

    public static ArrayList<Player> ja = new ArrayList<>();
    public static ArrayList<Player> nein = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player)sender;

            PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

            if (perksMySQLManager.getPerks(player.getUniqueId().toString(), "startKick").equalsIgnoreCase("aktive")) {

                if (args.length == 1) {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null) {

                        player.sendMessage(Main.fileManager.messages_offline);

                    } else if (target == player) {

                        player.sendMessage(Main.fileManager.messages_prefix + "Du kannst dich nicht selber Startkicken");

                    } else {

                        if (Main.startkickManager.getAllowBelohnung(player)) {

                            StartkickManager.getInstance().setStartKickUsed(player);

                            startkick_aktive = true;

                            for (int i = 0; i <= 120; ++i) {
                                Bukkit.broadcastMessage(" ");
                            }

                            ChatBlockCommand.chat_block = true;

                            Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "§8§l§m----------------------------------------§4Startkick§8§l§m----------------------------------------");
                            Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "§3Der Spieler " + target.getName() + " wird von Spieler " + player.getName() + " gestartkickt");
                            Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "§3Du hast 30 Sekunden Zum abstimmen");
                            Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "§3Schreibe /ja wenn du dafür bist");
                            Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "§3Schreibe /Nein wenn du nicht dafür bist");
                            Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "§8§l§m----------------------------------------§4Startkick§8§l§m----------------------------------------");

                            task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                                @Override
                                public void run() {

                                    if (sek == 0) {

                                        if (nein.size() == ja.size()) {

                                            Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "Der Spieler wurde nicht gekickt");

                                        } else if (nein.size() > ja.size()) {

                                            Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "Der Spieler wurde nicht gekickt");

                                        } else {

                                            Bukkit.broadcastMessage(Main.fileManager.messages_prefix + "Der Spieler wurde gekickt");

                                            target.kickPlayer(Main.fileManager.messages_prefix + "Das Startkick hat dich gekickt");

                                        }

                                        ja.clear();
                                        nein.clear();

                                        ChatBlockCommand.chat_block = false;

                                        StartkickCommand.startkick_aktive = false;

                                        sek = 30;

                                        Bukkit.getScheduler().cancelTask(task);

                                    }

                                    sek--;

                                }
                            }, 0, 20);

                        } else {

                            long current = System.currentTimeMillis();
                            long release = StartkickManager.getInstance().getTime(player);
                            long millis = release - current;
                            player.sendMessage(Main.fileManager.messages_prefix + "Du kannst erst in " + StartkickManager.getInstance().getRemainingTime(millis) + " §3wieder Spieler Startkicken");

                        }

                    }

                } else {

                    player.sendMessage(Main.fileManager.messages_prefix + "Benutze §b/startkick <Spieler>");

                }

            } else if (perksMySQLManager.getPerks(player.getUniqueId().toString(), "startKick").equalsIgnoreCase("false")) {

                player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Startkick Perk noch nicht gekauft");

            } else if (perksMySQLManager.getPerks(player.getUniqueId().toString(), "startKick").equalsIgnoreCase("true")) {

                player.sendMessage(Main.fileManager.messages_prefix + "Du hast das Startkick Perk nicht aktiviert");

            }

        }

        return false;
    }

}
