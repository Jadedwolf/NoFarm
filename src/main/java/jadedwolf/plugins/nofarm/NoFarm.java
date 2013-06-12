package jadedwolf.plugins.nofarm;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoFarm extends JavaPlugin {

    static final Logger log = Logger.getLogger("Minecraft");
    private final NoFarmEntityListener entityListener = new NoFarmEntityListener(
            this);
    private final NoFarmMobListener mobListener = new NoFarmMobListener(
            this);

    @Override
    public void onDisable() {
        PluginDescriptionFile plugin = getDescription();
        System.out.println(plugin.getName() + " version " + plugin.getVersion()
                + " is now Disabled");
    }

    @Override
    public void onEnable() {

        // Load configuration
        FileConfigurationOptions cfgOptions = getConfig().options();
        cfgOptions.copyDefaults(true);
        cfgOptions.copyHeader(true);
        saveConfig();

        PluginManager pm = getServer().getPluginManager();

        if (getConfig().getBoolean("NonPlayerDamageDropsItems", true)) {
            getServer().getPluginManager().registerEvents(this.entityListener, this);
        }
        if (getConfig().getBoolean("MobsDoNotTakeFallDamage", true)) {
            getServer().getPluginManager().registerEvents(this.mobListener, this);
        }

        PluginDescriptionFile plugin = getDescription();
        System.out.println(plugin.getName() + " version " + plugin.getVersion()
                + " by lagcraft.com is now enabled.");



    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("nofarm")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args[0].equalsIgnoreCase("reload")) {
                    reloadConfig();
                    player.sendMessage("The config.yml file has been reloaded.");
                }
            } else {
                reloadConfig();
                System.out.println("NoFarm Config Reloaded");
            }
        }
        return false;
    }
}