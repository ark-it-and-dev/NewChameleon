package Controller;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


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
public class CarrosselImagens {

    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            images.add("logo" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }

    
    public String getImage() {
        return "logo1.jpg";
    }
}
