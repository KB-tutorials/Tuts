package model;

public abstract class PokemonGrass extends Pokemon {

	public PokemonGrass(int AP, int DP, int maxHP) {
		super(AP, DP, maxHP);
		super.type = PokemonType.GRASS;
		super.weakAgainst = PokemonType.FIRE;
		super.strongAgainst = PokemonType.WATER;
	}

}
