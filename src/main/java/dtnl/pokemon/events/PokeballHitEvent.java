package dtnl.pokemon.events;

import dtnl.pokemon.Main;
import dtnl.pokemon.manager.PokemonEntity;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class PokeballHitEvent implements Listener {
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntity().getType() == EntityType.SNOWBALL) {
            e.setCancelled(true);
            Snowball snowball = (Snowball) e.getEntity();
            String id = snowball.getCustomName();
            Player player = (Player) e.getEntity().getShooter();
            if(Main.Pokemons.get(player.getUniqueId()) == null) {
                PokemonEntity.Spawnpokemon(id, snowball.getLocation(), player);
            }else{
                PokemonEntity.despawnpokemon(player);
                PokemonEntity.Spawnpokemon(id, snowball.getLocation(), player);
            }
        }
    }
}
