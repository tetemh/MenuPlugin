package fr.tetemh.menuplugin.runnable;

import fr.tetemh.menuplugin.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerProfile implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        register(player.getName());
        TimePlayed.online.add(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        register(player.getName());
        TimePlayed.online.remove(player);
    }

    public void register(String playerName) {
        Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".seconds", 0);
        Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".minutes", 0);
        Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".hours", 0);
        Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".days", 0);
        Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".months", 0);
        Main.getInstance().saveConfig();
        Main.getInstance().reloadConfig();
    }

    public static void addSecond(Player player, int time){
        String playerName = player.getName();
        int actualTime = Main.getInstance().getConfig().getInt("PlayerTimes." + playerName + ".seconds");
        Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".seconds", actualTime + time);
        Main.getInstance().saveConfig();
        Main.getInstance().reloadConfig();
    }

    public static void addMinute(Player player, int time){
        String playerName = player.getName();
        int actualTime = Main.getInstance().getConfig().getInt("PlayerTimes." + playerName + ".minutes");
        Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".minutes", actualTime + time);
        Main.getInstance().saveConfig();
        Main.getInstance().reloadConfig();
    }

    public static void addHour(Player player, int time){
        String playerName = player.getName();
        int actualTime = Main.getInstance().getConfig().getInt("PlayerTimes." + playerName + ".hours");
        Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".hours", actualTime + time);
        Main.getInstance().saveConfig();
        Main.getInstance().reloadConfig();
    }

    public static void addDay(Player player, int time){
        String playerName = player.getName();
        int actualTime = Main.getInstance().getConfig().getInt("PlayerTimes." + playerName + ".days");
        Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".days", actualTime + time);
        Main.getInstance().saveConfig();
        Main.getInstance().reloadConfig();
    }

    public static void addMonth(Player player, int time){
        String playerName = player.getName();
        int actualTime = Main.getInstance().getConfig().getInt("PlayerTimes." + playerName + ".months");
        Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".months", actualTime + time);
        Main.getInstance().saveConfig();
        Main.getInstance().reloadConfig();
    }

}
