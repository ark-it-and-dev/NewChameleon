/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Fernando Benitez
 */
@ManagedBean
public class LoginBean {

    private String login;
    private String senha;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void Entrar() {
        String a = getLogin();
        String b = getSenha();

        if (a.equals("admin") && b.equals("admin")) {
            
        }
    }

}
