package Bean;

import Carrinho.Carrinho;
import Carrinho.ItemCarrinho;
import EJB.PedidoFacadeLocal;
import EJB.ProdutoFacadeLocal;
import Model.Cliente;
import Model.Endereco;
import Model.Pedido;
import Model.Pedidoproduto;
import Model.StatusPedido;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class PedidoBean {

    private Carrinho carrinho = new Carrinho();
    private Cliente cliente = new Cliente();
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    @EJB
    private ProdutoFacadeLocal ejb;

    @EJB
    private PedidoFacadeLocal ejbPed;

    @PostConstruct
    public void inicializar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

        if (session.getAttribute("CART") != null) {
            carrinho = (Carrinho) session.getAttribute("CART");
        } else {

        }

        if (session.getAttribute("USER") != null) {
            cliente = (Cliente) session.getAttribute("USER");
        } else {

        }

    }

    public Cliente getCliente() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

        if (session.getAttribute("USER") != null) {
            cliente = (Cliente) session.getAttribute("USER");
            return cliente;
        } else {
            return new Cliente();
        }
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void addItem(int prod_id) {
        carrinho.addItem(ejb.find(BigDecimal.valueOf(prod_id)));
    }

    public String confirmarEndereco(Endereco end) {
        this.endereco = end;
        return "confirmacaoPedido";
    }

    public String criarPedido() {
        try {
            Pedido pedido = new Pedido();
            Pedidoproduto pp = new Pedidoproduto();
            List<Pedidoproduto> lpp = new ArrayList<>();
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

            pedido.setStatus(StatusPedido.N);

            carrinho = (Carrinho) session.getAttribute("CART");
            pedido.setValortotal(BigDecimal.valueOf(carrinho.getSubtotal()));

            for (ItemCarrinho itens : carrinho.getItens()) {
                pp.setProdutoId(itens.getProduto());
                pp.setQuantidade(BigInteger.valueOf(itens.getQuantidade()));
                pp.setPedidoId(pedido);
                lpp.add(pp);
            }

            pedido.setPedidoprodutoCollection(lpp);

            cliente = (Cliente) session.getAttribute("USER");
            pedido.setClienteId(cliente);

            ejbPed.create(pedido);

            String message = "Pedido criado com sucesso!";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));

            return "index";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
