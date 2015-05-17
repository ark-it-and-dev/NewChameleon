package Bean;

import br.metodista.ejb.ClienteRemote;
import br.metodista.modelo.Cliente;
import br.metodista.modelo.SexoCliente;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean
public class ClienteBean {

    @EJB
    ClienteRemote ejb;
    private Cliente cliente = new Cliente();

    public ClienteBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public SelectItem[] getSexoCliente() {
        SelectItem[] items = new SelectItem[SexoCliente.values().length];
        int i = 0;
        for (SexoCliente s : SexoCliente.values()) {
            items[i++] = new SelectItem(s, s.getLabel());
        }
        return items;
    }
}
