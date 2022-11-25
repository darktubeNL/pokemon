package dtnl.pokemon.events;

import dtnl.pokemon.Main;
import dtnl.pokemon.manager.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class InteractPokemonEvent implements Listener {
    @EventHandler
    public void onEntityClick(PlayerInteractEntityEvent e){
        if(e.getRightClicked() instanceof Wolf) {
            if (Main.Pokemons.values().contains(e.getRightClicked())) {
                Player owner = (Player) ((Wolf) e.getRightClicked()).getOwner();
                e.setCancelled(true);
                int HP_IV = (int) DataManager.getvalue(owner, e.getRightClicked().getCustomName(), "stats.iv.hp");
                Bukkit.broadcastMessage("pokemon van" + owner.getName());
                Bukkit.broadcastMessage("iv");
                Bukkit.broadcastMessage("hp:" + HP_IV);
            }
        }
    }
}
