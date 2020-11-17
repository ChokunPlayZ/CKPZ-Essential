package me.chokunplayz.CKPZEssential.Commands.Gamemode;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.chokunplayz.CKPZEssential.Main;
import me.chokunplayz.CKPZEssential.utils.Utils;

public class Gmc implements CommandExecutor{
	
	//setup
	public Main pl;
	private Plugin plugin = Main.getPlugin(Main.class);
	FileConfiguration config = Main.plugin.getConfig();
	public Gmc(Main main) {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console-denied")));
			return true;
		}
		
		Player p = (Player) sender;
		
		if (args.length == 0) {
			p.setGameMode(GameMode.CREATIVE);
			p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " +plugin.getConfig().getString("Gamemode-Command.creative")));
			return false;
		}
	
		if (p.hasPermission("ckpze.gamemode.others")) {
		
			Player traget = Bukkit.getServer().getPlayer(args[0]);
		
			if (traget == null) { //null check
				p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.gamemode-traget-null")));
				return true;
			} //null check passed !
				p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival-others")));
				traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival")));
				traget.setGameMode(GameMode.CREATIVE);
				return true;
		}
		return true;
		}
	}
