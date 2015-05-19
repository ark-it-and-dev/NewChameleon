package Bean;

import EJB.EnderecoFacadeLocal;
import Model.Endereco;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class EnderecoBean {

    @EJB
    EnderecoFacadeLocal ejb;

    private Endereco endereco = new Endereco();

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String editarEndereco(Endereco endereco) {
        if (endereco != null) {
            this.endereco = endereco;
            return "cadastroEndereco";
        } else {
            return null;
        }
    }

    public void salvarEndereco() {
        try {
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
