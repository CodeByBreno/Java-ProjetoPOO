package habilidades;

import java.util.ArrayList;
import java.util.List;

public class HabilidadesSoldado extends BancoHabilidades{
	
	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		this.allH = new ArrayList();
		Habilidade H = new Ataque("Murro", "doi muito", 2, 0, this.size++, 5, (float) 1.2);
		this.allH.add(H);
		H = new Ataque("Granada", "doi muito", 2, 0, this.size++, 15, (float) 1.1);
		this.allH.add(H);
		H = new Ataque("Tiro", "doi muito", 2, 0, this.size++, 12, (float) 1.3);
		this.allH.add(H);
		
		H = new Buff("CoronaVac", "cura que é uma beleza", 1, -5, this.size++, 0, 2, 10);
		this.allH.add(H);
		H = new Buff("Grito de Guerra", "Aumenta defesa e ataque", 2, 0, this.size++, 5, 5, 0);
		this.allH.add(H);
	}
	
}
