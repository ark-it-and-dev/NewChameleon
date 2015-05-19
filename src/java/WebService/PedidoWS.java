package WebService;

import EJB.PedidoFacadeLocal;
import Model.Pedido;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@WebService(serviceName = "PedidoWS")
@Stateless()
public class PedidoWS {

    @EJB
    private PedidoFacadeLocal pedidoDAO;
    private String retorno;

    @PersistenceContext(unitName = "ChameleonEJB_PU")

    @WebMethod(operationName = "allOrders")
    public String allOrders() {
        retorno = "";

        try {
            List<Pedido> listaPedidos = pedidoDAO.findAll();
            retorno += "\n-----Pedidos------";
            for (Pedido pedido : listaPedidos) {
                retorno += "\nID Pedido: " + pedido.getId();
                retorno += "\nID Cliente: " + pedido.getId();
                retorno += "\nStatus: " + pedido.getStatus();
                retorno += "\n---------------";
                retorno += "\nValor Total: R$" + pedido.getValortotal();
                retorno += "\n\n\n";
            }
            retorno += "\n---------------";
        } catch (Exception ex) {
            ex.printStackTrace(); //Erro ao converter as datas.
        }
        return retorno;
    }
}
