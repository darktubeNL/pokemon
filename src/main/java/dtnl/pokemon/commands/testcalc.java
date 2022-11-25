package dtnl.pokemon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class testcalc implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof Player)) {
            if(args.length >0){
                int level = 81;
                int HP = 35;
                int HP_IV = 7;
                int Attack = 49;
                int Attack_IV = 7;
                int Defense = 49;
                int Sp_Atk = 65;
                int Sp_Dev = 65;
                int Speed = 45;
                int ev = 22850;
                int Healtpoints = (int) Math.floor(((((HP + HP_IV) * 2 + (Math.sqrt(22850) / 4)) * level) / 100) + level + 10);
                sender.sendMessage("health:" + Healtpoints);
            }
        }
        return true;
    }
}
