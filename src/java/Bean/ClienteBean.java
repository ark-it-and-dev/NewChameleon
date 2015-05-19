package Bean;

import EJB.ClienteFacadeLocal;
import Model.Cliente;
import Model.SexoCliente;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
public class ClienteBean {

    @EJB
    ClienteFacadeLocal ejb;
    private Cliente cliente = new Cliente();
    private String senhaConf;

    public String getSenhaConf() {
        return senhaConf;
    }

    public void setSenhaConf(String senhaConf) {
        this.senhaConf = senhaConf;
    }

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

    public void adicionarCliente() {
        try {
            ejb.create(cliente);
            String message = "Cliente adicionado com sucesso!";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
            clear();
        } catch (Exception e) {
            String message = "Não foi possível adicionar o cliente. Erro: " + e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
        }
    }

    public void clear() {
        cliente = new Cliente();
    }
}
