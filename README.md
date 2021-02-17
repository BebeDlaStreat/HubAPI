# HubAPI
#### It's a simple API for Minecraft (spigot) to simplify some actions in a Hub plugin (like the scoreboard)

For use it in your project, import the jar librairy (Maven come later)

# Example:
##### Set Scoreboard
```Java
@EventHandler
public void onJoin(PlayerJoinEvent event) {
    HubAPI.initializeScoreboardPlayer(event.getPlayer(), "Scoreboard's Name", Arrays.asList("line 1", "line2", "line 3..."));
}
```
