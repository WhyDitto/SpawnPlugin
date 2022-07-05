package ditto.spawn.Commands;

import ditto.spawn.Utils.ChatUtil;
import ditto.spawn.Utils.DataUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor {

    public Location spawn;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 0) {
                if (DataUtil.getConfig().contains("Spawn")) { //Checks if spawn is set
                    World world = Bukkit.getWorld(DataUtil.getConfig().getString("Spawn.world"));
                    double x = DataUtil.getConfig().getDouble("Spawn.x");
                    double y = DataUtil.getConfig().getDouble("Spawn.y");
                    double z = DataUtil.getConfig().getDouble("Spawn.z");
                    spawn = new Location(world, x, y, z); //Creates a new location to teleport player too
                    player.sendMessage(ChatUtil.colorize("&aTeleporting you to spawn..."));
                    player.teleport(spawn);
                } else if (!DataUtil.getConfig().contains("Spawn")) {
                    player.sendMessage(ChatUtil.colorize("&4Use </spawn set> to set your spawn!"));
                }
            }else if(args.length > 0){
                if(args[0].equalsIgnoreCase("set")){
                    Location loc = player.getLocation();
                    DataUtil.getConfig().set("Spawn.world", loc.getWorld().getName());
                    DataUtil.getConfig().set("Spawn.x", loc.getX());
                    DataUtil.getConfig().set("Spawn.y", loc.getY());
                    DataUtil.getConfig().set("Spawn.z", loc.getZ());
                    DataUtil.saveConfig();
                    player.sendMessage(ChatUtil.colorize("&aYou have set your spawn!"));
                }else if(args[0].equalsIgnoreCase("delete")){
                    DataUtil.getConfig().set("Spawn", null);
                    DataUtil.saveConfig();
                    player.sendMessage(ChatUtil.colorize("&aYou have successfully deleted your spawn!"));
                }
            }
        }
        return true;
    }
}
