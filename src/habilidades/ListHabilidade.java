package habilidades;

import java.util.ArrayList;
import java.util.List;

public class ListHabilidade {
	BancoHabilidades BH;
	List<Habilidade> myHab;
	
	public ListHabilidade(int tipo) {
		this.myHab = new ArrayList();
		switch(tipo) {
		case 1: //Soldier
			BH = new HabilidadesSoldado();
			break;
		case 2: //Robo
			BH = new HabilidadesRobo();
			break;
		case 3: //Borbadeiro
			BH = new HabilidadesBombardeiro();
			break;
		case 4: //Alien
			BH = new HabilidadesAlien();
			break;
		}
		this.BH.inicializar();
		this.descobrirHab(0);
	}
	public Habilidade get(int posicao) {
		return this.myHab.get(posicao);
	}
	
	public void descobrirHab() {
		Habilidade h = this.BH.retornarAleat();
		while(myHab.contains(h)) {
			h = this.BH.retornarAleat();
		}
                System.out.printf("\nVocê ganhou a habilidade %s, ela %s!\n", h.getName(), h.getDescription());
		this.myHab.add(h);
	}
	
	public void descobrirHab(int index) {
		this.myHab.add(BH.allH.get(index));
	}
	
	public String descricaoCombate() {
		String s = "";
		List<String> sL = new ArrayList();
		for(int i=0 ; i<this.myHab.size() ; ++i){
			sL.add(String.format("%d - %s  (%s)\n", 
					i+1,
					this.myHab.get(i).getName(), 
					(this.myHab.get(i).getTime() == 0 ? "Pronta!" : this.myHab.get(i).getTime()+" turnos")));
		}
		return s.join("", sL);
	}
	
	public void atualizarCombate() {
		for(Habilidade x : this.myHab) {
			x.diminuirTempoRecarga();
		}
	}
	
	public int getSize() {
		return this.myHab.size();
	}
}
