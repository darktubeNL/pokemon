package dtnl.pokemon;

import dtnl.pokemon.commands.GiveCMD;
import dtnl.pokemon.commands.testcalc;
import dtnl.pokemon.events.PokeballHitEvent;
import dtnl.pokemon.events.InteractPokemonEvent;
import dtnl.pokemon.events.PokeballthrowEvent;
import dtnl.pokemon.events.PokemonTargetEvent;
import dtnl.pokemon.manager.EntityLoop;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Wolf;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin {

    public static Plugin pl;

    public static Map<UUID, Wolf> Pokemons = new HashMap<>();
    @Override
    public void onEnable() {
        pl = this;
        getServer().getPluginManager().registerEvents( new PokeballthrowEvent(), this);
        getServer().getPluginManager().registerEvents( new PokeballHitEvent(), this);
        getServer().getPluginManager().registerEvents( new InteractPokemonEvent(), this);
        getServer().getPluginManager().registerEvents( new PokemonTargetEvent(), this);
        EntityLoop.startloop();


        getCommand("getpokeball").setExecutor((CommandExecutor) new GiveCMD());
        getCommand("testcalc").setExecutor((CommandExecutor) new testcalc());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
