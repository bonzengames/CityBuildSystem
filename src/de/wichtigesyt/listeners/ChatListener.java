package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import de.wichtigesyt.commands.ChatBlockCommand;
import de.wichtigesyt.commands.perks.PMuteCommand;
import de.wichtigesyt.managers.perks.MuteManager;
import de.wichtigesyt.managers.perks.SlowchatManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat (PlayerChatEvent event) {

        Player player = event.getPlayer();

        String message = event.getMessage().replace("&", "§");

        if (ChatBlockCommand.chat_block == false) {

            if (PMuteCommand.muted.contains(player)) {

                event.setCancelled(true);

                if (Main.muteManager.getMuteAllow(player)) {

                    event.setCancelled(true);

                    if (player.hasPermission("tab.owner")) {

                        Bukkit.broadcastMessage("§4Owner §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.admin")) {

                        Bukkit.broadcastMessage("§cAdmin §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.team-leitung")) {

                        Bukkit.broadcastMessage("§fTeamLeitung §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.developer")) {

                        Bukkit.broadcastMessage("§bDeveloper §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.eventmanager")) {

                        Bukkit.broadcastMessage("§9EManager §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.content")) {

                        Bukkit.broadcastMessage("§6Content §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.mbuilder")) {

                        Bukkit.broadcastMessage("§3MBuilder §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.moderator")) {

                        Bukkit.broadcastMessage("§1Moderator §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.supporter")) {

                        Bukkit.broadcastMessage("§2Supporter §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.tsupporter")) {

                        Bukkit.broadcastMessage("§2T-Support §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.builder")) {

                        Bukkit.broadcastMessage("§3Builder §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.testbuilder")) {

                        Bukkit.broadcastMessage("§3TBuilder §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.partner")) {

                        Bukkit.broadcastMessage("§2Partner §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.freund")) {

                        Bukkit.broadcastMessage("§cFreund/in §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.streamer+")) {

                        Bukkit.broadcastMessage("§5Streamer+ §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.streamer")) {

                        Bukkit.broadcastMessage("§5Streamer §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.king")) {

                        Bukkit.broadcastMessage("§6King §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.hero")) {

                        Bukkit.broadcastMessage("§cHero §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.bonze")) {

                        Bukkit.broadcastMessage("§4Bonze §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.prime")) {

                        Bukkit.broadcastMessage("§9Prime §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.master")) {

                        Bukkit.broadcastMessage("§cMaster §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.ultra")) {

                        Bukkit.broadcastMessage("§bUltra §7| " + player.getName() + " | " + message);

                    } else if (player.hasPermission("tab.premium")) {

                        Bukkit.broadcastMessage("§6Premium §7| " + player.getName() + " | " + message);

                    } else {

                        Bukkit.broadcastMessage("§7Spieler §7| " + player.getName() + " | " + message);

                    }

                } else {

                    long current = System.currentTimeMillis();
                    long release = MuteManager.getInstance().getMuteTime(player);
                    long millis = release - current;
                    player.sendMessage(Main.fileManager.messages_prefix + "Du bist noch für " + Main.muteManager.getRemainingTime(millis) + " gemuted");

                }

            } else if (!PMuteCommand.muted.contains(player)) {

                event.setCancelled(true);

                if (player.hasPermission("tab.owner")) {

                    Bukkit.broadcastMessage("§4Owner §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.admin")) {

                    Bukkit.broadcastMessage("§cAdmin §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.team-leitung")) {

                    Bukkit.broadcastMessage("§fTeamLeitung §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.developer")) {

                    Bukkit.broadcastMessage("§bDeveloper §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.eventmanager")) {

                    Bukkit.broadcastMessage("§9EManager §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.content")) {

                    Bukkit.broadcastMessage("§6Content §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.mbuilder")) {

                    Bukkit.broadcastMessage("§3MBuilder §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.moderator")) {

                    Bukkit.broadcastMessage("§1Moderator §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.supporter")) {

                    Bukkit.broadcastMessage("§2Supporter §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.tsupporter")) {

                    Bukkit.broadcastMessage("§2T-Support §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.builder")) {

                    Bukkit.broadcastMessage("§3Builder §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.testbuilder")) {

                    Bukkit.broadcastMessage("§3TBuilder §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.partner")) {

                    Bukkit.broadcastMessage("§2Partner §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.freund")) {

                    Bukkit.broadcastMessage("§cFreund/in §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.streamer+")) {

                    Bukkit.broadcastMessage("§5Streamer+ §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.streamer")) {

                    Bukkit.broadcastMessage("§5Streamer §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.king")) {

                    Bukkit.broadcastMessage("§6King §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.hero")) {

                    Bukkit.broadcastMessage("§cHero §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.bonze")) {

                    Bukkit.broadcastMessage("§4Bonze §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.prime")) {

                    Bukkit.broadcastMessage("§9Prime §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.master")) {

                    Bukkit.broadcastMessage("§cMaster §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.ultra")) {

                    Bukkit.broadcastMessage("§bUltra §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.premium")) {

                    Bukkit.broadcastMessage("§6Premium §7| " + player.getName() + " | " + message);

                } else {

                    Bukkit.broadcastMessage("§7Spieler §7| " + player.getName() + " | " + message);

                }

            } else if (SlowchatManager.slowchat == true) {

                event.setCancelled(true);

                event.setCancelled(true);

                if (player.hasPermission("tab.owner")) {

                    Bukkit.broadcastMessage("§4Owner §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.admin")) {

                    Bukkit.broadcastMessage("§cAdmin §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.team-leitung")) {

                    Bukkit.broadcastMessage("§fTeamLeitung §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.developer")) {

                    Bukkit.broadcastMessage("§bDeveloper §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.eventmanager")) {

                    Bukkit.broadcastMessage("§9EManager §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.content")) {

                    Bukkit.broadcastMessage("§6Content §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.mbuilder")) {

                    Bukkit.broadcastMessage("§3MBuilder §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.moderator")) {

                    Bukkit.broadcastMessage("§1Moderator §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.supporter")) {

                    Bukkit.broadcastMessage("§2Supporter §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.tsupporter")) {

                    Bukkit.broadcastMessage("§2T-Support §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.builder")) {

                    Bukkit.broadcastMessage("§3Builder §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.testbuilder")) {

                    Bukkit.broadcastMessage("§3TBuilder §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.partner")) {

                    Bukkit.broadcastMessage("§2Partner §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.freund")) {

                    Bukkit.broadcastMessage("§cFreund/in §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.streamer+")) {

                    Bukkit.broadcastMessage("§5Streamer+ §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.streamer")) {

                    Bukkit.broadcastMessage("§5Streamer §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.king")) {

                    Bukkit.broadcastMessage("§6King §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.hero")) {

                    Bukkit.broadcastMessage("§cHero §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.bonze")) {

                    Bukkit.broadcastMessage("§4Bonze §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.prime")) {

                    Bukkit.broadcastMessage("§9Prime §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.master")) {

                    Bukkit.broadcastMessage("§cMaster §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.ultra")) {

                    Bukkit.broadcastMessage("§bUltra §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.premium")) {

                    Bukkit.broadcastMessage("§6Premium §7| " + player.getName() + " | " + message);

                } else {

                    Bukkit.broadcastMessage("§7Spieler §7| " + player.getName() + " | " + message);

                }

            } else if (SlowchatManager.slowchat == false) {

                event.setCancelled(true);

                if (player.hasPermission("tab.owner")) {

                    Bukkit.broadcastMessage("§4Owner §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.admin")) {

                    Bukkit.broadcastMessage("§cAdmin §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.team-leitung")) {

                    Bukkit.broadcastMessage("§fTeamLeitung §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.developer")) {

                    Bukkit.broadcastMessage("§bDeveloper §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.eventmanager")) {

                    Bukkit.broadcastMessage("§9EManager §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.content")) {

                    Bukkit.broadcastMessage("§6Content §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.mbuilder")) {

                    Bukkit.broadcastMessage("§3MBuilder §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.moderator")) {

                    Bukkit.broadcastMessage("§1Moderator §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.supporter")) {

                    Bukkit.broadcastMessage("§2Supporter §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.tsupporter")) {

                    Bukkit.broadcastMessage("§2T-Support §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.builder")) {

                    Bukkit.broadcastMessage("§3Builder §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.testbuilder")) {

                    Bukkit.broadcastMessage("§3TBuilder §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.partner")) {

                    Bukkit.broadcastMessage("§2Partner §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.freund")) {

                    Bukkit.broadcastMessage("§cFreund/in §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.streamer+")) {

                    Bukkit.broadcastMessage("§5Streamer+ §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.streamer")) {

                    Bukkit.broadcastMessage("§5Streamer §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.king")) {

                    Bukkit.broadcastMessage("§6King §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.hero")) {

                    Bukkit.broadcastMessage("§cHero §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.bonze")) {

                    Bukkit.broadcastMessage("§4Bonze §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.prime")) {

                    Bukkit.broadcastMessage("§9Prime §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.master")) {

                    Bukkit.broadcastMessage("§cMaster §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.ultra")) {

                    Bukkit.broadcastMessage("§bUltra §7| " + player.getName() + " | " + message);

                } else if (player.hasPermission("tab.premium")) {

                    Bukkit.broadcastMessage("§6Premium §7| " + player.getName() + " | " + message);

                } else {

                    Bukkit.broadcastMessage("§7Spieler §7| " + player.getName() + " | " + message);

                }

            }

        } else if (ChatBlockCommand.chat_block == true) {

            event.setCancelled(true);

            if (player.hasPermission("tab.owner")) {

                Bukkit.broadcastMessage("§4Owner §7| " + player.getName() + " | " + message);

            } else if (player.hasPermission("tab.admin")) {

                Bukkit.broadcastMessage("§cAdmin §7| " + player.getName() + " | " + message);

            } else if (player.hasPermission("tab.team-leitung")) {

                Bukkit.broadcastMessage("§fTeamLeitung §7| " + player.getName() + " | " + message);

            } else if (player.hasPermission("tab.developer")) {

                Bukkit.broadcastMessage("§bDeveloper §7| " + player.getName() + " | " + message);

            } else {

                player.sendMessage(Main.fileManager.messages_prefix + "Der Chat ist aktuell gesperrt");

            }

        }

    }

}
