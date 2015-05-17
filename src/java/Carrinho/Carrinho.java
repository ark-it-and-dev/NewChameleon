package Carrinho;

//import br.com.ChameleonEJB.Model.Produto;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
/*
    List<ItemCarrinho> itens;
    int totalItens;
    double total;

    public Carrinho() {
        itens = new ArrayList<>();
        totalItens = 0;
        total = 0;
    }

    public void addItem(Produto produto) {
        boolean novoItem = true;

        //Percorre toda a lista de produtos
        for (ItemCarrinho itemCarrinho : itens) {
            //Se o produto já existe, incrementa a quantidade
            if (itemCarrinho.getProduto().getId() == produto.getId()) {
                novoItem = false;
                itemCarrinho.incrementaQuantidade();
            }
        }

        //Se o produto não existe, acrescenta na lista
        if (novoItem) {
            ItemCarrinho item = new ItemCarrinho(produto);
            itens.add(item);
        }
    }

    public void update(Produto produto, int quantidade) {

        if (quantidade >= 0) {
            //Percorre todo a lista de produtos
            for (ItemCarrinho itemCarrinho : itens) {
                //Se o produto existe...
                if (itemCarrinho.getProduto().getId() == produto.getId()) {
                    //...e a quandidade não for 0, atualiza a quantidade
                    if (quantidade != 0) {
                        itemCarrinho.setQuantidade(quantidade);
                    } else {
                        //... e a quantidade for zero, remove o item
                        itens.remove(itemCarrinho);
                        break;
                    }
                }
            }
        }
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public int getTotalItens() {
        totalItens = 0;
        //Percorre todos os itens e conta as quantidades
        for (ItemCarrinho itemCarrinho : itens) {
            totalItens += itemCarrinho.getQuantidade();
        }
        return totalItens;
    }

    public double getSubtotal() {
        double valor = 0;
        //Percorre todos os itens e soma os valores totais
        for (ItemCarrinho itemCarrinho : itens) {
            Produto produto = itemCarrinho.getProduto();
            valor += (itemCarrinho.getQuantidade() * produto.getPreco().doubleValue());
        }
        return valor;
    }

    public void calcularTotal(double desconto) {
        double valor = this.getSubtotal() - desconto;
        total = valor;
    }

    public double getTotal() {
        return total;
    }

    public void esvaziar() {
        itens.clear();
        totalItens = 0;
        total = 0;
    }
*/
}
