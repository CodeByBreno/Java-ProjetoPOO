
package Citys;

import Adicionais.Combate;
import Characters.Mob;
import Adicionais.NPC;
import Characters.Player;
import Quests.Quest;
import java.util.List;
import java.util.Scanner;

public class Cidade {
    String nome;
    List<Quest> quests;
    List<NPC> npcs;
    
    public String getNome() {
        return nome;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    //método que executa a primeira missão
    //método que executa a segunda missão
    //método que executa a terceira missão
    public List<NPC> getNpcs() {
        return npcs;
    }

    public Cidade(String nome, List<Quest> quests, List<NPC> npcs) {
        this.nome = nome;
        this.quests = quests;
        this.npcs = npcs;
    }
    
    public int menu(Player p, String cidade_anterior, String proxima_cidade){
        Scanner ler = new Scanner (System.in);
        int i, o;
        
        while(true){
            System.out.printf("\nVocê está em %s\n", this.nome);
            if(cidade_anterior.length() != 0)
                System.out.printf("0 - ir para %s\n", cidade_anterior);
//            System.out.println("1 - mexer na mochila\n");
            for(i = 0; i < npcs.size(); i++)
                System.out.printf("%d - ir falar com %s\n", i + 1, npcs.get(i).getNome());
            for(i = 0; i < quests.size(); i++){
                System.out.printf("%d - atacar %s ", i + npcs.size() + 1, quests.get(i).getMob().getNome());
                if(quests.get(i).concluido() == false){
                    System.out.printf("(Você matou %d de %d)\n", quests.get(i).getQtd(), quests.get(i).getobjetivo());
                    break;
                }else{
                    System.out.printf("(Missão concluida, você já matou %d)\n", quests.get(i).getQtd());
                }
            }

            if(i == quests.size()){
                System.out.printf("%d - ir para %s\n", npcs.size() + quests.size() + 1, proxima_cidade);
            }
            o = ler.nextInt();
            if(o < 0)
                continue;
            if(o == 0){
                if(cidade_anterior.length() != 0)
                    return -1;
                continue;
            }
//            if(--o == 0){mexer na mochila
//                
//                continue;
//            }
            if(--o < npcs.size()){
                npcs.get(o).falar(p);
                continue;
            }
            o -= npcs.size();
            if(o < quests.size() && o <= i){
                Combate c = new Combate(p, quests.get(o).getMob());
                if(c.iniciar_Combate())
                    if(quests.get(o).ganhou())
                        p.GanharExperiencia(quests.get(o).getExp_bonus());
                continue;
            }
            if(o == i){
                return 1;
            }
        }
    }
}
