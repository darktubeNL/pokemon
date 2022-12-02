package dtnl.pokemon.manager;

public class PokemonCalculations {
    public static int gethealth(int Base_HP, int HP_IV, int level){
        return (int) Math.floor(((((Base_HP + HP_IV) * 2 + (Math.sqrt(22850) / 4)) * level) / 100) + level + 10);
    }


}
