package habilidades;

import java.util.Random;

import Characters.Character;

public class Ataque extends Habilidade {
	int damage;
	float criticChance;
	
	public Ataque(String name, String description, int duracao, int manaCost, int id, int damage, float criticChance) {
		super(name, description, duracao, manaCost, id);
		this.damage = damage;
		this.criticChance = criticChance;
	}
	public int getDamage() {
		return this.damage;
	}
	public float getTotalDamage(Character T) {
		Random r = new Random();
		float n = r.nextFloat();
		if(this.criticChance > n + 1) {
			return this.damage*n;		
		}else {
			return this.damage;
		}
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public float getCriticChance() {
		return criticChance;
	}
	public void setCriticChance(float criticChance) {
		this.criticChance = criticChance;
	}
	public boolean usar(Character T, Character P) {
		if(this.getTime() > 0) {
			System.out.println("Habilidade em Tempo de Recarga.");
			return false;
		}
		if(T.getManaTotal() >= -this.getManaCost()) {
			P.incrementVida((int)-this.getTotalDamage(T));
			P.incrementMana(this.getManaCost());
			this.setTime(this.getDuration());
			return true;
		}else {
			System.out.println(T.getNome()+"Mana Insuficiente.");
			return false;
		}
	}
}