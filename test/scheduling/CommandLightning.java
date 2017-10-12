package test.scheduling;

import org.bukkit.Location;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

// define function for `/lightning` command
public class CommandLightning implements CommandExecutor {

    // helper function that strikes lightning at a given location
    public void Lightning(Location loc) {
        loc.getWorld().strikeLightning(loc);
    }

    // actual command function
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Entity) {
            // if user is an entity, since we can get it's location, strike lightning
            Lightning(((Entity) sender).getLocation());
            return true;
        } else if (sender instanceof BlockCommandSender) {
            // if user is an command block, since we can get it's location, strike lightning
            Lightning(((BlockCommandSender) sender).getBlock().getLocation());
            return true;
        }
        // return false meaning the command failed to execute.
        return false;
    }
}