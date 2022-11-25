package dtnl.pokemon.manager;

import dtnl.pokemon.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PokemonEntity {
    public static void Spawnpokemon(String id, Location loc, Player owner){
        Wolf wolf = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
        wolf.setInvisible(true);
        wolf.setInvulnerable(true);
        wolf.setOwner(owner);
        wolf.setAngry(false);
        Main.Pokemons.put(owner.getUniqueId(), wolf);
        ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(wolf.getLocation(), EntityType.ARMOR_STAND);
        wolf.addPassenger(as);
        ItemStack pokemonmodel = new ItemStack(Material.FEATHER);
        ItemMeta pokemonmodelmeta = pokemonmodel.getItemMeta();
        int modelid = (int) DataManager.getvalue(owner,id,"pokemon.id");
        pokemonmodelmeta.setCustomModelData(modelid);
        pokemonmodel.setItemMeta(pokemonmodelmeta);
        as.setCustomName(ChatColor.GRAY + "Pokemon of " + owner.getName());
        as.setCustomNameVisible(true);
        as.setVisible(false);
        wolf.setCustomName(id);
        as.setInvulnerable(true);
        as.getEquipment().setHelmet(pokemonmodel);
    }
    public static void despawnpokemon(Player owner){
        if(Main.Pokemons.get(owner.getUniqueId()) != null){
            Wolf wolf = Main.Pokemons.get(owner.getUniqueId());
            for (Entity as : wolf.getPassengers()) {
                as.remove();
            }
            wolf.remove();
        }
    }
}
