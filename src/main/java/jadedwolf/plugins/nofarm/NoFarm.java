package jadedwolf.plugins.nofarm;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class NoFarm extends JavaPlugin {
	private final NoFarmEntityListener entityListener = new NoFarmEntityListener(
			this);

	@Override
	public void onDisable() {
		PluginDescriptionFile plugin = getDescription();
		System.out.println(plugin.getName() + " version " + plugin.getVersion()
				+ " is now disabled");
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new NoFarmEntityListener(this), this);
		PluginManager pm = getServer().getPluginManager();
		PluginDescriptionFile plugin = getDescription();
		System.out.println(plugin.getName() + " version " + plugin.getVersion()
				+ " by mbcraft.com is now enabled.");
	}

}