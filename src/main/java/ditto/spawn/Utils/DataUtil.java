package ditto.spawn.Utils;

import ditto.spawn.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataUtil {

    private static File file;
    private static FileConfiguration config;




    public void setup(){
        try{
            Main.getInstance().getDataFolder().mkdir();
            file = new File(Main.getInstance().getDataFolder(), "config.yml");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        config = YamlConfiguration.loadConfiguration(file);
    }
    public static FileConfiguration getConfig(){
        return config;
    }
    public static void saveConfig(){
        try {
            config.save(file);
        }catch(IOException e){
            System.out.println("Config could not be saved");
            e.printStackTrace();
        }
    }
}
