package dtnl.pokemon.commands;

import dtnl.pokemon.manager.DataManager;
import dtnl.pokemon.manager.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class GiveCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof Player)) {
            if(Objects.equals(args[0], "createpokemon")){
                DataManager.Addpokemon((Player) sender, 1,5,31,31,31,31,31);
            }
            if(Objects.equals(args[0], "getpokemonbal")){
                ItemStack pokeball = new ItemBuilder(Material.SNOWBALL).displayname(args[1]).build();
                ItemMeta meta = pokeball.getItemMeta();
                meta.setCustomModelData(1);
                pokeball.setItemMeta(meta);
                ((Player) sender).getInventory().addItem(pokeball);
            }
        }
        return true;
    }
}
