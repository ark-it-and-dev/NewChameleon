package Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Benitez
 */
@ManagedBean
public class TrocaImagens {
    private UploadedFile file;
    
    public UploadedFile getFile(){
        return file;
    }
    public void setFile(UploadedFile file){
        this.file=file;
    }
    public void upload(){
        if(file != null){
            FacesMessage message = new FacesMessage("Sucesseful", file.getFileName() + "Foto Carregada.!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
}
