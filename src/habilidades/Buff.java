package habilidades;

import Characters.Character;

public class Buff extends Habilidade{
	int maxDefense;
	int maxAttack;
	int heal;
	
	
	
	public Buff(String name, String description, int duration, int manaCost, int id, int maxDefense, int maxAttack, int heal) {
		super(name, description, duration, manaCost, id);
		this.maxDefense = maxDefense;
		this.maxAttack = maxAttack;
		this.heal = heal;
	}
	public int getMaxDefense() {
		return maxDefense;
	}
	public void setMaxDefense(int maxDefense) {
		this.maxDefense = maxDefense;
	}
	public int getMaxAttack() {
		return maxAttack;
	}
	public void setMaxAttack(int maxAttack) {
		this.maxAttack = maxAttack;
	}
	public int getHeal() {
		return heal;
	}
	public void setHeal(int heal) {
		this.heal = heal;
	}
	
	public boolean usar(Character T, Character P) {
		if(this.getTime() > 0) {
			System.out.println("Habilidade em Tempo de Recarga.");
			return false;
		}
		if(P.getManaTotal() >= -this.getManaCost()) {
			P.incrementDefesa(getMaxDefense());
			P.incrementVida(getHeal());
			P.incrementMana(this.getManaCost());
			this.setTime(this.getDuration());
			return true;
		}else {
			System.out.println("Mana Insuficiente");
			return false;
		}
	}
}
