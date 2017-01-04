package pokemons;

import exceptions.BadPotionException;
import exceptions.DeadPokemonException;
import model.PokemonGrass;

public class Bulbasaur extends PokemonGrass {

	public Bulbasaur(int AP, int DP, int maxHP) {
		super(AP, DP, maxHP);
		super.attackName = "Leaf storm";
		super.name = "Bulbasaur";
	}
	
	public Bulbasaur(int AP, int DP, int maxHP, String name) {
		this(AP, DP, maxHP);
		super.name = name;
	}
	
	public static void main(String[]args){
		
		Bulbasaur b1 = new Bulbasaur(40, 20, 100, "Bulba1");
		Bulbasaur b2 = new Bulbasaur(40, 1, 10, "bulba2");
		
		b1.attack(b2);

		try {
			b2.heal(10);
		} catch (BadPotionException | DeadPokemonException e) {
				e.printStackTrace();
		}
	}

}
