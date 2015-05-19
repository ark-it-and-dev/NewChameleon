package WebService;

import EJB.ClienteFacadeLocal;
import Model.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@WebService(serviceName = "ClienteWS")
@Stateless()
public class ClienteWS {

    @EJB
    private ClienteFacadeLocal clienteDAO;

    private String retorno;

    @PersistenceContext(unitName = "ChameleonEJB_PU")

    @WebMethod(operationName = "getConsumerByEmail")
    public String getConsumerByEmail(@WebParam(name = "email") String email) {
        retorno = "";
        return retorno;
    }
}
