package Bean;

import EJB.ClienteFacadeLocal;
import Model.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LoginBean {

    @EJB
    private ClienteFacadeLocal ejb;

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
                boolean isValid = false;
                List<Cliente> lc = ejb.findAll();
                for (Cliente c : lc) {
                    if (c.getSenha().equals(senha)) {
                        isValid = true;
                        break;
                    }
                }
                if (isValid) {
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
