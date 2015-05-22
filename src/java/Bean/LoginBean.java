package Bean;

import Carrinho.Carrinho;
import EJB.ClienteFacadeLocal;
import Model.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class LoginBean {

    @EJB
    private ClienteFacadeLocal ejb;

    Cliente cliente = new Cliente();
    Carrinho carrinho = new Carrinho();
    private String login;
    private String senha;

    private FacesContext fc;
    private HttpSession session;

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
        fc = FacesContext.getCurrentInstance();
        session = (HttpSession) fc.getExternalContext().getSession(true);

        //verifica se o usuario é admin
        if (login.equals("admin") && senha.equals("admin")) {
            return "templateAdmin";
        } else {
            try {
                boolean isValid = false;
                List<Cliente> lc = ejb.findAll();
                for (Cliente c : lc) {
                    if (c.getSenha().equals(senha)) {
                        cliente = c;
                        isValid = true;
                        break;
                    }
                }
                if (isValid) {
                    //login efetuado
                    if (session.getAttribute("USER") == null) {
                        session.setAttribute("USER", cliente);

                    }
                    if (session.getAttribute("CART") == null) {
                        session.setAttribute("CART", carrinho);
                    }

                    return "carrinho";
                } else {
                    //login incorreto
                    String message = "Senha incorreta";
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
                    return null;
                }
            } catch (Exception e) {
                //erro no login
                String message = "Não foi possível efetuar o login. Erro:" + e.getMessage();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));

                return null;
            }
        }
    }

    public String logout() {
        fc = FacesContext.getCurrentInstance();
        session = (HttpSession) fc.getExternalContext().getSession(true);
        session.invalidate();
        return "index";
    }
}
