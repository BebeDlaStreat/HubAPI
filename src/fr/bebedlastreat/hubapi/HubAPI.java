package fr.bebedlastreat.hubapi;

import fr.bebedlastreat.hubapi.utils.ScoreboardSign;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Arrays;
import java.util.List;

public class HubAPI implements Listener {

    @EventHandler
    public void onJoin(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        HubAPI.initializeScoreboardPlayer(player, "Hub", Arrays.asList("Online:", "Rank:", "Money:", "ip: www.example.com"));
        HubAPI.resetPlayer(player, GameMode.SURVIVAL);
        player.teleport(HubAPI.getSpawn());
    }

    public static int cooldown;
    public static Location location;

    public static void setHubCooldown(int tick) {
        cooldown = tick;
    }
    public static int getHubCooldown() {
        return cooldown;
    }

    public static void teleportToSpawn(Player player) {
        if (getHubCooldown() == 0) {
            player.teleport(getSpawn());
        } else {
            Bukkit.getScheduler().runTaskLater(HubMain.getInstance(), new Runnable() {
                @Override
                public void run() {
                    player.teleport(getSpawn());
                }
            }, getHubCooldown());
        }
    }

    public static void setSpawn(Location loc) {
        location = loc;
    }
    public static Location getSpawn() {
        return location;
    }

    public static void resetPlayer(Player player, GameMode gameMode) {
        player.setFallDistance(0);
        player.setLevel(0);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setPlayerWeather(WeatherType.CLEAR);
        player.setGameMode(gameMode);
    }





    public static void initializeScoreboardPlayer(Player player, String name, List<String> lines) {
        ScoreboardSign scoreboardSign = new ScoreboardSign(player, name);
        scoreboardSign.create();
        int i = 0;
        for (String line : lines) {
            scoreboardSign.setLine(i, line);
        }

        (HubMain.getInstance()).boards.put(player, scoreboardSign);
    }
    public static void setScoreboardLine(Player player, int number, String line) {
        if ((HubMain.getInstance()).boards.containsKey(player)) {
            ((ScoreboardSign)(HubMain.getInstance()).boards.get(player)).setLine(number, line);
        } else {
            System.out.println("§eThe player has not a register scoreboard");
        }
    }
    public static void destroyScoreboard(Player player) {
        if ((HubMain.getInstance()).boards.containsKey(player)) {
            ((ScoreboardSign)(HubMain.getInstance()).boards.get(player)).destroy();
        } else {
            System.out.println("§eThe player has not a register scoreboard");
        }
    }
}
