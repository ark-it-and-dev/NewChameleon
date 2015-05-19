package WebService;

import EJB.ProdutoFacadeLocal;
import Model.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@WebService(serviceName = "ProdutoWS")
@Stateless()
public class ProdutoWS {

    @EJB
    private ProdutoFacadeLocal dao;
    private String retorno;

    @PersistenceContext(unitName = "ChameleonEJB_PU")

    @WebMethod(operationName = "all")
    public String all() {
        retorno = "";

        try {
            List<Produto> listaProdutos = dao.findAll();
            retorno += "\n-----Produtos------";
            for (Produto produto : listaProdutos) {
                retorno += "\nID Produto: " + produto.getId();
                retorno += "\nNome: " + produto.getNome();
                retorno += "\nPreco: " + produto.getPreco();
                retorno += "\nDescricao: " + produto.getDescricao();
                retorno += "\nMarca: " + produto.getMarca();
                retorno += "\nStatus: " + produto.getStatus();
                retorno += "\n\n\n";
            }
            retorno += "\n---------------";
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return retorno;
    }
}
