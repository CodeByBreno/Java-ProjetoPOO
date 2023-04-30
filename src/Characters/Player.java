package Characters;

import java.util.Random;
import java.util.Scanner;

import habilidades.ListHabilidade;
import Itens.Equipamentos;
import Itens.Usaveis;
import Itens.Armas;
import Itens.Itens;
import java.awt.BorderLayout;

public class Player extends Character{
    int nivel = 1;
    String Classe;
    Usaveis BolsaMenor[] = new Usaveis[20];
    int posItem;
    
    Equipamentos Armadura[] = new Equipamentos[6];
    Equipamentos Bolsa[] = new Equipamentos[10];
    int posLivre = 0;
    
    Armas ArmaPrincipal;
    Armas Bolsa2[] = new Armas[10];
    int posLivre2 = 0;
    
    // vetor de itens
    // vetor de habilidades
    
    //construtor
    public Player (){
        Scanner ler = new Scanner (System.in);
        System.out.println("\nInsira o nome do personagem :");
        this.Nome = ler.nextLine();
        System.out.println("\nEscolha a classe do seu personagem: \n" +
                           "Aperte 1 - Soldado\n" +
                           "Aperte 2 - Robô\n" +
                           "Aperte 3 - Bombardeiro\n" + 
                           "Aperte 4 - Alien\n" +
                           "Outro - Finaliza execução");
        int n = ler.nextInt();
        this.implementaClasse(n);
        this.listaHab = new ListHabilidade(n);
        for (int i = 0; i < 10; i++){
        	this.Bolsa[i] = null;
            this.Bolsa2[i] = null;
        }
        for (int i = 0; i < 20; i++){
            this.BolsaMenor[i] = null;
        }
        for (int i = 0; i < 6; i++){
            this.Armadura[i] = null;
        }
    }
    
    public int getNivel(){
        return this.nivel;
    }
    public int getOuro(){
        return this.ouro;
    }
    public void setOuro(int ouro){
        this.ouro=ouro;
    }
    
    //funções adicionais
    private void implementaClasse (int i){
        this.ouro = 20;
        this.experiencia = 0;
        switch (i){
            case 1: { //Soldado
                this.Hp = 50;
                this.Dano = 10;
                this.Crítico = 5;
                this.Defesa = 5;
                this.Mana = 20;
                this.Sorte = 1;
                this.Agilidade = 1;
                break;
            }
            case 2: { //Robô
                this.Hp = 100;
                this.Dano = 5;
                this.Crítico = 2;
                this.Defesa = 12;
                this.Mana = 20;
                this.Sorte = 1;
                this.Agilidade = 1;
                break;
            }
            case 3: { //Bombardeiro
                this.Hp = 30;
                this.Dano = 20;
                this.Crítico = 10;
                this.Defesa = 0;
                this.Mana = 20;
                this.Sorte = 1;
                this.Agilidade = 1;
                break;
            }
            case 4: { //Alien
                this.Hp = 40;
                this.Dano = 15;
                this.Crítico = 8;
                this.Defesa = 2;
                this.Mana = 20;
                this.Sorte = 1;
                this.Agilidade = 1;
                break;
            }
            default: {
                System.exit(0);
            }
        }
    } 
    
    public void GanharExperiencia(int exp){
        this.experiencia += exp;
        while (this.nivel < 20 && this.experiencia >= this.nivel * 5){
            this.experiencia -= this.nivel * 5;
            if(++this.nivel % 5 == 0)
                this.ganharHabilidade();
        }
        System.out.printf("\nVocê ganhou %d de xp!\nNivel: %d [%d/%d]\n", exp, nivel, experiencia, nivel * 5);
    }
    
    public void GanharOuro (int ouro){
        this.ouro += ouro;
        if(ouro > 0)
            System.out.printf("\nVocê ganhou %d de ouro!\nAgora tem %d de ouro\n", ouro, this.ouro);
        else
            System.out.printf("\nVocê gastou %d de ouro!\nAgora tem %d de ouro\n", -ouro, this.ouro);
    }
    
    public void ganharHabilidade() {
    	this.listaHab.descobrirHab();
    }
    
    public boolean Equipar (Equipamentos e){
        if (this.Armadura[e.getTipo()] != null){
            System.out.println("\nVocê já possui essa peça equipada. Deseja troca-la pela nova?\n"
            + "1 - Sim\n" + "Outro - Não");
            Scanner ler = new Scanner(System.in);
            if(ler.nextInt() != 1)
                return false;
            Desequipar(e.getTipo());
        }
        this.Agilidade += e.getAgilidade();
        this.Defesa += e.getDefesa();
        this.Sorte += e.getSorte();
        this.Armadura[e.getTipo()] = e;
        return true;
    } //Equipamentos
    
    public void Desequipar (int i){
        if (this.Armadura[i] == null){
            System.out.println("\nVocê não equipou uma armadura desse tipo");
        }
        else{
            Scanner ler = new Scanner (System.in);
            this.Agilidade -= this.Armadura[i].getAgilidade();
            this.Defesa -= this.Armadura[i].getDefesa();
            this.Sorte -= this.Armadura[i].getSorte();
            if (posLivre != 9){
                System.out.println("\nO item desequipado será jogado fora ou colocado na bolsa?\n"
                        + "1 - Colocado na bolsa\n"
                        + "Outro - Jogar fora");
                if (ler.nextInt() == 1)
                    this.GuardarItem(this.Armadura[i]);
                this.Armadura[i] = null;
            }
        }
    } //Equipamentos
    
    public boolean Equipar(Armas a){
        if (ArmaPrincipal != null){
            System.out.println("\nVocê já possui uma arma equipada. Deseja troca-la pela nova?\n"
            + "1 - Sim\n" + "Outro - Não");
            Scanner ler = new Scanner(System.in);
            if(ler.nextInt() != 1)
                return false;
            System.out.println("\nGuardar a arma atual na bolsa ou joga-la fora?\n"
            + "1 - Guardar\n" + "Outro - Jogar Fora");
            if (ler.nextInt() == 1)
                if(this.GuardarItem(ArmaPrincipal) == false)
                    return false;
            this.TrocarArma(a);
        }else{
            this.ArmaPrincipal = a;
            this.Dano += a.getDano();
        }
        return true;
    }//Armas
    
    public boolean Equipar(Itens i){
        if(i.getClass() == Equipamentos.class)
            return Equipar((Equipamentos) i);
        else if(i.getClass() == Armas.class)
            return Equipar((Armas) i);
        else
            return GuardarItem((Usaveis) i);
    }
    
    public boolean GuardarItem (Equipamentos e){
        while(posLivre > 9){
            System.out.println("\nA Bolsa está cheia");
            if(this.JogarItemFora(1) == false)
                return false;
        }
        this.Bolsa[posLivre] = e;
        posLivre++;
        return true;
    } //Equipamentos
    
    public boolean GuardarItem (Armas a){
        while(posLivre > 9){
            System.out.println("\nA Bolsa está cheia");
            if(this.JogarItemFora(2) == false)
                return false;
        }
        this.Bolsa2[posLivre2] = a;
        posLivre2++;
        return true;
    } //Armas
    
    public boolean GuardarItem (Usaveis u){
        for (int i = 0; i < posItem; i++){
            if (this.BolsaMenor[i].getNome().equals(u.getNome())){
                this.BolsaMenor[i].AumentarQuant();
                return true;
            }
        }
        while(posItem > 19){
            System.out.println("\nA Bolsa está cheia\n"
            + "Jogar algum item fora?\n"
            + "1 - Sim\n" + "Outro - Não");
            Scanner ler = new Scanner (System.in);
            if (ler.nextInt() != 1)
                return false;
            if(this.JogarItemFora(3) == false)
                return false;
        }
        this.BolsaMenor[posItem] = u;
        u.AumentarQuant();
        posItem++;
        return true;
    } //Usaveis
    
    private boolean JogarItemFora (int i){
        this.MostrarBagagem();
        Scanner ler = new Scanner(System.in);
        if (i == 1) {
                this.MostrarEquipamentos();
                System.out.println("\nInsira o numero do equipamento que deseja jogar fora\n"
                                    + "Para cancelar, insira -1");
                int selec = ler.nextInt();
                if (selec == -1) return false;
                while (!(selec <= 0 || selec >= this.posLivre)){
                    System.out.println("Posição inválida");
                    selec = ler.nextInt();
                }
                selec--;
                this.Bolsa[selec] = null;
                while (this.Bolsa[selec+1] != null){
                    this.Bolsa[selec] = this.Bolsa[selec+1];
                    selec++;
                }
                this.Bolsa[selec] = null;
                posLivre--;
                return true;
        }
        if (i == 2){
            this.MostrarArmas();
            System.out.println("\nInsira o numero da arma que deseja jogar fora\n"
                                    + "Para cancelar, insira -1");
            int selec = ler.nextInt();
            while (!(selec <= 0 || selec >= this.posLivre2)){
                if (selec == -1) return false;
                System.out.println("Posição inválida");
                selec = ler.nextInt();
            }
            selec--;
            this.Bolsa2[selec] = null;
            while (this.Bolsa[selec+1] != null){
                this.Bolsa[selec] = this.Bolsa[selec+1];
                selec++;
            }
            this.Bolsa2[selec] = null;
            posLivre2--;
            return true;
        }
        if (i == 3){
            this.MostrarItens();
            System.out.println("\nInsira o numero do item que deseja jogar fora\n"
                                + "Para cancelar, insira um numero negativo");
            int selec = ler.nextInt();
            while (!(selec <= 0 || selec >= this.posLivre2)){
                if (selec < 0) return false;
                System.out.println("Posição inválida");
                selec = ler.nextInt();
            }
            selec--;
            System.out.println("\nVocê possui " + this.BolsaMenor[selec].getQuantidade() +
                               " unidades desse item. Quantas deseja jogar fora?" +
                               " (digite um numero negativo para voltar)");
            int q = ler.nextInt();
            if (q < 0) return false;
            if (this.BolsaMenor[selec].getQuantidade() > q){
                this.BolsaMenor[selec].setQuantidade(this.BolsaMenor[selec].getQuantidade() - q);
                return true;
            }else{
                this.BolsaMenor[selec].setQuantidade(0);
                this.BolsaMenor[selec] = null;
            }
            while (this.BolsaMenor[selec+1] != null){
                this.Bolsa[selec] = this.Bolsa[selec+1];
                selec++;
            }
            this.BolsaMenor[selec] = null;
            posItem--;
            return true;
        }
        return false;
    } //Equipamentos
    
    private void TrocarArma (Armas nova){
        this.Dano -= ArmaPrincipal.getDano();
        ArmaPrincipal = nova;
        this.Dano += nova.getDano();
    } //Armas1
    
    public boolean UsarItem(){ // posição no vetor de itens
        System.out.println("\nEscolha qual item você quer usar\n0 - Cancelar");
        this.MostrarItens();
        Scanner ler = new Scanner (System.in);
        int i = -1;
        while(i < 0 || i > posItem || this.BolsaMenor[i-1].getQuantidade() == 0){
            i = ler.nextInt();
            if(i == 0)
                return false;
        }
        this.BolsaMenor[i-1].AplicarBenefícios(this);
        this.BolsaMenor[i-1].usar();
        return true;
    } //Armas
    
    public void MostrarBagagem(){
        System.out.println("\nSeus itens são: \n");
        this.MostrarEquipamentos();
        this.MostrarArmas();
        this.MostrarItens();
    }
    
    public void MostrarEquipamentos(){
        System.out.println("Equipamentos : ");
        for (int i = 0; i < posLivre; i++){
            System.out.println(i+1 + " - " + this.Bolsa[i].getNome());
        }
    }
    public void MostrarArmas(){
        System.out.println("Armas : \n");
        System.out.println("Equipada => " + this.ArmaPrincipal.getNome());
        for (int i = 0; i < posLivre2; i++){
            System.out.println(i+1 + " - " + this.Bolsa2[i].getNome());
        }
    } //Armas
    public void MostrarItens(){
        System.out.println("Bolsa de itens: ");
        for (int i = 0; i < posItem; i++){
            System.out.printf(i+1 + " - ");
            this.BolsaMenor[i].mostrar();
        }
    }
    
    public void maisDefesa(int i){
        this.DefesaTotal+=i;
    }
    public void maisDano(int i){
        this.DanoTotal+=i;
    }
    public void maisVida(int i){
        this.HpTotal += i;
    }

    public void atualizarCombate() {
    	this.listaHab.atualizarCombate();
    }
}