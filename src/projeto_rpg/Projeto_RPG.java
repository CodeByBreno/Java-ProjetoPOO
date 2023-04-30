
package projeto_rpg;

import Characters.Mob;
import Adicionais.NPC;
import Characters.Player;
import Citys.Cidade;
import Itens.Armas;
import Itens.Equipamentos;
import Itens.Itens;
import Itens.Usaveis;
import Quests.Quest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Projeto_RPG {
    
    public static void jogar(){
        
        //Lista com todas as quests
        List<Quest> quests = new ArrayList();
        //Mob(String Nome, int Hp, int Dano, int Defesa, int Crítico, int Sorte, int Agilidade, int exp_recomp, int ouro_recomp)
        //quests.add(new Quest(new Mob("Mob teste", 1, 1, 1, 1, 1, 1, 1000, 1000), 5, 10));
        quests.add(new Quest(new Mob("Mob 1",  10,  2, 1, 1, 2, 2,  1,  1), 3, 10));
        quests.add(new Quest(new Mob("Mob 2",  20,  5, 2, 2, 4, 4,  3,  3), 3, 20));
        quests.add(new Quest(new Mob("Mob 3",  40, 10, 4, 3, 6, 6,  5,  5), 3, 30));
        quests.add(new Quest(new Mob("Mob 4",  50, 12, 5, 4, 8, 8, 10, 10), 3, 40));
        quests.add(new Quest(new Mob("Mob 5", 100, 20, 7, 5,10,10, 30, 30), 3, 50));
        quests.add(new Quest(new Mob("Mob 6", 200, 35,10, 6,12,12, 50, 50), 3, 60));
        quests.add(new Quest(new Mob("Mob 7", 300, 50,15, 7,14,14,100,100), 3, 40));
        quests.add(new Quest(new Mob("Mob 8", 600, 75,25, 8,16,16,200,200), 3, 50));
        quests.add(new Quest(new Mob("Mob 9",1000,100,40, 9,18,18,400,400), 3, 60));
        
        //Lista com todos os itenas
        List<Itens> itens = new ArrayList();
        // Armas(int Dano, String Nome, int preco, int nivel)
        // Equipamentos(int bonus_defesa, int bonus_agilidade, int bonus_sorte, int tipo, String Nome, int preco, int nivel)
        //1-Peitoral 2-Capacete 3-Calças 4-Luvas 5-Adicional
        // Usaveis(int tipo, int valor, String Nome, int preco, int nivel) 1 Mais Vida 2 Mais Ataque 3 Mais defesa
        itens.add(new Armas(10, "Espada de madeira", 5, 1));
        itens.add(new Equipamentos(5, 0, 0, 1, "Peitorau de couro", 20, 2));
        itens.add(new Equipamentos(1, 0, 0, 2, "capacete de couro", 5, 2));
        itens.add(new Equipamentos(2, 3, 0, 3, "Calça de couro", 15, 3));
        itens.add(new Equipamentos(1, 1, 0, 4, "Luvas de pano", 5, 3));
        itens.add(new Equipamentos(0, 0, 3, 5, "Trevo de 4 folhas", 5, 3));
        itens.add(new Usaveis(1, 5, "Poção de cura 1", 2, 1));
        itens.add(new Usaveis(2, 2, "Poção de ataque 1", 2, 2));
        itens.add(new Usaveis(3, 2, "Poção de defesa 1", 2, 3));
        
        itens.add(new Armas(20, "Espada de ferro", 30, 4));
        itens.add(new Equipamentos(10, 0, 0, 1, "Peitorau de ferro", 60, 5));
        itens.add(new Equipamentos(2, 0, 0, 2, "capacete de ferro", 30, 5));
        itens.add(new Equipamentos(4, 6, 0, 3, "Calça de ferro", 40, 6));
        itens.add(new Equipamentos(2, 2, 0, 4, "Luvas de ferro", 30, 6));
        itens.add(new Equipamentos(0, 0, 6, 5, "Ferradura", 20, 6));
        itens.add(new Usaveis(1, 30, "Poção de cura 2", 20, 4));
        itens.add(new Usaveis(2, 5, "Poção de ataque 2", 20, 5));
        itens.add(new Usaveis(3, 5, "Poção de defesa 2", 20, 6));
        
        itens.add(new Armas(30, "Espada de ouro", 100, 7));
        itens.add(new Equipamentos(20, 0, 0, 1, "Peitorau de ouro", 200, 8));
        itens.add(new Equipamentos(4, 0, 0, 2, "capacete de ouro", 100, 8));
        itens.add(new Equipamentos(8, 12, 0, 3, "Calça de ouro", 120, 9));
        itens.add(new Equipamentos(4, 4, 0, 4, "Luvas de ouro", 100, 9));
        itens.add(new Equipamentos(0, 0, 12, 5, "Pé de coelho", 80, 9));
        itens.add(new Usaveis(1, 100, "Poção de cura 3", 200, 7));
        itens.add(new Usaveis(2, 15, "Poção de ataque 3", 200, 8));
        itens.add(new Usaveis(3, 15, "Poção de defesa 3", 200, 9));
        
        //Lista com todos os npcs
        List<NPC> npcs = new ArrayList();
        npcs.add(new NPC("NPC 1", "Seja bem vindo a cidade! eu posso te vender uns equipamentos básicos para seu inicio de jornada!", itens.subList(0, 6)));
        npcs.add(new NPC("NPC 2", "Seja bem vindo a cidade! eu posso te vender algumas porções!", itens.subList(6, 9)));
        
        npcs.add(new NPC("NPC 3", "Seja bem vindo a cidade! eu posso te vender uns equipamentos melhores para você contiuar sua jornada!", itens.subList(9, 15)));
        npcs.add(new NPC("NPC 4", "Seja bem vindo a cidade! eu posso te vender algumas porções melhores!", itens.subList(15, 18)));
        
        npcs.add(new NPC("NPC 5", "Seja bem vindo a cidade! eu posso te vender uns equipamentos ainda melhores para você contiuar sua jornada!", itens.subList(18, 24)));
        npcs.add(new NPC("NPC 6", "Seja bem vindo a cidade! eu posso te vender algumas porções ainda melhores!", itens.subList(24, 27)));
        
        //Lista com todas as cidades
        List<Cidade> cidades = new ArrayList(); 
        cidades.add(new Cidade("Cidade 1", quests.subList(0, 3), npcs.subList(0, 2)));
        cidades.add(new Cidade("Cidade 2", quests.subList(3, 6), npcs.subList(2, 4)));
        cidades.add(new Cidade("Cidade 3", quests.subList(6, 9), npcs.subList(4, 6)));
        
        Player p = new Player();
        int cidade_atual = 0, i;
        
        while(cidade_atual < cidades.size()){
            i = cidades.get(cidade_atual).menu(p, cidade_atual == 0 ? "" : cidades.get(cidade_atual-1).getNome(), cidade_atual + 1 == cidades.size() ? "Terminar Jogo" : cidades.get(cidade_atual+1).getNome());
            if(i == 1){
                if(++cidade_atual == cidades.size()){
                    System.out.println("Parabéns " + p.getNome() + "!!, Voce zerou o jogo\n");
                    return;
                }
            }else if(i == -1){
                cidade_atual--;
            }
        }
    }
    
    public static void ajuda(){
        System.out.println("Olá aventureiro!!\nVocê precisará passar por várias cidades cumprindo missões e comprando itens com NPCs\n");
    }
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int selecionado = 0;
        System.out.println("\nseja Bem vindo ao jogo de RPG!!");
        while(selecionado != 3) {
            System.out.println("\nEscolha uma opção:\n" +
                    "1 - Jogar\n" +
                    "2 - Ajuda\n" +
                    "3 - Sair");
            selecionado = ler.nextInt();
            switch (selecionado) {
                case 1:
                    jogar();
                    break;
                case 2:
                    ajuda();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
        System.out.println("Obrigado por jogar\nVolte sempre!");
    }
}
