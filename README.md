# HubAPI
#### It's a simple API for Minecraft (spigot) to simplify some actions in a Hub plugin (like the scoreboard)

For use it in your project, import the jar librairy (Maven come later)

# Example:
## Scoreboard
##### Initialize Scoreboard
```Java
@EventHandler
public void onJoin(PlayerJoinEvent event) {
    HubAPI.initializeScoreboardPlayer(event.getPlayer(), "Scoreboard's Name", Arrays.asList("line 1", "line2", "line 3..."));
}
```
##### Change Scoreboard Line
```Java
//The first line is the line 0
HubAPI.setScoreboardLine(player, 0, "This is the first line");
```
##### Destroy scoreboard for a player
```Java
@EventHandler
public void onJoin(PlayerQuitEvent event) {
    HubAPI.destroyScoreboard(event.getPlayer());
}
```
