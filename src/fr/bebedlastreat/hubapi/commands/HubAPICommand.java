package fr.bebedlastreat.hubapi.commands;

import fr.bebedlastreat.hubapi.APIHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HubAPICommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        //Please don't remove this command, this api is free and open source

        sender.sendMessage("§6§lHubAPI");
        sender.sendMessage("§eBy §lBebeDlaStreat");
        sender.sendMessage("§eVersion: " + APIHandler.getInstance().getDescription().getVersion());
        sender.sendMessage("§7https://github.com/BebeDlaStreat/HubAPI");
        return false;
    }
}
