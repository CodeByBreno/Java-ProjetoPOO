
package Quests;

import Characters.Mob;

public class Quest {
    Mob mob;
    int qtd;
    int objetivo;
    int exp_bonus; //bonus em experiencia obtido ao conclui-la
    //vetor de itens de recompensa
    
    //método para executar o(s) combate(s) associados à missão
    //método para adicionar ao player que concluir a missão a xp envolvida

    public Quest(Mob mob, int objetivo, int exp_bonus) {
        this.mob = mob;
        this.qtd = 0;
        this.objetivo = objetivo;
        this.exp_bonus = exp_bonus;
    }

    public Mob getMob() {
        return mob;
    }

    public int getQtd() {
        return qtd;
    }

    public int getobjetivo(){
        return objetivo;
    }
    
    public int getExp_bonus() {
        return exp_bonus;
    }
    
    public boolean concluido(){
        return qtd >= objetivo;
    }
    
    public boolean ganhou(){
        if(++this.qtd == this.objetivo){
            System.out.printf("Parabéns, voce concluiu a missão de matar %d %s\n", this.objetivo, this.mob.getNome());
            return true;
        }
        return false;
    }
}
