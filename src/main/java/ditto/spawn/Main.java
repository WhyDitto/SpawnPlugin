package ditto.spawn;

import ditto.spawn.Utils.ChatUtil;
import ditto.spawn.Utils.DataUtil;
import ditto.spawn.commands.setSpawn;
import ditto.spawn.commands.spawnCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main main;
    DataUtil util = new DataUtil();

    @Override
    public void onEnable() {
        // Plugin startup logic
        main = this;
        util.setup();
        getServer().getConsoleSender().sendMessage(ChatUtil.colorize("&aSpawn plugin has started!"));
        getCommand("spawn").setExecutor(new spawnCommand());
        getCommand("setspawn").setExecutor(new setSpawn());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Main getInstance(){
        return main;
    }
}
