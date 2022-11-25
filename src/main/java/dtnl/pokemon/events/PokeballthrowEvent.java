package dtnl.pokemon.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

public class PokeballthrowEvent implements Listener {
    @EventHandler
    public void onProjectileHit(ProjectileLaunchEvent e) {
        if(e.getEntity().getType() == EntityType.SNOWBALL){
            Player player = (Player) e.getEntity().getShooter();
            Projectile pokeball = e.getEntity();
            pokeball.setCustomName(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName());
        }
    }
}
