package me.chokunplayz.CKPZEssential.Commands.Gamemode;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.chokunplayz.CKPZEssential.Main;
import me.chokunplayz.CKPZEssential.utils.Utils;

public class Gmsp implements CommandExecutor {
	
	//setup
	public Main pl;
	private Plugin plugin = Main.getPlugin(Main.class);
	FileConfiguration config = Main.plugin.getConfig();
	public Gmsp(Main main) {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console-denied")));
			return true;
		}
		
		Player p = (Player) sender;
		p.setGameMode(GameMode.SPECTATOR);
		p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " +plugin.getConfig().getString("Gamemode-Command.spectator")));
		return false;
	}

}
