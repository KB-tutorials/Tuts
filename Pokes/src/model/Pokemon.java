package model;

import exceptions.BadPotionException;
import exceptions.DeadPokemonException;

public abstract class Pokemon {
	private int attackPoints;
	private int defensePoints;
	private int currentHP;
	private int maxHP;
	protected String name;
	protected String attackName;
	protected PokemonType type;
	protected PokemonType strongAgainst;
	protected PokemonType weakAgainst;
	

	public Pokemon(int AP, int DP, int maxHP){
		this.attackPoints = AP;
		this.defensePoints = DP;
		this.maxHP = maxHP;
	}
	
	public void heal(int hp) throws BadPotionException, DeadPokemonException{
		if(hp < 0){
			throw new BadPotionException("Heal value can only be positive.");
		}
		if(currentHP > 0){
			if(currentHP + hp > maxHP){
				currentHP = maxHP;
			}
			else{
				currentHP += hp;
			}
		}
		else{
			throw new DeadPokemonException("Your pokemon is dead...");
		}
	}
	
	public void attack(Pokemon other){
		int dmg = attackPoints;
		System.out.println(getName() + " used " + getAttackName() + ".");
		if(other.type.equals(this.strongAgainst)){
			dmg = (int)(dmg * 1.5);
			superEffectiveMessage();
		}
		else if(other.type.equals(this.weakAgainst)){
			dmg = (int)(dmg * 0.7);
			notEffectiveMessage();
		}
		attackInfo(dmg);
		other.getAttacked(dmg);
	}
	
	public void getAttacked(int dmg){
		dmg -= (int)(defensePoints/7);
		if(currentHP > dmg){
			currentHP -= dmg;
		}
		else{
			currentHP = 0;
			deadInfo();
		}
	}
	
	private final void deadInfo(){
		System.out.println(getName() + " is dead.");
	}
	
	private void attackInfo(int dmg){
		System.out.println(getName() + " dealt " + dmg + " damage.");
	}
	
	private final void superEffectiveMessage(){
		System.out.println(getAttackName() + " is super effective!");
	}
	
	private final void notEffectiveMessage(){
		System.out.println(getAttackName() + " is not very effective...");
	}
	
	public int getAttackPoints() {
		return attackPoints;
	}

	public int getDefensePoinst() {
		return defensePoints;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public String getName() {
		return name;
	}

	public String getAttackName() {
		return attackName;
	}

	public PokemonType getType() {
		return type;
	}

	public PokemonType getStrongAgainst() {
		return strongAgainst;
	}

	public PokemonType getWeakAgainst() {
		return weakAgainst;
	}

}
