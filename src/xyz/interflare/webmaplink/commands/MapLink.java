package xyz.interflare.webmaplink.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MapLink implements CommandExecutor {
    private String _urlFormat;
    
    public MapLink(String urlFormat) {
        _urlFormat = urlFormat;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    if (sender instanceof Player) {
	        Player p = (Player) sender;
	        Location l = p.getLocation();
	        
		    sender.sendMessage(String.format(
		            ChatColor.GREEN + "Here's your link: " +
		            ChatColor.GRAY + _urlFormat,
		            
		            l.getWorld().getName(),
		            l.getBlockX(), l.getBlockY(), l.getBlockZ()));
	    }
    		
	    return true;
	}
}
