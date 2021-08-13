package fr.tetemh.menuplugin.commands;

import fr.tetemh.menuplugin.Main;
import fr.tetemh.menuplugin.gui.GuiInfoPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandMenu implements CommandExecutor {

    private static Main main;
    private static Player player;
    public static Player playerTarget;




    private Inventory inventory;

    public CommandMenu(Main main) { CommandMenu.main = main;}

    public static void updateInv(Player player, Inventory inventory) {
        player.closeInventory();
        player.openInventory(inventory);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            if(args.length == 1) {
                player = (Player) sender;

                String playerName = args[0];
                playerTarget = sender.getServer().getPlayer(playerName);

                new GuiInfoPlayer().openInventory(player, playerTarget);

            }else {
                sender.sendMessage("§c/info < Player >");
            }
        }

        return false;
    }
}
