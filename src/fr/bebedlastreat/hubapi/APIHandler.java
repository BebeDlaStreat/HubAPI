package fr.bebedlastreat.hubapi;

import fr.bebedlastreat.hubapi.commands.HubAPICommand;
import fr.bebedlastreat.hubapi.events.CancelListener;
import fr.bebedlastreat.hubapi.utils.ScoreboardSign;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.*;

public class APIHandler extends JavaPlugin {

    public Map<Player, ScoreboardSign> boards = new HashMap<>();
    public static APIHandler instance;
    public List<Player> cancelDamage = new ArrayList<>();
    public List<Player> cancelAttack = new ArrayList<>();
    public List<Player> cancelPlace = new ArrayList<>();
    public List<Player> cancelBreak = new ArrayList<>();
    public List<Player> cancelDrop = new ArrayList<>();
    public List<Player> cancelPickup = new ArrayList<>();
    public List<Player> cancelInventory = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        ConfigRegister();

        Bukkit.getPluginManager().registerEvents(new CancelListener(), this);

        getCommand("hubapi").setExecutor(new HubAPICommand());

        getServer().getConsoleSender().sendMessage(
                "§b[HubAPI] This is an API use it in code and not as a classic plugin");


        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static APIHandler getInstance() {
        return instance;
    }

    public void ConfigRegister()
    {
        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists())
        {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
    }
}
