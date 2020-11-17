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

public class BoardcastCommand implements CommandExecutor {
	//setup
	public Main pl;
	private Plugin plugin = Main.getPlugin(Main.class);
	FileConfiguration config = Main.plugin.getConfig();
	//Fun Part
	public BoardcastCommand (Main main) {
	
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console-denied")));
			return true;
		}
		
		Player p = (Player) sender;
		if (args.length == 0) {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("boardcast-not-found")));
			return true;
		}
		if (args[0] == null) {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("boardcast-not-found")));
			return true;
		}
		Bukkit.broadcastMessage(plugin.getConfig().getString("boardcast-prefix") + " " + args[0]);
		p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("boardcast-done")));
		//Command Here Dont forget Crtl+Ahift+O to import nessary stuff
		return false;
	}
}
