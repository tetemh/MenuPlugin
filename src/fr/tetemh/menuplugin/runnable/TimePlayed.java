package fr.tetemh.menuplugin.runnable;

import fr.tetemh.menuplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public class TimePlayed implements Runnable {
    Player player;
    String playerName;
    BukkitTask task;
    public static ArrayList<Player> online = new ArrayList<>();

    public TimePlayed(Player player) {
        this.player = player;
        this.playerName = player.getName();
        this.task = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), this, 0, 20);
    }

    @Override
    public void run() {
        if (online.contains(player)) {

            PlayerProfile.addSecond(player, 1);

            if (Main.getInstance().getConfig().getInt("PlayerTimes." + playerName + ".seconds") == 60) {
                Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".seconds", 0);
                PlayerProfile.addMinute(player, 1);
            }
            if(Main.getInstance().getConfig().getInt("PlayerTimes." + playerName + ".minutes") == 60) {
                Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".minutes", 0);
                PlayerProfile.addHour(player, 1);
            }
            if(Main.getInstance().getConfig().getInt("PlayerTimes." + playerName + ".hours") == 24) {
                Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".hours", 0);
                PlayerProfile.addDay(player, 1);
            }
            if(Main.getInstance().getConfig().getInt("PlayerTimes." + playerName + ".days") == 30) {
                Main.getInstance().getConfig().set("PlayerTimes." + playerName + ".days", 0);
                PlayerProfile.addMonth(player, 1);
            }
        }else{
            task.cancel();
        }
    }
}
