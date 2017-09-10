package xyz.interflare.webmaplink;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.interflare.webmaplink.commands.MapLink;

/**
 * @author mcro591@aucklanduni.ac.nz
 * @version 0.1
 */
public class WebMapLink extends JavaPlugin {
    private final Logger _logger = Logger.getLogger("Minecraft");
    
    @Override
    public void onEnable() {
        // Register configuration
        FileConfiguration config = getConfig();
        config.addDefault("configVersion", 0.1);
        config.addDefault("urlFormat", "http://dynmap.myserver.com:8123/?mapname=surface&zoom=8&worldname=%s&x=%d&y=%d&z=%d");
        config.options().copyDefaults(true);
        saveConfig();
        
        if (config.getDouble("configVersion") != 0.1) {
            _logger.info("[IFLR-WebMapLink] Version mismatch between config and plugin.");
        }
        
        // Register commands
        getCommand("maplink").setExecutor(new MapLink(config.getString("urlFormat")));
    }
    	
    @Override
    public void onDisable() {
        	
    }
}
