package de.wichtigesyt.managers;

import de.wichtigesyt.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PartnerManager {

    public boolean partner_1_enabled;
    public String partner_1_name;
    public String partner_1_description;

    public boolean partner_2_enabled;
    public String partner_2_name;
    public String partner_2_description;

    public boolean partner_3_enabled;
    public String partner_3_name;
    public String partner_3_description;

    public boolean partner_4_enabled;
    public String partner_4_name;
    public String partner_4_description;

    File file = new File(Main.getInstance().getDataFolder(), "partner.yml");
    FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public void createPartnerFile() {

        if (!file.exists()) {

            try {
                config.set("partner.1.enable", "false");
                config.set("partner.1.name", "Partner 1");
                config.set("partner.1.description", "Partner 1");

                config.set("partner.2.enable", "false");
                config.set("partner.2.name", "Partner 2");
                config.set("partner.2.description", "Partner 2");

                config.set("partner.3.enable", "false");
                config.set("partner.3.name", "Partner 3");
                config.set("partner.3.description", "Partner 3");

                config.set("partner.4.enable", "false");
                config.set("partner.4.name", "Partner 4");
                config.set("partner.4.description", "Partner 4");

                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            partner_1_name = config.getString("partner.1.name");
            partner_1_description = config.getString("partner.1.description");

            partner_2_name = config.getString("partner.2.name");
            partner_2_description = config.getString("partner.2.description");

            partner_3_name = config.getString("partner.3.name");
            partner_3_description = config.getString("partner.3.description");

            partner_4_name = config.getString("partner.4.name");
            partner_4_description = config.getString("partner.4.description");

        }

    }

    public void getPartners(Player player) {



    }

}
