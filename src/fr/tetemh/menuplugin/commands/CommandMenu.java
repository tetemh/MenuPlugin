package fr.tetemh.menuplugin.commands;

import fr.tetemh.menuplugin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class CommandMenu implements CommandExecutor {
    public static String playerName;

    private static double walkCount;
    private static int stoneMined;
    private static int a;
    private static String sufix;

    private static int coalMined;
    private static int ironMined;
    private static int goldMined;
    private static int lapisMined;
    private static int redstoneMined;
    private static int emeraldMined;
    private static int diamondMined;
    private static int quartzMined;

    ItemBuilder glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1).setName(" ");


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {

                playerName = sender.getName();
                Inventory inventory = Bukkit.createInventory(null, 5 * 9, "§e§lInfo Player de " + playerName);
                ItemBuilder walk = new ItemBuilder(Material.GRASS, 1).setName("Walk").setLore("vous avez marcher : " + walkCount + "m");
                ItemBuilder stone = new ItemBuilder(Material.STONE, 1).setName("Stone Mined -> " + stoneMined);
                ItemBuilder head = new ItemBuilder(Material.SKULL_ITEM, 1, 3).setName("§eProfil de " + playerName).addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

                for (int i = 0; i < inventory.getSize(); i++) {
                    inventory.setItem(i, glass.build());
                }

                inventory.setItem(4, head.setSkullOwningPlayer(player).build());
                walkCount = player.getStatistic(Statistic.WALK_ONE_CM);
                walkCount = walkCount / 100;
                inventory.setItem(13, walk.build());

                stoneMined = player.getStatistic(Statistic.MINE_BLOCK, Material.STONE);

                coalMined = player.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE);
                ironMined = player.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE);
                goldMined = player.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE);
                lapisMined = player.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE);
                redstoneMined = player.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE);
                emeraldMined = player.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE);
                diamondMined = player.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
                quartzMined = player.getStatistic(Statistic.MINE_BLOCK, Material.QUARTZ_ORE);

                ItemBuilder coal = new ItemBuilder(Material.COAL_ORE).setName("Coal mined -> " + coalMined);
                ItemBuilder iron = new ItemBuilder(Material.IRON_ORE).setName("Iron mined -> " + ironMined);
                ItemBuilder gold = new ItemBuilder(Material.GOLD_ORE).setName("Gold mined -> " + goldMined);
                ItemBuilder lapis = new ItemBuilder(Material.LAPIS_ORE).setName("Lapis mined -> " + lapisMined);
                ItemBuilder redstone = new ItemBuilder(Material.REDSTONE_ORE).setName("Redstone mined -> " + redstoneMined);
                ItemBuilder emerald = new ItemBuilder(Material.EMERALD_ORE).setName("Emerald mined -> " + emeraldMined);
                ItemBuilder diamond = new ItemBuilder(Material.DIAMOND_ORE).setName("Diamond mined -> " + diamondMined);
                ItemBuilder quartz = new ItemBuilder(Material.QUARTZ_ORE).setName("Quartz mined -> " + quartzMined);

                inventory.setItem(18, coal.build());
                inventory.setItem(19, iron.build());
                inventory.setItem(20, gold.build());
                inventory.setItem(21, lapis.build());
                inventory.setItem(22, stone.build());
                inventory.setItem(23, redstone.build());
                inventory.setItem(24, emerald.build());
                inventory.setItem(25, diamond.build());
                inventory.setItem(26, quartz.build());

                player.openInventory(inventory);
            } else if (args.length == 1) {
                String playertarget = args[0];
                Player player1 = sender.getServer().getPlayer(playertarget);
                playerName = args[0];

                Inventory inventory = Bukkit.createInventory(null, 5 * 9, "§e§lInfo Player de " + playerName);
                ItemBuilder walk = new ItemBuilder(Material.GRASS, 1).setName("Walk").setLore("vous avez marcher : " + walkCount + "m");
                ItemBuilder stone = new ItemBuilder(Material.STONE, 1).setName("Stone Mined -> " + stoneMined);
                ItemBuilder head = new ItemBuilder(Material.SKULL_ITEM, 1, 3).setName("§eProfil de " + playerName).addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

                for (int i = 0; i < inventory.getSize(); i++) {
                    inventory.setItem(i, glass.build());
                }

                inventory.setItem(4, head.setSkullOwningPlayer(player1).build());
                walkCount = player1.getStatistic(Statistic.WALK_ONE_CM);
                walkCount = walkCount / 100;
                inventory.setItem(13, walk.build());

                stoneMined = player1.getStatistic(Statistic.MINE_BLOCK, Material.STONE);

                coalMined = player1.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE);
                ironMined = player1.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE);
                goldMined = player1.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE);
                lapisMined = player1.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE);
                redstoneMined = player1.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE);
                emeraldMined = player1.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE);
                diamondMined = player1.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
                quartzMined = player1.getStatistic(Statistic.MINE_BLOCK, Material.QUARTZ_ORE);

                ItemBuilder coal = new ItemBuilder(Material.COAL_ORE).setName("Coal mined -> " + coalMined);
                ItemBuilder iron = new ItemBuilder(Material.IRON_ORE).setName("Iron mined -> " + ironMined);
                ItemBuilder gold = new ItemBuilder(Material.GOLD_ORE).setName("Gold mined -> " + goldMined);
                ItemBuilder lapis = new ItemBuilder(Material.LAPIS_ORE).setName("Lapis mined -> " + lapisMined);
                ItemBuilder redstone = new ItemBuilder(Material.REDSTONE_ORE).setName("Redstone mined -> " + redstoneMined);
                ItemBuilder emerald = new ItemBuilder(Material.EMERALD_ORE).setName("Emerald mined -> " + emeraldMined);
                ItemBuilder diamond = new ItemBuilder(Material.DIAMOND_ORE).setName("Diamond mined -> " + diamondMined);
                ItemBuilder quartz = new ItemBuilder(Material.QUARTZ_ORE).setName("Quartz mined -> " + quartzMined);

                inventory.setItem(18, coal.build());
                inventory.setItem(19, iron.build());
                inventory.setItem(20, gold.build());
                inventory.setItem(21, lapis.build());
                inventory.setItem(22, stone.build());
                inventory.setItem(23, redstone.build());
                inventory.setItem(24, emerald.build());
                inventory.setItem(25, diamond.build());
                inventory.setItem(26, quartz.build());

                player.openInventory(inventory);


            } else {
                sender.sendMessage("§c/menu also /menu <Player>");
            }


        }


        return false;
    }
}
