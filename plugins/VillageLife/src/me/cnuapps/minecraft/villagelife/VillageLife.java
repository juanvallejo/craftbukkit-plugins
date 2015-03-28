package me.cnuapps.minecraft.villagelife;

// import bukkit plugin classes
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * VillageLife plugin. Sets up initial commands and behaviours for our custom map on Google Cloud server
 *
 * @author juanvallejo
 * @date 3/22/15
 */

public class VillageLife extends JavaPlugin {

	// declare plugin constants
	public final Logger logger = Logger.getLogger("Minecraft");
	
	// declare public plugin fields
	public PluginDescriptionFile descriptionFile;
	
	// static reference to our plugin.
	// It is called from a static context by Bukkit
	public static VillageLife context;
	
	// our plugin's constructor
	public VillageLife() {
		descriptionFile = this.getDescription();
	}
	
	@Override
	public void onDisable() {
		this.logger.info(descriptionFile.getName() + " has been disabled!");
	}
	
	@Override
	public void onEnable() {
		this.logger.info(descriptionFile.getName() + " v" + descriptionFile.getVersion() + " has been enabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		// only handle commands (in this plugin) from players
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player 		= (Player)sender;
		Location location 	= player.getLocation();
		
		// if player requests home teleport, teleport player to home
		if(label.equalsIgnoreCase("home") || label.equalsIgnoreCase("spawn") || label.equalsIgnoreCase("safe") || (label.equalsIgnoreCase("5") && args.length == 2 && args[0].equals("5") && args[1].equals("5"))) {
			player.sendMessage("A magical force teleports you to a safe area.");
			location.setX(Constants.Location.HOME.getX());
			location.setY(Constants.Location.HOME.getY());
			location.setZ(Constants.Location.HOME.getZ());
			player.teleport(location);
		}
		
		return true;
	}
	
	
}
