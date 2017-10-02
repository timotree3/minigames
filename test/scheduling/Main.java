package test.scheduling;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {

    private final long eventInterval = 2400;

    @Override
    public void onEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                getServer().broadcastMessage("second");
            }
        }.runTaskTimer(this, 0, 20);
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {

    }
}
