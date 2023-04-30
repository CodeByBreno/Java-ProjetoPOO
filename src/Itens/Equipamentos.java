
package Itens;

import java.util.Random;
import java.util.Scanner;

public class Equipamentos extends Itens{
    /* Tabela de Equipamento:
    1- Peitoral  - Defesa: 9 - Agilidade: 10 - Nível minimo: 5  
    2- Capacete  - Desesa: 7 - Agilidade: 8 - Nível minimo: 4  
    3- Calças    - Defesa: 5 - Agilidade: 6 - Nível minimo: 3 
    4- Luvas     - Defesa: 3 - Agilidade: 4 - Nível minimo: 2 
    5- Adicional - Defesa: 1 - Agilidade: 2 - Nível minimo: 1 
    
    */
    int bonus_defesa;
    int bonus_agilidade;
    int bonus_sorte;
    int tipo; 
    
    int PartesDefesa[] = {9,7,5,3,1};
    int PartesAgilidade[] = {10,8,6,4,2};    
    Scanner io = new Scanner(System.in);
    Random rand = new Random();

    public Equipamentos(int bonus_defesa, int bonus_agilidade, int bonus_sorte, int tipo, String Nome, int preco, int nivel) {
        super(Nome, preco, nivel);
        this.bonus_defesa = bonus_defesa;
        this.bonus_agilidade = bonus_agilidade;
        this.bonus_sorte = bonus_sorte;
        this.tipo = tipo;
    }
    
    public void mostrar(){
        System.out.printf("Armadura '%s' custa %d\n\tDef %d | Agi %d | Sor %d | Niv %d\n", this.Nome, this.preco, this.bonus_defesa, this.bonus_agilidade, this.bonus_sorte, this.nivel);
    }
    
    public Equipamentos(int nivel){
        
        System.out.println("Digite o tipo de armadura que deseja: ");
        System.out.println("[1] - Peitoral  - Defesa: 9 - Agilidade: 10 - Nível minimo: 5");
        System.out.println("[2] - Capacete  - Desesa: 7 - Agilidade: 8 - Nível minimo: 4");
        System.out.println("[3] - Calças    - Defesa: 5 - Agilidade: 6 - Nível minimo: 3");
        System.out.println("[4] - Luvas     - Defesa: 3 - Agilidade: 4 - Nível minimo: 2");
        System.out.println("[5] - Adicional - Defesa: 1 - Agilidade: 2 - Nível minimo: 1 ");
        
    }
    public void comprarEquipamento(int nivel){
        int qual;
        do{
            qual=io.nextInt();
            if(qual < 1 || qual > 5){
                System.out.println("Opção Inválida!\nDigite outra opcao");
                continue;
            }
            if(nivel+qual>=6){
                this.tipo=qual;
                this.bonus_defesa=PartesDefesa[qual-1];
                this.bonus_agilidade=PartesAgilidade[qual-1];
                this.bonus_sorte=rand.nextInt();
                break;
            }else
                System.out.println("Não possui nivel minimo para esta armadura!\nEscolha outra!");
        }while(true);
    }
    
    public void aumentarDefesa(int aumenta){
            bonus_defesa+=aumenta;
    }
    
    public int getDefesa (){
        return this.bonus_defesa;
    }
    
    public int getAgilidade (){
        return this.bonus_agilidade;
    }
    
    public int getSorte (){
        return this.bonus_sorte;
    }
    
    public int getTipo (){
        return this.tipo;
    }
}
