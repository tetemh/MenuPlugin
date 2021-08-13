package fr.tetemh.menuplugin.listeners;

import fr.tetemh.menuplugin.Main;
import fr.tetemh.menuplugin.VirtualGui;
import fr.tetemh.menuplugin.commands.CommandMenu;
import fr.tetemh.menuplugin.runnable.TimePlayed;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class MListener implements Listener {

    private static Main main;

    public MListener(Main main) { MListener.main = main; }

    public static HashMap<Player, Integer> coalMap = new HashMap<>();
    public static HashMap<Player, Integer> ironMap = new HashMap<>();
    public static HashMap<Player, Integer> redstoneMap = new HashMap<>();
    public static HashMap<Player, Integer> lapisMap = new HashMap<>();
    public static HashMap<Player, Integer> goldMap = new HashMap<>();
    public static HashMap<Player, Integer> diamondMap = new HashMap<>();
    public static HashMap<Player, Integer> emeraldMap = new HashMap<>();
    public static HashMap<Player, Integer> quartzMap = new HashMap<>();
    public static HashMap<Player, Integer> stoneMap = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        new TimePlayed(player);

        int coalState = player.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE);
        coalMap.put(player, coalState);

        int ironstate = player.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE);
        ironMap.put(player, ironstate);

        int redstoneState = player.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE);
        redstoneMap.put(player, redstoneState);

        int lapisState = player.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE);
        lapisMap.put(player, lapisState);

        int goldState = player.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE);
        goldMap.put(player, goldState);

        int diamondState = player.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
        diamondMap.put(player, diamondState);

        int emeraldState = player.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE);
        emeraldMap.put(player, emeraldState);

        int quartzState = player.getStatistic(Statistic.MINE_BLOCK, Material.QUARTZ_ORE);
        quartzMap.put(player, quartzState);

        int stoneState = player.getStatistic(Statistic.MINE_BLOCK, Material.STONE);
        stoneMap.put(player, stoneState);

    }



    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        coalMap.remove(player);
        ironMap.remove(player);
        redstoneMap.remove(player);
        lapisMap.remove(player);
        goldMap.remove(player);
        diamondMap.remove(player);
        emeraldMap.remove(player);
        quartzMap.remove(player);
        stoneMap.remove(player);
    }
}
