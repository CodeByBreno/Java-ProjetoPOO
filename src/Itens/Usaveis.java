
package Itens;
import Characters.Player;
import Characters.Mob;
import java.util.Scanner;
import Itens.Equipamentos;

public class Usaveis extends Itens{
    /* Tabela de Usáveis:
    1- Mais Vida   - Aumenta quantidade de Vida 
    2- Mais Ataque - Aumenta o ataque           
    3- Mais Defesa - Aumenta a defesa           
    */
    int tipo;
    int valor;
    int quantidade;
    Scanner io = new Scanner(System.in);

    public int getQuantidade() {
        return quantidade;
    }

    public Usaveis(int tipo, int valor, String Nome, int preco, int nivel) {
        super(Nome, preco, nivel);
        this.tipo = tipo;
        this.valor = valor;
        this.quantidade = 0;
    }
    
    public void AplicarBenefícios(Player P){
        switch(this.tipo){
            case 1: 
                P.maisVida(valor);
            break;
            case 2:
                P.maisDano(valor);
            break;
            case 3:
                P.maisDefesa(valor);
            break;
        }
    }

    public void mostrar() {
        System.out.printf("Usavel '%s' custa %d: Aumenta ", this.Nome, this.preco);
        switch(tipo){
            case 1: 
                System.out.printf("vida em ");
                break;
            case 2:
                System.out.printf("dano em ");
                break;
            case 3:
                System.out.printf("defesa em ");
                break;
        }
        System.out.printf("%d\n\tQuantidade %d | Nivel minimo %d\n", this.valor, this.quantidade, this.nivel);
    }

    public void setQuantidade(int i) {
        this.quantidade = i;
    }

    public void AumentarQuant() {
        this.quantidade++;
    }

    public void usar() {
        this.quantidade--; //Quando acabar remover o item;
    }
}