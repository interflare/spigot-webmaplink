# webmaplink
SpigotMC plugin to get a clickable link in the players' chat to a dynmap instance based on where the player is (world name and x/y/z coords).

[Download the plugin &raquo;](https://github.com/interflare/webmaplink/releases)

## Usage Example

### Entering the command...
![Example of in-game usage](https://raw.githubusercontent.com/interflare/webmaplink/eacbcba8b354b482e3f21351190e036efc437c52/assets/img/chatexample.png)

### ...Gives a link to
![Example of the link result](https://raw.githubusercontent.com/interflare/webmaplink/1f97821f900abb4aae25e7537543e31f1efc2e9b/assets/img/linkresult.png)

## Configuraion
Not a lot to configure really. Generates a config.yml on first run, whic allows you to set a url format.

The url format variables (the `%s` and `%d` symbols) must remain in order. Other than that, you can change the default maptype for dynmap (`mapname=surface`, must be available on every world, or it will use the default), the zoom level, and of course the domain and port.

### Default config.yml
```yml
configVersion: 1.0
urlFormat: http://dynmap.myserver.com:8123/?mapname=surface&zoom=8&worldname=%s&x=%d&y=%d&z=%d
```
