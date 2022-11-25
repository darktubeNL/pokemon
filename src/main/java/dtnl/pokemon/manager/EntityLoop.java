package dtnl.pokemon.manager;

import dtnl.pokemon.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;

import java.util.List;

public class EntityLoop {
    public static void startloop(){
        Bukkit.getServer().getScheduler().runTaskTimer(Main.pl, () -> {
            for (Entity e : Bukkit.getWorld("world").getEntities()){
                if(e instanceof Wolf){
                    if(!Main.Pokemons.values().contains(e)){
                        Boolean remove = false;
                        if(((Wolf) e).getOwner() != null && Bukkit.getOnlinePlayers().contains(((Wolf) e).getOwner())) {
                            if (!((Wolf) e).hasLineOfSight((Entity) ((Wolf) e).getOwner())) {
                                remove = true;
                            }
                        }
                        if(!e.getPassengers().isEmpty()) {
                            remove = true;
                        }
                        if(remove){
                            for (Entity as : e.getPassengers()) {
                                as.remove();
                            }
                            e.remove();
                        }
                    }
                }
            }
            for (Wolf wolf : Main.Pokemons.values()) {
                Entity as = wolf.getPassengers().get(0);
                as.setRotation(wolf.getLocation().getYaw(), wolf.getLocation().getPitch());
            }
        }, 0, 1);
    }
}
