package fr.tetemh.menuplugin;

import fr.tetemh.menuplugin.commands.CommandMenu;
import fr.tetemh.menuplugin.listeners.MListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MListener(), this);
        getCommand("menu").setExecutor(new CommandMenu());
    }
}
