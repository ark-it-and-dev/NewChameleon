package Bean;

import javax.faces.bean.ManagedBean;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ManagedBean
public class ContatoBean {

    private String console;
    private String nome;
    private String email;
    private String telefone;
    private String mensagem;

    public void enviar() {

        //Parâmetros de conexão com servidor Gmail
        Properties propriedades = new Properties();
        propriedades.put("mail.smtp.host", "smtp.gmail.com");
        propriedades.put("mail.smtp.socketFactory.port", "465");
        propriedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        propriedades.put("mail.smtp.auth", "true");
        propriedades.put("mail.smtp.port", "465");

        Session sessao = Session.getInstance(
                propriedades,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "ark.it.and.dev@gmail.com",
                                "ArkAds123");
                    }
                });

        sessao.setDebug(true);

        //cria a mensagem
        try {
            Message messagem = new MimeMessage(sessao);
            messagem.setFrom(new InternetAddress(this.getEmail()));
            //Remetente
            Address[] destinatario = InternetAddress.parse("ark.it.and.dev@gmail.com");
            //Destinarário
            messagem.setRecipients(Message.RecipientType.TO, destinatario);
            //Assunto
            messagem.setSubject("Fale Conosco: E-mail do usuário " + this.getNome());
            //Mensagem
            messagem.setText(
                    "Um usuário entrou em contato conosco!\n\n"
                    + "Assunto: " + this.getConsole() + "\n"
                    + "Nome do usuário: " + this.getNome() + "\n"
                    + "Emal: " + this.getEmail() + "\n"
                    + "Telefone: " + this.getTelefone() + "\n"
                    + "Mensagem: " + this.getMensagem() + "\n"
            );
            //Envio da mensagem
            Transport.send(messagem);
            //msg de confirmação de envio
            FacesMessage msg = new FacesMessage("Obrigado pela sua opinão. Em breve entraremos em contato!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            //limpeza do form
            clear();
        } catch (MessagingException e) {
            FacesMessage msg = new FacesMessage("Não foi possível enviar o email. Erro:" + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void clear() {
        console = null;
        nome = null;
        email = null;
        telefone = null;
        mensagem = null;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
