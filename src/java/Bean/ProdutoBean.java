package Bean;

import businessObjects.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoBean {

    Produto produto = new Produto();
    List<Produto> listaProdutos = new ArrayList<>();

    public ProdutoBean() {
        Produto prod = new Produto();
        prod.setNome("Biscoito");
        prod.setMarca("Trakinas");
        prod.setPreco(10.02);
        prod.setDescricao("Biscoito de chocolate Trakinas");
        listaProdutos.add(prod);

        prod = new Produto();
        prod.setNome("Chocolate");
        prod.setMarca("Bis");
        prod.setPreco(4.25);
        prod.setDescricao("Caixa de chocolate Bis");
        listaProdutos.add(prod);

        prod = new Produto();
        prod.setNome("Achocolatado");
        prod.setMarca("Toddy");
        prod.setPreco(25.00);
        prod.setDescricao("Achocolatado Toddy");
        listaProdutos.add(prod);

        prod = new Produto();
        prod.setNome("Biscoito");
        prod.setMarca("Cream Cracker");
        prod.setPreco(6.50);
        prod.setDescricao("Biscoito Cream Cracker");
        listaProdutos.add(prod);

        prod = new Produto();
        prod.setNome("Creme de chocolate");
        prod.setMarca("Nutella");
        prod.setPreco(49.99);
        prod.setDescricao("Creme de chocolate Nutella");
        listaProdutos.add(prod);
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public void adicionarProduto() {
        listaProdutos.add(produto);
    }
    
    public void removerProduto(Produto p){
        listaProdutos.remove(p);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }    
}
