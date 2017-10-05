package test.scheduling;

import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class Events implements Listener {

    private final int num_players = 4;

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        for (Player player : e.getEntity().getServer().getOnlinePlayers().toArray(new Player[0])) {
            e.getEntity().getServer().broadcastMessage("loggy: "+player.getName());
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier("Team's Spirits", -(20/num_players), AttributeModifier.Operation.ADD_NUMBER));
        }
    }

    @EventHandler
    public void onGameModeChange(PlayerGameModeChangeEvent e) {
        if (e.getNewGameMode() == GameMode.SPECTATOR) {
            AttributeInstance max_health = e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH);
            for (AttributeModifier mod : max_health.getModifiers().toArray(new AttributeModifier[0])) {
                max_health.removeModifier(mod);
            }
        }

    }
}
