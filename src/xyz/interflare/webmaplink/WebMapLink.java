package xyz.interflare.webmaplink;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.interflare.webmaplink.commands.MapLink;

/**
 * @author InterFlare
 * @version 1.1
 */
public class WebMapLink extends JavaPlugin {
    private final Logger _logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
            URL url;
            
        // Register configuration
        FileConfiguration config = getConfig();
        config.addDefault("configVersion", 1.1);
        config.addDefault("urlFormat", "http://dynmap.myserver.com:8123/?mapname=surface&zoom=8&worldname=%s&x=%d&y=%d&z=%d");
        config.options().copyDefaults(true);
        saveConfig();
        
        if (config.getDouble("configVersion") != 1.1) {
            _logger.info("[MapLink] Version mismatch between config and plugin, consider re-generating the file.");
        }
        
        // Register commands
        try {
            url = new URL(config.getString("urlFormat"));
            
            // Only register this command if the URL is valid
            getCommand("maplink").setExecutor(new MapLink(config.getString("urlFormat"), url.getHost()));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
    @Override
    public void onDisable() {
        
    }
}
