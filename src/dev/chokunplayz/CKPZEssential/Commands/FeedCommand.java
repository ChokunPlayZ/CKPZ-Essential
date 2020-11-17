package me.chokunplayz.CKPZEssential.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.chokunplayz.CKPZEssential.Main;
import me.chokunplayz.CKPZEssential.utils.Utils;

public class FeedCommand implements CommandExecutor{
	
	//setup
	public Main pl;
	private Plugin plugin = Main.getPlugin(Main.class);
	FileConfiguration config = Main.plugin.getConfig();
	//Fun Part
	public FeedCommand (Main main) {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console-denied")));
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("ckpze.feed")) {
			
			if (cmd.getName().equalsIgnoreCase("feed")) {
				
				if (args.length == 0) {
					p.setFoodLevel(20);
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Feed-Command.feed")));
					return true;
				}
				
				if (p.hasPermission("ckpze.feed.others")) {
					
					Player traget = Bukkit.getServer().getPlayer(args[0]);
					
					if (traget == null) { //null check
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Feed-Command.feed-others-null")));
						return true;
					}
					
					traget.setFoodLevel(20);
					traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Feed-Command.feed")));
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Feed-Command.feed-others-null")));
					return true;
				}
			}
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("noperms")));
			return true;
		}
		return false;
	}

}
