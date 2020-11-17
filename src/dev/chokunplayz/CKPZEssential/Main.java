package me.chokunplayz.CKPZEssential;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.chokunplayz.CKPZEssential.Commands.About;
import me.chokunplayz.CKPZEssential.Commands.BoardcastCommand;
import me.chokunplayz.CKPZEssential.Commands.FeedCommand;
import me.chokunplayz.CKPZEssential.Commands.FlyCommand;
import me.chokunplayz.CKPZEssential.Commands.HealCommand;
import me.chokunplayz.CKPZEssential.Commands.Gamemode.Gamemode;
import me.chokunplayz.CKPZEssential.Commands.Gamemode.Gma;
import me.chokunplayz.CKPZEssential.Commands.Gamemode.Gmc;
import me.chokunplayz.CKPZEssential.Commands.Gamemode.Gms;
import me.chokunplayz.CKPZEssential.Commands.Gamemode.Gmsp;
import me.chokunplayz.CKPZEssential.utils.Utils;

public class Main extends JavaPlugin{
	
	public static Main plugin;

	@Override
	public void onEnable() {
		//VersionCheck();
		LoadAssest();
		Bukkit.getServer().getLogger().info(Utils.chat(ChatColor.AQUA + "Starting CKPZ Essential " + plugin.getConfig().getString("Version")));
		Bukkit.getServer().getLogger().info(Utils.chat(""));
		LoadConfig();
		Bukkit.getServer().getLogger().info(Utils.chat(""));
		Bukkit.getServer().getLogger().info(Utils.chat(""));
		LoadCommands();
		System.out.println("Command Loaded !");
		System.out.println("");
		Bukkit.getServer().getLogger().info(Utils.chat(plugin.getConfig().getString("Startup-Message")));
	}
	
	@Override
	public void onDisable() {
		this.saveDefaultConfig();
	}
	
	public void LoadConfig() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}
	
	public void LoadCommands() {
		//About/unnessary
		getCommand("ckpzessential").setExecutor(new About(this));
		//Essentials Command
		getCommand("fly").setExecutor(new FlyCommand(this));
		getCommand("heal").setExecutor(new HealCommand(this));
		getCommand("feed").setExecutor(new FeedCommand(this));
		getCommand("brc").setExecutor(new BoardcastCommand(this));
		//Gamemodes
		getCommand("gamemode").setExecutor(new Gamemode(this));
		getCommand("gmc").setExecutor(new Gmc(this));
		getCommand("gms").setExecutor(new Gms(this));
		getCommand("gma").setExecutor(new Gma(this));
		getCommand("gmsp").setExecutor(new Gmsp(this));
	}
	
	@SuppressWarnings("unused")
	public void LoadAssest() {
		plugin = this;
		FileConfiguration config = Main.plugin.getConfig();
	}
	
	public void VersionCheck() {
		Bukkit.getServer().getLogger().info("Checking Version");
		if (!(plugin.getConfig().getString("version") == "B.1.7.2")) {
			Bukkit.getServer().getLogger().info("Plugin Version Check Failed");
			Bukkit.getServer().getLogger().info("Shuting Down...");
			Bukkit.getPluginManager().disablePlugin(this);
		}
	}

}