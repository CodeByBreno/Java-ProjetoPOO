package habilidades;

import java.util.ArrayList;
import java.util.List;

public class HabilidadesBombardeiro extends BancoHabilidades {

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		this.allH = new ArrayList();
		Habilidade H = new Ataque("Lança misseis", "doi muito", 3, 0, this.size++, 20, (float) 1.2);
		this.allH.add(H);
		H = new Ataque("Bomba de Hidrogênio", "doi muito", 4, 0, this.size++, 30, (float) 1.1);
		this.allH.add(H);
		H = new Ataque("Mina Explosiva", "doi muito", 1, 0, this.size++, 12, (float) 1.2);
		this.allH.add(H);
		
		H = new Buff("Recarga", "aumenta o ataque", 1, -5, this.size++, 0, 5, 0);
		this.allH.add(H);
		H = new Buff("Domo Protetor", "Aumenta defesa", 2, 0, this.size++, 7, 0, 0);
		this.allH.add(H);
	}

}
