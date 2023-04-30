
package Characters;

public class Mob extends Character{
    
    public Mob(String Nome, int Hp, int Dano, int Defesa, int Crítico, int Sorte, int Agilidade, int exp_recomp, int ouro_recomp) {
        super(Nome, Hp, Dano, Defesa, Crítico, Sorte, Agilidade, 0);
        this.experiencia = exp_recomp;
        this.ouro = ouro_recomp;
    }
}
