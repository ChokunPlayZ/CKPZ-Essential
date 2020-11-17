package me.chokunplayz.CKPZEssential.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chokunplayz.CKPZEssential.Main;

public class About implements CommandExecutor {

		public Main plugin;

		public About(Main main) {
			
		}
		
		

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("No Console Not your time");
			return true;
		}
		
		sender.sendMessage("Plugin Made By ChokunPlayZ");
		sender.sendMessage("in the name of CKPZMC Team");
		sender.sendMessage("Please Go Check This out");
		sender.sendMessage("https://www.ckpzmc.xyz/plugins");
		return false;
	}
}
