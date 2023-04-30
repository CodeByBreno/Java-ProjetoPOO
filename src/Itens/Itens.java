
package Itens;

public abstract class Itens {
    String Nome;
    int preco;
    int nivel;

    public Itens() {
    }

    public Itens(String Nome, int preco, int nivel) {
        this.Nome = Nome;
        this.preco = preco;
        this.nivel = nivel;
    }

    public int getPreco() {
        return preco;
    }

    public int getNivel() {
        return nivel;
    }
    
    abstract public void mostrar();
    
    public String getNome(){
        return (this.Nome);
    }
}
