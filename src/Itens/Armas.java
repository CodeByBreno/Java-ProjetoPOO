package Itens;

import java.util.Scanner;

public class Armas extends Itens{
    /* Tabela de Armas:  
    2- Browing M2 - Dano: 7 - Nível minimo: 4  
    3- AK 47      - Dano: 5 - Nível minimo: 3 
    4- Taurus 38  - Dano: 3 - Nível minimo: 2     
    */
    int Dano;
    int tipo;
    int ValoresDanos[] = {7,5,3}; 
    Scanner io = new Scanner(System.in);

    public Armas(int Dano, String Nome, int preco, int nivel) {
        super(Nome, preco, nivel);
        this.Dano = Dano;
    }
    
    public void mostrar(){
        System.out.printf("Arma '%s' custa %d\n\tDano %d | Nivel minimo %d\n", this.Nome, this.preco, this.Dano, this.nivel, this.nivel);
    }
    
    public void comprarArma(int nivel){
        System.out.println("Digite a Arma que deseja comprar\n");
        System.out.println("[1] - Browing M2 - Dano: 7 - Nível minimo: 4");
        System.out.println("[2] - AK 47      - Dano: 5 - Nível minimo: 3");
        System.out.println("[3] - Taurus 38  - Dano: 3 - Nível minimo: 2");
        do{
            this.tipo=io.nextInt();
            if(this.tipo < 1 || this.tipo > 3){
                System.out.println("Opção Inválida!\nDigite outra opcao");
                continue;
            }
            if (this.tipo+nivel>=5){
                this.Dano=ValoresDanos[tipo-1];
                break;
            }else
                System.out.println("Nao possui nivel minimo.\nEscolha outra arma.");
              
        }while(true);
    }
    public int getDano (){
        return this.Dano;
    }
}
