
package Characters;
import java.util.Random;

import habilidades.Ataque;
import habilidades.ListHabilidade;

public class Character {
    String Nome;
    int Hp;
    int Dano;
    int Defesa;
    int Crítico;
    int Sorte;
    int Agilidade;
    int Mana;
    ListHabilidade listaHab;
    int ouro;
    int experiencia;
    
    int DanoTotal;
    int HpTotal;
    int DefesaTotal;
    int CriticoTotal;
    int SorteTotal;
    int AgilidadeTotal;
    int ManaTotal;
    int Round;

    public Character(){
        
    }
    
    public Character(String Nome, int Hp, int Dano, int Defesa, int Crítico, int Sorte, int Agilidade, int Mana) {
        this.Nome = Nome;
        this.Hp = Hp;
        this.Dano = Dano;
        this.Defesa = Defesa;
        this.Crítico = Crítico;
        this.Sorte = Sorte;
        this.Agilidade = Agilidade;
        this.Mana = Mana;
    }

    public int getDanoTotal() {
        return DanoTotal;
    }

    public int getHpTotal() {
        return HpTotal;
    }

    public int getDefesaTotal() {
        return DefesaTotal;
    }

    public int getCriticoTotal() {
        return CriticoTotal;
    }

    public int getSorteTotal() {
        return SorteTotal;
    }

    public int getAgilidadeTotal() {
        return AgilidadeTotal;
    }

    public int getManaTotal() {
        return ManaTotal;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public int getOuro(){
        return this.ouro;
    }
    
    public void setDanoTotal(int DanoTotal) {
        this.DanoTotal = DanoTotal;
    }

    public void setHpTotal(int HpTotal) {
        this.HpTotal = HpTotal;
    }

    public void setDefesaTotal(int DefesaTotal) {
        this.DefesaTotal = DefesaTotal;
    }

    public void setCriticoTotal(int CriticoTotal) {
        this.CriticoTotal = CriticoTotal;
    }

    public void setSorteTotal(int SorteTotal) {
        this.SorteTotal = SorteTotal;
    }

    public void setAgilidadeTotal(int AgilidadeTotal) {
        this.AgilidadeTotal = AgilidadeTotal;
    }

    public void setManaTotal(int ManaTotal) {
        this.ManaTotal = ManaTotal;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setHp(int Hp) {
        this.Hp = Hp;
    }

    public void setDano(int Dano) {
        this.Dano = Dano;
    }

    public void setDefesa(int Defesa) {
        this.Defesa = Defesa;
    }

    public void setCrítico(int Crítico) {
        this.Crítico = Crítico;
    }

    public void setSorte(int Sorte) {
        this.Sorte = Sorte;
    }

    public void setAgilidade(int Agilidade) {
        this.Agilidade = Agilidade;
    }

    public void setMana(int Mana) {
        this.Mana = Mana;
    }

    public void setListaHab(ListHabilidade listaHab) {
        this.listaHab = listaHab;
    }
    //getters
    public String getNome(){
        return (this.Nome);
    }
    public int getHp(){
        return (this.Hp);
    }
    public int getDano (){
        return (this.Dano);
    }
    public int getDefesa(){
        return (this.Defesa);
    }
    public int getCrítico(){
        return (this.Crítico);
    }
    public int getSorte(){
        return (this.Sorte);
    }
    public int getAgilidade(){
        return (this.Agilidade);
    }
    public int getMana() {
    	return (this.Mana);
    }
    public void incrementVida(int f) {
    	this.HpTotal += f;
    }
    public void incrementDefesa(int v) {
    	this.DefesaTotal += v;
    }
    public void incrementDano(int v) {
    	this.DanoTotal += v;
    }
    public void incrementMana(int v) {
    	this.ManaTotal += v;
    }
    
    public void atacar (Character P){
        Random aleat = new Random();
        int dado1 = aleat.nextInt(this.getSorteTotal() + this.getAgilidadeTotal());
        int dado2 = aleat.nextInt(P.getSorteTotal() + P.getAgilidadeTotal());
        if (dado1 >= dado2){
            if(this.getDanoTotal() > P.getDefesaTotal())
                P.HpTotal -= this.getDanoTotal() - P.getDefesaTotal();
            else
                P.HpTotal -= 1;
        }
        else
            System.out.println(this.getNome() + " errou o ataque!");
    }
    
    public void Status(){
        System.out.println(this.getNome() + 
                "\nHp : " + this.getHp() +
                "\nDano : " + this.getDano() +
                "\nDefesa : " + this.getDefesa() +
                "\nCritico : " + this.getCrítico() +
                "\nAgilidade : " + this.getAgilidade() +
                "\nSorte : " + this.getSorte() +
                "\nMana : " + this.getMana());
    }
    
    public void FastStatus(){
        System.out.printf("%s - [%d, %d, %d, %d]\n", this.getNome(), this.getHpTotal()
        , this.getDanoTotal() , this.getDefesaTotal() , this.getManaTotal());
    }
    
    public boolean usarHabilidade(Character P, int index) {
    	return this.listaHab.get(index-1).usar(this, P);
    }
    
    public boolean usarHabilidade(Character P) {
    	Random r = new Random();
    	int index = r.nextInt(this.listaHab.getSize());
    	return this.listaHab.get(index).usar(this, P);
    }
    
    public String descreverHab() {
    	return this.listaHab.descricaoCombate();
    }
    
    public void ResetStatus(){
        this.HpTotal = this.Hp;
        this.DanoTotal = this.Dano;
        this.DefesaTotal = this.Defesa;
        this.CriticoTotal = this.Crítico;
        this.AgilidadeTotal = this.Agilidade;
        this.SorteTotal = this.Sorte;
        this.ManaTotal = this.Mana;
    }

}
