package dtnl.pokemon.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class DataManager {
    public static YamlFile getpokemonfile(Player player, String id){
        return new YamlFile(Bukkit.getServer().getPluginManager().getPlugin("Pokemon").getDataFolder() +"/"+player.getUniqueId()+"/"+id+".yml");
    }
    public static void Addpokemon(Player player, int pokemon_id,int level, int HP_IV, int Attack_IV, int Defense_IV, int Special_IV,int Speed_IV){
        YamlFile yml = getpokemonfile(player, UUID.randomUUID().toString());
        try {
            if(!yml.exists()){
                yml.createNewFile();
                Bukkit.getServer().getConsoleSender().sendMessage("Added pokemon to" + player.getName());
            }else{
                Bukkit.getServer().getConsoleSender().sendMessage("ERROR?!");
            }
            yml.load();
        } catch (Exception ignored) {}
        yml.set("pokemon.id", pokemon_id);
        yml.set("pokemon.level", level);
        yml.set("stats.iv.hp", HP_IV);
        yml.set("stats.iv.defence", Defense_IV);
        yml.set("stats.iv.attack", Attack_IV);
        yml.set("stats.iv.defence", Defense_IV);
        yml.set("stats.iv.special", Special_IV);
        yml.set("stats.iv.speed", Speed_IV);
        try {
            yml.save();
        } catch (Exception ignored) {}
    }

    public static ArrayList<String> getpokemons(Player player){
        String path = Bukkit.getServer().getPluginManager().getPlugin("Pokemon").getDataFolder() + "/" + player.getUniqueId() + "/";
        File dir = new File(path);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            ArrayList<String> pokemons = new ArrayList<String>();
            for (File child : directoryListing) {
                pokemons.add(child.getName());
            }
            return pokemons;
        }
        return null;
    }

    public static Object getvalue(Player player, String uuid, String setting){
        YamlFile yml = getpokemonfile(player, uuid);
        try {
            if (!yml.exists()) {
                return false;
            }else {
                yml.load();
                if(yml.isSet(setting)) {
                    return yml.get(setting);
                }
            }
        } catch (Exception ignored) {}
        return false;
    }
}
