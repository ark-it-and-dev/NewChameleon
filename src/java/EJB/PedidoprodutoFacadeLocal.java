/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.Pedidoproduto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author David
 */
@Local
public interface PedidoprodutoFacadeLocal {

    void create(Pedidoproduto pedidoproduto);

    void edit(Pedidoproduto pedidoproduto);

    void remove(Pedidoproduto pedidoproduto);

    Pedidoproduto find(Object id);

    List<Pedidoproduto> findAll();

    List<Pedidoproduto> findRange(int[] range);

    int count();
    
}
