package ditto.spawn.Commands;

import ditto.spawn.Utils.ChatUtil;
import ditto.spawn.Utils.DataUtil;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Location loc = player.getLocation();
            DataUtil.getConfig().set("Spawn.world", loc.getWorld().getName());
            DataUtil.getConfig().set("Spawn.x", loc.getX());
            DataUtil.getConfig().set("Spawn.y", loc.getY());
            DataUtil.getConfig().set("Spawn.z", loc.getZ());
            DataUtil.saveConfig();
            player.sendMessage(ChatUtil.colorize("&aYou have set your spawn!"));
        }
        return true;
    }
}
