package xyz.interflare.webmaplink.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MapLink implements CommandExecutor {
    private String _urlFormat;
    private String _urlHost;
    
    public MapLink(String urlFormat, String urlHost) {
        _urlFormat = urlFormat;
        _urlHost = urlHost;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Location l = p.getLocation();
            
            String msg = "Click to open the web map!";
            String link = String.format(_urlFormat,
                    l.getWorld().getName(),
                l.getBlockX(), l.getBlockY(), l.getBlockZ());
            String rawMsg = String.format("{\"text\":\"[\",\"color\":\"dark_gray\",\"extra\":"
                        + "[{\"text\":\"MapLink\",\"color\":\"aqua\",\"bold\":true},"
                        + "{\"text\":\"] \",\"color\":\"dark_gray\"},"
                        + "{\"text\":\"%s\",\"color\":\"gray\"}],"
                    + "\"clickEvent\":{\"action\":\"open_url\",\"value\":\"%s\"},"
                    + "\"hoverEvent\":{\"action\":\"show_text\",\"value\":"
                        + "[\"\",{\"text\":\"Open Web Map\n\",\"color\":\"aqua\",\"bold\":true},"
                            + "\"Click to browse to: %s\"]}}", msg, link, _urlHost);
            
           Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                String.format("tellraw %s %s", p.getDisplayName(), rawMsg));
        }
        
        return true;
    }
}
