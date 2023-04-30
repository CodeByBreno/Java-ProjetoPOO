
package Adicionais;
import java.util.Scanner;
import Characters.Player;
import Characters.Mob;
import java.util.Random;

public class Combate {
    Player atacante;
    Mob atacado;
    
    public Combate(Player a, Mob b){
        this.atacante = a;
        this.atacado = b;
        this.atacante.ResetStatus();
        this.atacado.ResetStatus();
    }
    
    public boolean iniciar_Combate(){
        System.out.println("\nIniciando o combate");
        //TESTE
        if(atacante.getNome().equals("Teste")){
            System.out.println("Teste ativado!");
            atacado.setHpTotal(0);
        }
        this.atacante.Status();
        System.out.println();
        this.atacado.Status();
        
        while (atacante.getHpTotal() > 0 && atacado.getHpTotal() > 0){
            //round do atacante
            Scanner ler = new Scanner(System.in);
            int selecionado = 0;
            while(selecionado <= 0){
                System.out.println("\nEscolha uma ação: \n" +
                                   "1 - Atacar\n" + 
                                   "2 - Usar Item\n" + 
                                   "3 - Usar Habilidade\n" + 
                                   "4 - Fugir");
                selecionado = ler.nextInt();
                switch (selecionado){
                    case 1: {
                        atacante.atacar(atacado);
                        break;
                    }
                    case 2: {
                        if(atacante.UsarItem() == false)
                            selecionado = 0;
                        break;
                    }
                    case 3: {
                        atacante.atualizarCombate();
                        do {
                                System.out.println("\nEscolha a habilidade:\n"+
                                                "0 - Voltar\n"+
                                                atacante.descreverHab());
                                selecionado = ler.nextInt();
                                if(selecionado == 0)
                                        break;
                        }while(!atacante.usarHabilidade(atacado, selecionado));
                        break;
                    }
                    case 4: {
                        Random aleat = new Random ();
                        int dado1 = aleat.nextInt(atacante.getSorte());
                        int dado2 = aleat.nextInt(atacado.getSorte());
                        if (dado1*atacante.getAgilidade() > dado2*atacado.getAgilidade()){
                            System.out.println("\nConseguiu fugir\n");
                        }
                        else System.out.println("\nNão conseguiu fugir!\n");
                        break;
                    }
                 }
             }
            //round do atacado
            
            this.atacado.atacar(atacante);
            
            System.out.println();
            this.atacante.FastStatus();
            this.atacado.FastStatus();
        }
        if(atacante.getHpTotal() > 0){
            System.out.printf("\n%s ganhou o combate\n", atacante.getNome());
            this.atacante.GanharExperiencia(this.atacado.getExperiencia());
            this.atacante.GanharOuro(this.atacado.getOuro());
            return true;
        }
        System.out.printf("\n%s ganhou o combate\n", atacado.getNome());
        return false;
    }
}
