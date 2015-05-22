package Bean;

import EJB.ClienteFacadeLocal;
import EJB.EnderecoFacadeLocal;
import Model.Cliente;
import Model.Endereco;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class EnderecoBean {

    @EJB
    EnderecoFacadeLocal ejb;
    @EJB
    ClienteFacadeLocal ejbCli;

    private Endereco endereco = new Endereco();

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String editarEndereco(Endereco endereco) {
        if (endereco != null) {
            this.setEndereco(endereco);
            return "cadastroEndereco";
        } else {
            return null;
        }
    }

    public void salvarEndereco() {
        try {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, endereco.toString(), null));
            
            
            ejb.create(endereco);
            String message = "Endereço adicionado com sucesso!";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            String message = "Não foi possível adicionar o endereço. Erro: " + e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
        }
    }

    private void clear() {
        endereco = new Endereco();
    }

}
