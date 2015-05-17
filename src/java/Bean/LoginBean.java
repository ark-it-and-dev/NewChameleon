package Bean;

import br.metodista.ejb.ClienteRemote;
import br.metodista.modelo.Cliente;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LoginBean {

    @EJB
    private ClienteRemote ejb;

    Cliente cliente = new Cliente();
    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String entrar() {
        if (login.equals("admin") && senha.equals("admin")) {
            return "admin";
        } else {
            try {
                cliente = ejb.consultarPorEmail(login);
                if (cliente.getSenha().equals(senha)) {
                    //criar carrinho
                    return "carrinho";
                } else {
                    String message = "Senha incorreta";
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
                    return null;
                }
            } catch (Exception e) {
                String message = "Não foi possível efetuar o login. Erro:" + e.getMessage();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));

                return null;
            }
        }
    }

}
