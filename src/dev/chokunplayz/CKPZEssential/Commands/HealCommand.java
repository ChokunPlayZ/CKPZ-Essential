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

public class HealCommand implements CommandExecutor{

	//setup
	public Main pl;
	private Plugin plugin = Main.getPlugin(Main.class);
	FileConfiguration config = Main.plugin.getConfig();
	//Fun Part
	public HealCommand (Main main) {
	
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console-denied")));
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("ckpze.feed")) { // check perms use
			
			if (cmd.getName().equalsIgnoreCase("heal")) {
				
				if (args.length == 0) {  // only /heal no args
					p.setHealth(20);
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Heal-Command.heal")));
					return true;
				}
				
				if (p.hasPermission("ckpze.feed.others")) { //check perms others
					
					Player traget = Bukkit.getServer().getPlayer(args[0]); //add value call traget /heal <others> in use
					
					if (traget == null) { //null check
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Heal-Command.heal-others-null")));
						return true;
					} //pass null check continue
					
					traget.setHealth(20); //player check ok heal
					traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix" + "Heal-Command.heal")));
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Heal-Command.heal-others")));
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
