package test.scheduling;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {

    private final long eventInterval = 2400;

    @Override
    public void onEnable() {
        // when the server starts...

        // create a task which writes "second" into the chat
        new BukkitRunnable() {
            @Override
            public void run() {
                getServer().broadcastMessage("second");
            }
        }.runTaskTimer(this, 0, 20); // run it every 20 ticks

        // register the events described in Events.java
        getServer().getPluginManager().registerEvents(new Events(), this);

        // register the command described in CommandLightning.java
        this.getCommand("lightning").setExecutor(new CommandLightning());
    }

    @Override
    public void onDisable() {

    }
}
