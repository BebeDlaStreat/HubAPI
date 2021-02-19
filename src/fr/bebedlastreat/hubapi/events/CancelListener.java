package fr.bebedlastreat.hubapi.events;

import fr.bebedlastreat.hubapi.APIHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class CancelListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();
        if(getInstance().cancelDamage.contains(player)) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        Player player = (Player) e.getDamager();
        if(getInstance().cancelDamage.contains(player)) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if(getInstance().cancelDamage.contains(player)) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if(getInstance().cancelDamage.contains(player)) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        if(getInstance().cancelDamage.contains(player)) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();
        if(getInstance().cancelDamage.contains(player)) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void InvetoryClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        Player player = (Player) e.getWhoClicked();
        if (getInstance().cancelInventory.contains(player)) {
            e.setCancelled(true);
        }
    }

    public static APIHandler getInstance() {
        return APIHandler.getInstance();
    }

}
