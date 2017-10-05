package test.scheduling;

import org.bukkit.Location;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

public class CommandLightning implements CommandExecutor {

    public void Lightning(Location loc) {
        loc.getWorld().strikeLightning(loc);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Entity) {
            Lightning(((Entity) sender).getLocation());
            return true;
        } else if (sender instanceof BlockCommandSender) {
            Lightning(((BlockCommandSender) sender).getBlock().getLocation());
            return true;
        }
        return false;
    }
}