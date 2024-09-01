package fr.preventmob.event;

import fr.preventmob.PreventMob;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.List;

public class SpawnListener implements Listener {

    private PreventMob plugin;

    public SpawnListener(PreventMob plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        EntityType type = event.getEntityType();
        List<String> disabledMobs = plugin.getConfig().getStringList("disabled-mobs");

        if (disabledMobs.contains(type.toString())) {
            event.setCancelled(true);
        }
    }

}
