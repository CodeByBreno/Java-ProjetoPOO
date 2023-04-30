
package Adicionais;

import Itens.Itens;
import java.util.List;
import java.util.Scanner;
import Itens.Armas;
import Itens.Equipamentos;
import Itens.Usaveis;
import Characters.Player;

public class NPC {
    String nome;
    String fala;
    List<Itens> itens;
    Scanner io = new Scanner(System.in);

    public NPC(String nome, String fala, List<Itens> itens) {
        this.nome = nome;
        this.fala = fala;
        this.itens = itens;
    }

    public String getNome() {
        return nome;
    }
    
    public void falar(Player p) {
        int o;
        System.out.printf("\nOlá %s, meu nome é %s. ", p.getNome(), this.nome);
        System.out.println(this.fala);
        while(true){
            System.out.println("Deseja comprar algo:\n1- Sim\n2- Não");
            o = io.nextInt();
            if(o == 1)
                comprar(p);
            return;
        }
    }
    
    private void comprar(Player p){
        int i;
        while(true){
            System.out.printf("\nEscolha o item: (Você tem %d de ouro e nível %d)\n", p.getOuro(), p.getNivel());
            System.out.println("0 - Sair");
            for(i = 0; i < itens.size(); i++){
                System.out.printf("%d - ", i + 1);
                itens.get(i).mostrar();
            }
            i = io.nextInt();
            if(i-- == 0)
                return;
            if(i >= 0 && i < itens.size()){
                if(p.getOuro() < itens.get(i).getPreco()){
                    System.out.println("Não possui ouro suficiente para esta compra");
                    continue;
                }
                if(p.getNivel() < itens.get(i).getNivel()){
                    System.out.println("Não possui nivel suficiente para esta compra");
                    continue;
                }
                if(p.Equipar(itens.get(i)) == false){
                    System.out.println("Não foi possivel guardar o item, compra cancelada");
                    continue;
                }
                p.GanharOuro(-itens.get(i).getPreco());
                System.out.printf("\nVocê comprou um '%s'\n", itens.get(i).getNome());
            }
        }
    }

//    private void comprar_gleice(Player P) {
//        int opcao;
//        int aux;
//        //variaveis q removi dos parametros
//        int ouro = P.getOuro();
//        int nivel = P.getNivel();
//        do{
//            System.out.println("MERCADO: ");
//            System.out.println("Deseja Comprar: \n[1] - Armas - Valor: 5  \n[2] - Armaduras - Valor: 10 por unidade \n[3] - Usaveis - Valor: 7 por unidade\n[4] - Sair");
//        
//            opcao=io.nextInt();
//            switch(opcao){
//                case 1:
//                    if (ouro>=5){
//                        if(nivel >= 2){
//                            Armas A = new Armas();
//                            A.comprarArma(nivel);
//                            P.Equipar(A); 
//                            aux=P.getOuro()-5;
//                            P.setOuro(aux);
//                        }else
//                                System.out.println("Não possui nivel suficiente para esta compra\nEscolha outra opção: ");
//                    }else
//                        System.out.println("Não possui ouro suficiente para esta compra\nEscolha outra opção: ");
//                    
//                break;
//                case 2:
//                    if (ouro>=10){
//                        Equipamentos E = new Equipamentos(nivel);
//                        E.comprarEquipamento(nivel);
//                        P.Equipar(E);
//                        aux=P.getOuro()-10;
//                        P.setOuro(aux);
//                    }else
//                        System.out.println("Não possui ouro suficiente para esta compra\nEscolha outra opção: ");
//                break;
//                case 3:
//                    if (ouro>=7){
//                        Usaveis U = new Usaveis();
//                        P.GuardarItem(U);
//                        aux=P.getOuro()-7;
//                        P.setOuro(aux);
//                    }else
//                        System.out.println("Não possui ouro suficiente para esta compra\nEscolha outra opção: ");
//                break;
//                case 4: return;
//                default:
//                    System.out.println("Opção Inválida!\nDigite outra opcao");
//            }
//        }while(opcao!=4);
//    }
}
