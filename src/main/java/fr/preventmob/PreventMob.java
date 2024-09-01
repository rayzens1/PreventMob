package fr.preventmob;

import fr.preventmob.event.SpawnListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class PreventMob extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();

        FileConfiguration config = getConfig();
        List<String> disabledMobs = config.getStringList("disabled-mobs");

        getLogger().info("Mobs désactivés : " + disabledMobs);

        getServer().getPluginManager().registerEvents(new SpawnListener(this), this);

    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("reloadconfig")) {
            reloadConfig();
            sender.sendMessage("Configuration rechargée !");
            return true;
        }
        return false;
    }
}
