package dtnl.pokemon.events;

import dtnl.pokemon.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class PokemonTargetEvent implements Listener {
    @EventHandler
    public void onEntityClick(EntityTargetEvent e){
        if(e.getEntity() instanceof Wolf){
            if(Main.Pokemons.values().contains(e.getEntity())){
                e.setCancelled(true);
            }
        }
    }
}
