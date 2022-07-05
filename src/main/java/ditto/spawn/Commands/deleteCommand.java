package ditto.spawn.Commands;

import ditto.spawn.Utils.ChatUtil;
import ditto.spawn.Utils.DataUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class deleteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
           Player player =  (Player) sender;
            DataUtil.getConfig().set("Spawn", null);
            DataUtil.saveConfig();
            player.sendMessage(ChatUtil.colorize("&aYou have successfully deleted your spawn!"));
        }
        return true;
    }
}
