package Bean;

import EJB.ProdutoFacadeLocal;
import Model.Produto;
import Model.StatusProduto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ProdutoBean {

    private Produto produto = new Produto();
    private List<Produto> listaProdutos = new ArrayList();

    @EJB
    private ProdutoFacadeLocal ejb;

    public List<Produto> getListaProdutos() {
        //listaProdutos = ejb.consultarTodos();

        Produto pp = new Produto();
        pp.setDescricao("desc1");
        pp.setMarca("mrk1");
        pp.setNome("nome1");
        pp.setPreco(BigDecimal.valueOf(11.00));
        pp.setStatus(StatusProduto.D);
        listaProdutos.add(pp);

        pp = new Produto();
        pp.setDescricao("desc2");
        pp.setMarca("mrk2");
        pp.setNome("nome2");
        pp.setPreco(BigDecimal.valueOf(12.00));
        pp.setStatus(StatusProduto.D);
        listaProdutos.add(pp);

        pp = new Produto();
        pp.setDescricao("desc3");
        pp.setMarca("mrk3");
        pp.setNome("nome3");
        pp.setPreco(BigDecimal.valueOf(13.00));
        pp.setStatus(StatusProduto.I);
        listaProdutos.add(pp);

        pp = new Produto();
        pp.setDescricao("desc4");
        pp.setMarca("mrk5");
        pp.setNome("nome5");
        pp.setPreco(BigDecimal.valueOf(14.00));
        pp.setStatus(StatusProduto.I);
        listaProdutos.add(pp);

        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public void adicionarProduto() throws Exception {
        try {
            ejb.create(produto);
            String message = "Produto adicionado com sucesso!";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
            clear();
        } catch (Exception e) {
            String message = "Não foi possível adicionar o produto. Erro: " + e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    /*
     public SelectItem[] getStatusProduto() {
     SelectItem[] items = new SelectItem[StatusProduto.values().length];
     int i = 0;
     for (StatusProduto s : StatusProduto.values()) {
     items[i++] = new SelectItem(s, s.getLabel());
     }
     return items;
     }
     */

    public void clear() {
        produto = new Produto();
    }

    public String editarProduto(Produto produto) {
        if (produto != null) {
            this.setProduto(produto);
            return "cadastroProduto";
        } else {
            return null;
        }
    }
}
