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
        // when a player dies... (decrease everyone's max health)
        for (Player player : e.getEntity().getServer().getOnlinePlayers().toArray(new Player[0])) {
            // for each player on the server...
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier("Team's Spirits", -(20/num_players), AttributeModifier.Operation.ADD_NUMBER));
            // decrease their max health by (20/num_players = 5 half hearts = 2.5 hearts)
        }
    }

    @EventHandler
    public void onGameModeChange(PlayerGameModeChangeEvent e) {
        // when a player uses /gamemode...
        if (e.getNewGameMode() == GameMode.SPECTATOR) {
            // if they just became a spectator... (reset their max health)
            AttributeInstance max_health = e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH);
            // get access to their max health and then...
            for (AttributeModifier mod : max_health.getModifiers().toArray(new AttributeModifier[0])) {
                // for each modifier that's been applied to it...
                max_health.removeModifier(mod);
                // remove it
            }
        }

    }
}
