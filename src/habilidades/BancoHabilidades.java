package habilidades;

import java.util.List;
import java.util.Random;

public abstract class BancoHabilidades {
	List<Habilidade> allH;
	int size;
	
	public abstract void inicializar() ;
	public Habilidade retornarAleat() {
		Random r = new Random();
		int i = r.nextInt(this.size);
		return allH.get(i);
	}
}
