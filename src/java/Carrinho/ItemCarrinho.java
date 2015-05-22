package Carrinho;

//import br.com.ChameleonEJB.Model.Produto;

import Model.Produto;


public class ItemCarrinho {

    private final Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto product) {
        this.produto = product;
        quantidade = 1;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void incrementaQuantidade() {
        quantidade++;
    }

    public void decrementaQuantidade() {
        quantidade--;
    }

    public double getTotal() {
        return this.getQuantidade() * produto.getPreco().doubleValue();
    }
}
