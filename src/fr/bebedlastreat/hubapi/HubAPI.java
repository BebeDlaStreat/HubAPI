package fr.bebedlastreat.hubapi;

import fr.bebedlastreat.hubapi.utils.ScoreboardSign;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HubAPI implements Listener {

//    @EventHandler
//    public void onJoin(PlayerQuitEvent event) {
//        Player player = event.getPlayer();
//        HubAPI.initializeScoreboardPlayer(player, "Hub", Arrays.asList("Online:", "Rank:", "Money:", "ip: www.example.com"));
//        HubAPI.resetPlayer(player, GameMode.SURVIVAL);
//        player.teleport(HubAPI.getSpawn());
//    }
    private static APIHandler handler = APIHandler.getInstance();
    
    public static File file = new File(handler.getDataFolder(), "data.yml");
    public static YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    public static void setHubCooldown(int tick) {
        configuration.set("cooldown", tick);
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage("§cCooldown's time could not be saved");
        }
    }
    public static int getHubCooldown() {
        if (configuration.get("cooldown") != null) {
            return configuration.getInt("cooldown");
        } else {
            return 0;
        }
    }

    public static void teleportToSpawn(Player player) {
        if (getHubCooldown() == 0) {
            player.teleport(getSpawn());
        } else {
            Bukkit.getScheduler().runTaskLater(handler, () -> {
                player.teleport(getSpawn());
            }, getHubCooldown());
        }
    }

    public static void setSpawn(Location loc) {
        configuration.set("spawn", loc);
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage("§Spawn's location could not be saved");
        }
    }
    public static Location getSpawn() {
        if (configuration.get("spawn") != null) {
            return (Location) configuration.get("spawn");
        } else {
            return Bukkit.getWorlds().get(0).getSpawnLocation();
        }
    }

    public static void resetPlayer(Player player, GameMode gameMode) {
        player.setFallDistance(0);
        player.setLevel(0);
        player.setExp(0);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setFireTicks(0);
        player.resetPlayerWeather();
        player.resetPlayerTime();
        player.setGameMode(gameMode);
        player.teleport(getSpawn());
    }

    public static void cancelAll(Player player, boolean cancel) {
        cancelDamage(player, cancel);
        cancelAttack(player, cancel);
        cancelPlace(player, cancel);
        cancelBreak(player, cancel);
        cancelDrop(player, cancel);
        cancelPickup(player, cancel);
        cancelInventoryClick(player, cancel);
    }

    public static void cancelDamage(Player player, boolean cancel) {
        if (cancel) {
            if (!handler.cancelDamage.contains(player)) {
                handler.cancelDamage.add(player);
            }
        } else {
            if (handler.cancelDamage.contains(player)) {
                handler.cancelDamage.remove(player);
            }
        }
    }
    public static void cancelAttack(Player player, boolean cancel) {
        if (cancel) {
            if (!handler.cancelAttack.contains(player)) {
                handler.cancelAttack.add(player);
            }
        } else {
            if (handler.cancelAttack.contains(player)) {
                handler.cancelAttack.remove(player);
            }
        }
    }
    public static void cancelPlace(Player player, boolean cancel) {
        if (cancel) {
            if (!handler.cancelPlace.contains(player)) {
                handler.cancelPlace.add(player);
            }
        } else {
            if (handler.cancelPlace.contains(player)) {
                handler.cancelPlace.remove(player);
            }
        }
    }
    public static void cancelBreak(Player player, boolean cancel) {
        if (cancel) {
            if (!handler.cancelBreak.contains(player)) {
                handler.cancelBreak.add(player);
            }
        } else {
            if (handler.cancelBreak.contains(player)) {
                handler.cancelBreak.remove(player);
            }
        }
    }
    public static void cancelDrop(Player player, boolean cancel) {
        if (cancel) {
            if (!handler.cancelDrop.contains(player)) {
                handler.cancelDrop.add(player);
            }
        } else {
            if (handler.cancelDrop.contains(player)) {
                handler.cancelDrop.remove(player);
            }
        }
    }
    public static void cancelPickup(Player player, boolean cancel) {
        if (cancel) {
            if (!handler.cancelPickup.contains(player)) {
                handler.cancelPickup.add(player);
            }
        } else {
            if (handler.cancelPickup.contains(player)) {
                handler.cancelPickup.remove(player);
            }
        }
    }
    public static void cancelInventoryClick(Player player, boolean cancel) {
        if (cancel) {
            if (!handler.cancelInventory.contains(player)) {
                handler.cancelInventory.add(player);
            }
        } else {
            if (handler.cancelInventory.contains(player)) {
                handler.cancelInventory.remove(player);
            }
        }
    }

    public static void initializeScoreboardPlayer(Player player, String name, List<String> lines) {
        ScoreboardSign scoreboardSign = new ScoreboardSign(player, name);
        scoreboardSign.create();
        int i = 0;
        for (String line : lines) {
            scoreboardSign.setLine(i, line);
        }

        handler.boards.put(player, scoreboardSign);
    }
    public static void setScoreboardLine(Player player, int number, String line) {
        if (handler.boards.containsKey(player)) {
            (handler.boards.get(player)).setLine(number, line);
        } else {
            System.out.println("§eThe player has not a register scoreboard");
        }
    }
    public static void removeScoreboardLine(Player player, int number) {
        if (handler.boards.containsKey(player)) {
            (handler.boards.get(player)).removeLine(number);
        } else {
            System.out.println("§eThe player has not a register scoreboard");
        }
    }
    public static void destroyScoreboard(Player player) {
        if (handler.boards.containsKey(player)) {
            (handler.boards.get(player)).destroy();
        } else {
            System.out.println("§eThe player has not a register scoreboard");
        }
    }
}
