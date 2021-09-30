package de.wichtigesyt.listeners;

import de.wichtigesyt.Main;
import de.wichtigesyt.commands.VanishCommand;
import de.wichtigesyt.managers.*;
import de.wichtigesyt.managers.mysql.manager.PerksMySQLManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class JoinListener implements Listener {

    private static int task;

    private static int sek = 2;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        MoneyManager moneyManager = new MoneyManager(Main.mySQLMoney, "geld");

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        SpawnManager spawnManager = new SpawnManager();

        moneyManager.addPlayer(player);

        perksMySQLManager.addPlayer(player);

        event.setJoinMessage("");

        player.setGameMode(GameMode.SURVIVAL);

        Main.players.add(player);

        for (Player vanish : VanishCommand.vanish) {

            player.hidePlayer(player);

        }

        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                if (sek == 0) {

                    sek = 2;

                    if (PlayerManager.config.contains(player.getUniqueId().toString())) {

                        PlayerManager playerManager = new PlayerManager();

                        playerManager.addPlayer(player);

                        ItemStack diamond_sword = new ItemStack(Material.DIAMOND_SWORD);
                        ItemStack iron_picke = new ItemStack(Material.IRON_PICKAXE);
                        ItemStack iron_axe = new ItemStack(Material.IRON_AXE);
                        ItemStack bow = new ItemStack(Material.BOW);
                        ItemStack sappling = new ItemStack(Material.SAPLING);
                        ItemStack iron_helmet = new ItemStack(Material.IRON_HELMET);
                        ItemStack iron_chestplate = new ItemStack(Material.IRON_CHESTPLATE);
                        ItemStack iron_leggins = new ItemStack(Material.IRON_LEGGINGS);
                        ItemStack iron_boots = new ItemStack(Material.IRON_BOOTS);
                        ItemStack oak = new ItemStack(Material.LOG);
                        ItemStack diamonds = new ItemStack(Material.DIAMOND);
                        ItemStack bread = new ItemStack(Material.BREAD);
                        ItemStack xp = new ItemStack(Material.EXP_BOTTLE);
                        ItemStack wool = new ItemStack(Material.WOOL);
                        ItemStack cobblestone = new ItemStack(Material.COBBLESTONE);

                        sappling.setAmount(16);
                        oak.setAmount(32);
                        diamonds.setAmount(16);
                        bread.setAmount(64);
                        xp.setAmount(16);
                        wool.setAmount(64);
                        cobblestone.setAmount(16);

                        player.getInventory().addItem(diamond_sword);
                        player.getInventory().addItem(iron_picke);
                        player.getInventory().addItem(iron_axe);
                        player.getInventory().addItem(bow);
                        player.getInventory().addItem(sappling);
                        player.getInventory().addItem(iron_helmet);
                        player.getInventory().addItem(iron_chestplate);
                        player.getInventory().addItem(iron_leggins);
                        player.getInventory().addItem(iron_boots);
                        player.getInventory().addItem(oak);
                        player.getInventory().addItem(diamonds);
                        player.getInventory().addItem(bread);
                        player.getInventory().addItem(xp);
                        player.getInventory().addItem(wool);
                        player.getInventory().addItem(cobblestone);

                    }

                    for (Player all : Bukkit.getOnlinePlayers()) {

                        ScoreboardManager.setLobbyScore(all);

                    }

                    Bukkit.getScheduler().cancelTask(task);

                }

                sek--;

            }
        }, 0, 20);

        TablistManager.setPrefix(player);

        spawnManager.teleportSpawn(player);

        setDisplayName(player);

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "speedAbbau").equalsIgnoreCase("aktive")) {

            player.addPotionEffect(PotionEffectType.FAST_DIGGING.createEffect(9999999, 4));

        }

    }

    public void setDisplayName(Player p) {
        if (p.hasPermission("tab.owner")) {
            p.setDisplayName("§4Owner §7| " + p.getName());
        } else if (p.hasPermission("tab.admin")) {
            p.setDisplayName("§cAdmin §7| " + p.getName());
        } else if (p.hasPermission("tab.team-leitung")) {
            p.setDisplayName("§fTLeitung §7| " + p.getName());
        } else if (p.hasPermission("tab.developer")) {
            p.setDisplayName("§bDeveloper §7| " + p.getName());
        } else if (p.hasPermission("tab.eventmanager")) {
            p.setDisplayName("§9EManager §7| " + p.getName());
        } else if (p.hasPermission("tab.content")) {
            p.setDisplayName("§6Content §7| " + p.getName());
        } else if (p.hasPermission("tab.mbuilder")) {
            p.setDisplayName("§3MBuilder §7| " + p.getName());
        } else if (p.hasPermission("tab.moderator")) {
            p.setDisplayName("§1Moderator §7| " + p.getName());
        } else if (p.hasPermission("tab.supporter")) {
            p.setDisplayName("§2Supporter §7| " + p.getName());
        } else if (p.hasPermission("tab.tsupporter")) {
            p.setDisplayName("§2T-Support §7| " + p.getName());
        } else if (p.hasPermission("tab.builder")) {
            p.setDisplayName("§3Builder §7| " + p.getName());
        } else if (p.hasPermission("tab.testbuilder")) {
            p.setDisplayName("§3TBuilder §7| " + p.getName());
        } else if (p.hasPermission("tab.partner")) {
            p.setDisplayName("§2Partner §7| " + p.getName());
        } else if (p.hasPermission("tab.freund")) {
            p.setDisplayName("§cFreund §7| " + p.getName());
        } else if (p.hasPermission("tab.streamer+")) {
            p.setDisplayName("§5Streamer+ §7| " + p.getName());
        } else if (p.hasPermission("tab.streamer")) {
            p.setDisplayName("§5Streamer §7| " + p.getName());
        } else if (p.hasPermission("tab.king")) {
            p.setDisplayName("§6King §7| " + p.getName());
        } else if (p.hasPermission("tab.hero")) {
            p.setDisplayName("§cHero §7| " + p.getName());
        } else if (p.hasPermission("tab.bonze")) {
            p.setDisplayName("§4Bonze §7| " + p.getName());
        } else if (p.hasPermission("tab.prime")) {
            p.setDisplayName("§9Prime §7| " + p.getName());
        } else if (p.hasPermission("tab.master")) {
            p.setDisplayName("§cMaster §7| " + p.getName());
        } else if (p.hasPermission("tab.ultra")) {
            p.setDisplayName("§bUltra §7| " + p.getName());
        } else if (p.hasPermission("tab.premium")) {
            p.setDisplayName("§6Premium §7| " + p.getName());
        } else {
            p.setDisplayName("§7Spieler §7| " + p.getName());
        }
    }

}
