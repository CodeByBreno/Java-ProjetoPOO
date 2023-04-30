package habilidades;

import java.util.ArrayList;
import java.util.List;

public class HabilidadesRobo extends BancoHabilidades {
	
	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		this.allH = new ArrayList();
		Habilidade H = new Ataque("Estática", "doi muito", 3, 0, this.size++, 20, (float) 1.3);
		this.allH.add(H);
		H = new Ataque("Campo de Choque", "doi muito", 2, 0, this.size++, 10, (float) 1.1);
		this.allH.add(H);
		H = new Ataque("Punho estático", "doi muito", 2, 0, this.size++, 12, (float) 1.2);
		this.allH.add(H);
		
		H = new Buff("Troca de Óleo", "cura que é uma beleza", 1, -5, this.size++, 0, 0, 10);
		this.allH.add(H);
		H = new Buff("Barreira Eletrica", "Aumenta defesa e ataque", 2, 0, this.size++, 6, 6, 0);
		this.allH.add(H);
	}
	
}
