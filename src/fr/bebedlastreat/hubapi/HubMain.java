package fr.bebedlastreat.hubapi;

import fr.bebedlastreat.hubapi.commands.HubCommand;
import fr.bebedlastreat.hubapi.utils.ScoreboardSign;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class HubMain extends JavaPlugin {

    public Map<Player, ScoreboardSign> boards = new HashMap<>();
    public static HubMain instance;

    @Override
    public void onEnable() {
        instance = this;
        ConfigRegister();
        getCommand("hub").setExecutor(new HubCommand());

        getServer().getConsoleSender().sendMessage(
                "§b[HubAPI] This is an API use it in code and not as a classic plugin");

        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static HubMain getInstance() {
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
