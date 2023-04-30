package habilidades;

import java.util.ArrayList;
import java.util.List;

public class HabilidadesAlien extends BancoHabilidades {

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		this.allH = new ArrayList();
		Habilidade H = new Ataque("Laser", "doi muito", 1, -5, this.size++, 10, (float) 1.4);
		this.allH.add(H);
		H = new Ataque("Abduçãoo", "doi muito", 2, -5, this.size++, 20, (float) 1.1);
		this.allH.add(H);
		H = new Ataque("Explosivo espacial", "doi muito", 3, -5, this.size++, 20, (float) 1.2);
		this.allH.add(H);
		
		H = new Buff("Cogumelo Espacial", "Cura", 1, -5, this.size++, 0, 0, 5);
		this.allH.add(H);
		H = new Buff("Joia do Infinito", "Aumenta ataque", 2, 10, this.size++, 0, 5, 0);
		this.allH.add(H);
	}

}
