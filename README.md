# HubAPI
#### It's a simple API for Minecraft (spigot) to simplify some actions in a Hub plugin (like the scoreboard)
> If you want to propose a suggestion create a new issue with **Suggestion** in the title

For use it in your project, import the jar librairy (Maven come later)

##### TodoList :
- [x] Create simple action for the API
- [x] Create the github's repositories
- [x] Add somes protect action which can be enable or not with the api
- [ ] Publish the first release
- [ ] Waiting for proposals for more functionality

# Example:
## Scoreboard
##### Initialize Scoreboard
```Java
@EventHandler
public void onJoin(PlayerJoinEvent event) {
    HubAPI.initializeScoreboardPlayer(event.getPlayer(), "Scoreboard's Name", Arrays.asList("line 1", "line2", "line 3..."));
}
```
##### Change Scoreboard's Line
```Java
//The first line is the line 0
HubAPI.setScoreboardLine(player, 0, "This is the first line");
```
##### Remove Scoreboard's Line
```Java
HubAPI.removeScoreboardLine(player, 0);
```
##### Destroy scoreboard for a player
```Java
@EventHandler
public void onQuit(PlayerQuitEvent event) {
    HubAPI.destroyScoreboard(event.getPlayer());
}
```
## Cancel Event
##### Cancel one event
```Java
HubApi.cancelDamage/cancelAttack/cancelPlace/cancelBreak/cancelDrop/cancelPickup/cancelInventoryClick(player, true);
//true enable cancel and false disable (default -> false)
```
##### Cancel All Event
```Java
HubAPI.CancelALL(player, true);
```
## Hub Spawn
##### Set Hub Spawn Location
```Java
HubAPI.setSpawn(location);
```
##### Get Hub Spawn Location
```Java
HubAPI.getSpawn(); //if the spawn has been never set, it will return the spawn location of the first world he find
```
##### Set Cooldown
```Java
HubaAPI.setHubCooldown(int); // in tick
```
##### Get Cooldown
```Java
HubaAPI.getHubCooldown(); if the cooldown has been never set, it will return 0
```
##### Teleport Usin Cooldown And Hub Location
```Java
HubAPI.teleportToSpawn(player);
```
## What you can do when a player join
```Java
@EventHandler
public void onJoin(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    HubAPI.initializeScoreboardPlayer(player, "Hub", Arrays.asList("Online:", "Rank:", "Money:", "ip: www.example.com"));
    HubAPI.resetPlayer(player, GameMode.SURVIVAL);
    HubAPI.cancelAll(player, true);
    player.teleport(HubAPI.getSpawn());
}
```
