package me.chokunplayz.CKPZEssential.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.chokunplayz.CKPZEssential.Main;
import me.chokunplayz.CKPZEssential.utils.Utils;

public class FlyCommand implements CommandExecutor{

	@SuppressWarnings("unused")
	private Main pl;
	private Plugin plugin = Main.getPlugin(Main.class);
	
	FileConfiguration config = Main.plugin.getConfig();
	
	public FlyCommand(Main main) {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) { //no Console you cannot fly
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console-denied")));
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("ckpze.fly")) {
			
			if (cmd.getName().equalsIgnoreCase("fly")) {
				if (p.isFlying()) { //is he flying ? if yes run this below
					p.setAllowFlight(false);
					p.setFlying(false);
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Fly-Command.flying-disable")));
					return true;
				} else { //else turn on his flight
					p.setAllowFlight(true);
					p.setFlying(true);
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Fly-Command.flying-enable")));
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
