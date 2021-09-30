package de.wichtigesyt.managers.perks;

import de.wichtigesyt.Main;
import de.wichtigesyt.managers.mysql.manager.PerksMySQLManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class PerksManager {

    private static void getMute(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "mute").equalsIgnoreCase("false")) {

            ItemStack mute = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta mute_meta = mute.getItemMeta();
            mute_meta.setDisplayName("§6Mute §7➤ §cNicht gekauft");
            mute_meta.setLore(Collections.singletonList("§6Preis: 120.000"));
            mute.setItemMeta(mute_meta);

            inv.setItem(9, mute);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "mute").equalsIgnoreCase("true")) {

            ItemStack mute = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta mute_meta = mute.getItemMeta();
            mute_meta.setDisplayName("§6Mute §7➤ §cDeaktiviert");
            mute.setItemMeta(mute_meta);

            inv.setItem(9, mute);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "mute").equalsIgnoreCase("aktive")) {

            ItemStack mute = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta mute_meta = mute.getItemMeta();
            mute_meta.setDisplayName("§6Mute §7➤ §aAktiviert");
            mute.setItemMeta(mute_meta);

            inv.setItem(9, mute);

        }

    }

    public static void getSlowChat(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "slowChat").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6SlowChat §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 150.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(10, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "slowChat").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6SlowChat §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(10, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "slowChat").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6SlowChat §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(10, slowchat_glass);

        }

    }

    private static void getStartKick(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(player.getUniqueId().toString(), "startKick").equalsIgnoreCase("false")) {

            ItemStack mute = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta mute_meta = mute.getItemMeta();
            mute_meta.setDisplayName("§6StartKick §7➤ §cNicht gekauft");
            mute_meta.setLore(Collections.singletonList("§6Preis: 200.000"));
            mute.setItemMeta(mute_meta);

            inv.setItem(11, mute);

        } else if (perksMySQLManager.getPerks(player.getUniqueId().toString(), "startKick").equalsIgnoreCase("true")) {

            ItemStack mute = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta mute_meta = mute.getItemMeta();
            mute_meta.setDisplayName("§6StartKick §7➤ §cDeaktiviert");
            mute.setItemMeta(mute_meta);

            inv.setItem(11, mute);

        } else if (perksMySQLManager.getPerks(player.getUniqueId().toString(), "startKick").equalsIgnoreCase("aktive")) {

            ItemStack mute = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta mute_meta = mute.getItemMeta();
            mute_meta.setDisplayName("§6StartKick §7➤ §aAktiviert");
            mute.setItemMeta(mute_meta);

            inv.setItem(11, mute);

        }

    }

    public static void getNoHunger(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noHunger").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Hunger §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 120.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(12, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noHunger").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Hunger §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(12, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noHunger").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Hunger §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(12, slowchat_glass);

        }

    }

    public static void getNoFall(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noFall").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Fallschaden §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 70.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(13, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noFall").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Fallschaden §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(13, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noFall").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Fallschaden §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(13, slowchat_glass);

        }

    }

    public static void getNoErtinken(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noErtrinken").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Ertrinken §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 100.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(14, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noErtrinken").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Ertrinken §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(14, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noErtrinken").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Ertrinken §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(14, slowchat_glass);

        }

    }

    public static void getNoFeurschaden(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noFeuerschaden").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Feuerschaden §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 70.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(15, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noFeuerschaden").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Feuerschaden §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(15, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noFeuerschaden").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Kein Feuerschaden §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(15, slowchat_glass);

        }

    }

    public static void getNoVergiftung(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noVergiftung").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Keine Vergiftung §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 70.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(16, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noVergiftung").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Keine Vergiftung §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(16, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noVergiftung").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Keine Vergiftung §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(16, slowchat_glass);

        }

    }

    public static void getInvNachTot(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "keepInvsee").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Inventar nach Tot behalten §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 200.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(17, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "keepInvsee").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Inventar nach Tot behalten §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(17, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "keepInvsee").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Inventar nach Tot behalten §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(17, slowchat_glass);

        }

    }

    public static void getNoAbbaulaemung(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noAbbaulaemung").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Keine Abbaulähmung §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 100.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(29, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noAbbaulaemung").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Keine Abbaulähmung §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(29, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noAbbaulaemung").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Keine Abbaulähmung §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(29, slowchat_glass);

        }

    }

    public static void getNoWither(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noWither").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Keine Wither §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 70.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(30, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noWither").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Keine Wither §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(30, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "noWither").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Keine Wither §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(30, slowchat_glass);

        }

    }

    public static void getDobbleXP(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "dobbleXp").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Doppelte XP §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 130.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(31, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "dobbleXp").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Doppelte XP §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(31, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "dobbleXp").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Doppelte XP §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(31, slowchat_glass);

        }

    }

    public static void getKeepXP(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "keepXp").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6XP nach Tot behalten §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 100.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(32, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "keepXp").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6XP nach Tot behalten §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(32, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "keepXp").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6XP nach Tot behalten §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(32, slowchat_glass);

        }

    }

    public static void getSpeedAbbau(Player player, Inventory inv) {

        PerksMySQLManager perksMySQLManager = new PerksMySQLManager(Main.mySQLPerks, "perks");

        if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "speedAbbau").equalsIgnoreCase("false")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Schnelleres abbauen §7➤ §cNicht gekauft");
            slowchat_glass_meta.setLore(Collections.singletonList("§6Preis: 200.000"));
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(33, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "speedAbbau").equalsIgnoreCase("true")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)14);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Schnelleres abbauen §7➤ §cDeaktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(33, slowchat_glass);

        } else if (perksMySQLManager.getPerks(String.valueOf(player.getUniqueId()), "speedAbbau").equalsIgnoreCase("aktive")) {

            ItemStack slowchat_glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)5);
            ItemMeta slowchat_glass_meta = slowchat_glass.getItemMeta();
            slowchat_glass_meta.setDisplayName("§6Schnelleres abbauen §7➤ §aAktiviert");
            slowchat_glass.setItemMeta(slowchat_glass_meta);

            inv.setItem(33, slowchat_glass);

        }

    }

    private static void abfrageAll(Player player, Inventory inv) {

        getMute(player, inv);
        getStartKick(player, inv);
        getSlowChat(player, inv);
        getNoHunger(player, inv);
        getNoFall(player, inv);
        getNoErtinken(player, inv);
        getNoFeurschaden(player, inv);
        getNoVergiftung(player, inv);
        getInvNachTot(player, inv);
        getNoAbbaulaemung(player, inv);
        getNoWither(player, inv);
        getDobbleXP(player, inv);
        getKeepXP(player, inv);
        getSpeedAbbau(player, inv);

    }

    public static void openInv(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9*4, "§6§lPerks");

        ItemStack mute = new ItemStack(Material.BARRIER);
        ItemMeta mute_meta = mute.getItemMeta();
        mute_meta.setDisplayName("§6Mute");
        mute.setItemMeta(mute_meta);

        ItemStack slowchat = new ItemStack(Material.WEB);
        ItemMeta slowchat_meta = slowchat.getItemMeta();
        slowchat_meta.setDisplayName("§6Slowchat");
        slowchat.setItemMeta(slowchat_meta);

        ItemStack startkick = new ItemStack(Material.PAPER);
        ItemMeta startkick_meta = startkick.getItemMeta();
        startkick_meta.setDisplayName("§6Startkick");
        startkick.setItemMeta(startkick_meta);

        ItemStack nohunger = new ItemStack(Material.COOKED_BEEF);
        ItemMeta nohunger_meta = nohunger.getItemMeta();
        nohunger_meta.setDisplayName("§6Kein Hunger");
        nohunger.setItemMeta(nohunger_meta);

        ItemStack nofall = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta nofall_meta = nofall.getItemMeta();
        nofall_meta.setDisplayName("§6Kein Fallschaden");
        nofall.setItemMeta(nofall_meta);

        ItemStack noertrinken = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta noertrinken_meta = noertrinken.getItemMeta();
        noertrinken_meta.setDisplayName("§6Kein Ertrinken");
        noertrinken.setItemMeta(noertrinken_meta);

        ItemStack nofeuerschaden = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta nofeuerschaden_meta = nofeuerschaden.getItemMeta();
        nofeuerschaden_meta.setDisplayName("§6Kein Feuerschaden");
        nofeuerschaden.setItemMeta(nofeuerschaden_meta);

        ItemStack novergiftung = new ItemStack(Material.SPLASH_POTION);
        ItemMeta novergiftung_meta = novergiftung.getItemMeta();
        novergiftung_meta.setDisplayName("§6Kein vergiftung");
        novergiftung.setItemMeta(novergiftung_meta);

        ItemStack keepInv = new ItemStack(Material.WHITE_SHULKER_BOX);
        ItemMeta keepInv_meta = keepInv.getItemMeta();
        keepInv_meta.setDisplayName("§6Inventar nach Tot behalten");
        keepInv.setItemMeta(keepInv_meta);

        ItemStack noabbau = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta noabbau_meta = noabbau.getItemMeta();
        noabbau_meta.setDisplayName("§6Keine Abbaulämung");
        noabbau.setItemMeta(noabbau_meta);

        ItemStack nowither = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
        ItemMeta nowither_meta = nowither.getItemMeta();
        nowither_meta.setDisplayName("§6Kein Wither effect");
        nowither.setItemMeta(nowither_meta);

        ItemStack dobbleExp = new ItemStack(Material.EXP_BOTTLE);
        ItemMeta dobbleExp_meta = dobbleExp.getItemMeta();
        dobbleExp_meta.setDisplayName("§6Doppelte XP");
        dobbleExp.setItemMeta(dobbleExp_meta);

        ItemStack keepExp = new ItemStack(Material.EXP_BOTTLE);
        ItemMeta keepExp_meta = keepExp.getItemMeta();
        keepExp_meta.setDisplayName("§6Xp nach Tot behalten");
        keepExp.setItemMeta(keepExp_meta);

        ItemStack speedabbau = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta speedabbau_meta = speedabbau.getItemMeta();
        speedabbau_meta.setDisplayName("§6Schnellerses abbauen");
        speedabbau.setItemMeta(speedabbau_meta);

        abfrageAll(player, inv);

        inv.setItem(0, mute);
        inv.setItem(1, slowchat);
        inv.setItem(2, startkick);
        inv.setItem(3, nohunger);
        inv.setItem(4, nofall);
        inv.setItem(5, noertrinken);
        inv.setItem(6, nofeuerschaden);
        inv.setItem(7, novergiftung);
        inv.setItem(8, keepInv);

        inv.setItem(20, noabbau);
        inv.setItem(21, nowither);
        inv.setItem(22, dobbleExp);
        inv.setItem(23, keepExp);
        inv.setItem(24, speedabbau);

        player.openInventory(inv);

    }

}
