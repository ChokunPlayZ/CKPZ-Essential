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

public class Gamemode implements CommandExecutor {
	
	//setup
	public Main pl;
	private Plugin plugin = Main.getPlugin(Main.class);
	FileConfiguration config = Main.plugin.getConfig();
	public Gamemode(Main main) {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console-denied")));
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("ckpze.gamemode")) {
			
			if (cmd.getName().equalsIgnoreCase("gamemode")) {
				
				if (args.length == 2) {
					//player name check
					if (p.hasPermission("ckpze.gamemode.others")) {
						
					Player traget = Bukkit.getServer().getPlayer(args[1]); //add value call traget / <others> in use
						
					if (traget == null) { //null check
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.gamemode-traget-null")));
						return true;
					} //pass null check continue
					
					if (args.length == 0) { //no gamemode args
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.gamemode-no-args")));							
						return true;
					}
					
					if (args[0].equalsIgnoreCase("0")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival")));
						traget.setGameMode(GameMode.SURVIVAL);
						return true;
					}
					if (args[0].equalsIgnoreCase("1")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.creative-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.creative")));
						traget.setGameMode(GameMode.CREATIVE);
						return true;
					}
					if (args[0].equalsIgnoreCase("2")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.adventure-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.adventure")));
						traget.setGameMode(GameMode.ADVENTURE);
						return true;
					}
					if (args[0].equalsIgnoreCase("3")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.spectator-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.spectator")));
						traget.setGameMode(GameMode.SPECTATOR);
						return true;
					}
						
					//Calling Me NAMES???
						
					if (args[0].equalsIgnoreCase("survival")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival")));
						traget.setGameMode(GameMode.SURVIVAL);
						return true;
					}
					if (args[0].equalsIgnoreCase("creative")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.creative-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.creative")));
						traget.setGameMode(GameMode.CREATIVE);
						return true;
					}
					if (args[0].equalsIgnoreCase("adventure")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.adventure-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.adventure")));
						traget.setGameMode(GameMode.ADVENTURE);
						return true;
					}
					if (args[0].equalsIgnoreCase("spectator")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.spectator-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.spectator")));
						traget.setGameMode(GameMode.SPECTATOR);
						return true;
					}
						
					//Nickname is more Forgivable
						
					if (args[0].equalsIgnoreCase("s")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival")));
						traget.setGameMode(GameMode.SURVIVAL);
						return true;
					}
					if (args[0].equalsIgnoreCase("c")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.creative-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.creative")));
						traget.setGameMode(GameMode.CREATIVE);
						return true;
					}
					if (args[0].equalsIgnoreCase("a")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.adventure-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.adventure")));
						traget.setGameMode(GameMode.ADVENTURE);
						return true;
					}
					if (args[0].equalsIgnoreCase("sp")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.spectator-others")));
						traget.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.spectator")));
						traget.setGameMode(GameMode.SPECTATOR);
						return true;
					} else {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.gamemode-null")));
						return true;
					}
				}
				
				if (args.length == 1) { //no gamemode args
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.gamemode-no-args")));
					return true;
				}
				
				if (args[0].equalsIgnoreCase("0")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival")));
					p.setGameMode(GameMode.SURVIVAL);
					return true;
				}
				if (args[0].equalsIgnoreCase("1")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.creative")));
					p.setGameMode(GameMode.CREATIVE);
					return true;
				}
				if (args[0].equalsIgnoreCase("2")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.adventure")));
					p.setGameMode(GameMode.ADVENTURE);
					return true;
				}
				if (args[0].equalsIgnoreCase("3")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.spectator")));
					p.setGameMode(GameMode.SPECTATOR);
					return true;
				}
				
				//Calling Me NAMES???
				
				if (args[0].equalsIgnoreCase("survival")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival")));
					p.setGameMode(GameMode.SURVIVAL);
					return true;
				}
				if (args[0].equalsIgnoreCase("creative")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.creative")));
					p.setGameMode(GameMode.CREATIVE);
					return true;
				}
				if (args[0].equalsIgnoreCase("adventure")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.adventure")));
					p.setGameMode(GameMode.ADVENTURE);
					return true;
				}
				if (args[0].equalsIgnoreCase("spectator")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.spectator")));
					p.setGameMode(GameMode.SPECTATOR);
					return true;
				}
				
				//Nickname is more Forgivable
				
				if (args[0].equalsIgnoreCase("s")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.survival")));
					p.setGameMode(GameMode.SURVIVAL);
					return true;
				}
				if (args[0].equalsIgnoreCase("c")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.creative")));
					p.setGameMode(GameMode.CREATIVE);
					return true;
				}
				if (args[0].equalsIgnoreCase("a")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.adventure")));
					p.setGameMode(GameMode.ADVENTURE);
					return true;
				}
				if (args[0].equalsIgnoreCase("sp")) {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.spectator")));
					p.setGameMode(GameMode.SPECTATOR);
					return true;
				} else {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix") + " " + plugin.getConfig().getString("Gamemode-Command.gamemode-null")));
					return true;
				}
				
			}
				}		
				
				}
			
		return true;

	}
}
