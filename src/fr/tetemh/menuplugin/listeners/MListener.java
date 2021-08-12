package fr.tetemh.menuplugin.listeners;

import fr.tetemh.menuplugin.commands.CommandMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MListener implements Listener {
    @EventHandler
    public static void onClick(InventoryClickEvent event) {

        if(event.getInventory().getName().equals("§e§lInfo Player de " + CommandMenu.playerName)){
            event.setCancelled(true);
        }


    }
}
