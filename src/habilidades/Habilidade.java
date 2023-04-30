package habilidades;

public abstract class Habilidade {
	private String name;
	private String description;
	private int duration;
	private int manaCost;
	private int id;
	private int time;
	
	
	public Habilidade(String name, String description, int duration, int manaCost, int id) {
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.manaCost = manaCost;
		this.id = id;
		this.time = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTime() {
		return this.time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void diminuirTempoRecarga() {
		if(time > 0)
			time--;
	}
	public abstract boolean usar(Characters.Character T, Characters.Character P) ;
}
