package fr.tetemh.menuplugin;

import fr.tetemh.menuplugin.commands.CommandMenu;
import fr.tetemh.menuplugin.listeners.MListener;
import fr.tetemh.menuplugin.runnable.PlayerProfile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new MListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerProfile(), this);
        getServer().getPluginManager().registerEvents(new VirtualGui(), this);
        getCommand("info").setExecutor(new CommandMenu(this));
    }

    public static Main getInstance(){
        return instance;
    }
}
