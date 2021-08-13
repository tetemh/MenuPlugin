package fr.tetemh.menuplugin.gui;

import fr.tetemh.menuplugin.Main;
import fr.tetemh.menuplugin.commands.CommandMenu;
import fr.tetemh.menuplugin.listeners.MListener;
import fr.tetemh.menuplugin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiInfoPlayer implements Listener {

    private static int coalState;
    private static int ironState;
    private static int goldState;
    private static int redstoneState;
    private static int lapisState;
    private static int diamondState;
    private static int emeraldState;
    private static int quartzState;
    private static int stoneState;
    private static int timeStateSeconds;
    private static int timeStateMinutes;
    private static int timeStatehours;
    private static int timeStateDays;
    private static int timeStateMonths;
    private static double timeState;

    private static Inventory inventory;

    public void openInventory(Player player, Player playerTarget) {
        inventory = Bukkit.createInventory(null, 5 * 9, "§e§lInfo of " + playerTarget.getName());
        ItemBuilder head = new ItemBuilder(Material.SKULL_ITEM, 1, 3).setName("§e§l" + playerTarget.getName()).setLore("§eTime played : §l" + timeStatehours + "h " + timeStateMinutes + "min " + timeStateSeconds + "s").setSkullOwningPlayer(playerTarget);
        ItemBuilder glass = new ItemBuilder(Material.STAINED_GLASS_PANE).setName(" ");
        ItemBuilder reload = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 11).setName("§aReload");

        for(int i =0; i < inventory.getSize(); i++) {
            inventory.setItem(i, glass.build());
        }

        timeStateSeconds = Main.getInstance().getConfig().getInt("PlayerTimes." + playerTarget.getName() + ".seconds");
        timeStateMinutes = Main.getInstance().getConfig().getInt("PlayerTimes." + playerTarget.getName() + ".minutes");
        timeStatehours = Main.getInstance().getConfig().getInt("PlayerTimes." + playerTarget.getName() + ".hours");
        timeStateDays = Main.getInstance().getConfig().getInt("PlayerTimes." + playerTarget.getName() + ".days");
        timeStateMonths = Main.getInstance().getConfig().getInt("PlayerTimes." + playerTarget.getName() + ".months");



        coalState = playerTarget.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE) - MListener.coalMap.get(playerTarget);
        ItemBuilder coalOre = new ItemBuilder(Material.COAL_ORE).setName("§eCoal undermine : §l" + coalState);
        inventory.setItem(18, coalOre.build());

        ironState = playerTarget.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE) - MListener.ironMap.get(playerTarget);
        ItemBuilder ironOre = new ItemBuilder(Material.IRON_ORE).setName("§eIron undermine : §l" + ironState);
        inventory.setItem(19, ironOre.build());

        goldState = playerTarget.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE) - MListener.goldMap.get(playerTarget);
        ItemBuilder goldOre = new ItemBuilder(Material.GOLD_ORE).setName("§eGold undermine : §l" + goldState);
        inventory.setItem(20, goldOre.build());

        redstoneState = playerTarget.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE) - MListener.redstoneMap.get(playerTarget);
        ItemBuilder redstoneOre = new ItemBuilder(Material.REDSTONE_ORE).setName("§eRedstone undermine : §l" + redstoneState);
        inventory.setItem(21, redstoneOre.build());



        stoneState = playerTarget.getStatistic(Statistic.MINE_BLOCK, Material.STONE) - MListener.stoneMap.get(playerTarget);
        ItemBuilder stone = new ItemBuilder(Material.STONE).setName("§eStone undermine : §l" + stoneState);
        inventory.setItem(22, stone.build());



        lapisState = playerTarget.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE) - MListener.lapisMap.get(playerTarget);
        ItemBuilder lapisOre = new ItemBuilder(Material.LAPIS_ORE).setName("§eLapis undermine : §l" + lapisState);
        inventory.setItem(23, lapisOre.build());

        diamondState = playerTarget.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE) - MListener.diamondMap.get(playerTarget);
        ItemBuilder diamondOre = new ItemBuilder(Material.DIAMOND_ORE).setName("§eDiamond undermine : §l" + diamondState);
        inventory.setItem(24, diamondOre.build());

        emeraldState = playerTarget.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE) - MListener.emeraldMap.get(playerTarget);
        ItemBuilder emeraldOre = new ItemBuilder(Material.EMERALD_ORE).setName("§eEmerald undermine : §l" + emeraldState);
        inventory.setItem(25, emeraldOre.build());

        quartzState = playerTarget.getStatistic(Statistic.MINE_BLOCK, Material.QUARTZ_ORE) - MListener.quartzMap.get(playerTarget);
        ItemBuilder quartzOre = new ItemBuilder(Material.QUARTZ_ORE).setName("§eQuartz undermine : §l" + quartzState);
        inventory.setItem(26, quartzOre.build());



        inventory.setItem(4, head.setSkullOwner(playerTarget.getName()).build());
        inventory.setItem(inventory.getSize() - 1, reload.build());

        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getCurrentItem();
        Inventory inventory = event.getInventory();

        if (event.getClickedInventory().getName().equalsIgnoreCase("§e§lInfo of " + CommandMenu.playerTarget.getName()) ) {
            event.setCancelled(true);
        }

        if(itemStack.getType() == Material.STAINED_GLASS_PANE && itemStack.getItemMeta().getDisplayName().equals("§aReload")){
            new GuiInfoPlayer().openInventory(player, player.getServer().getPlayer(event.getInventory().getName().substring(12)));
        }
    }



}
