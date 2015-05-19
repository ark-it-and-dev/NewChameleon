/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.Pedidoproduto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David
 */
@Stateless
public class PedidoprodutoFacade extends AbstractFacade<Pedidoproduto> implements PedidoprodutoFacadeLocal {
    @PersistenceContext(unitName = "Chameleon_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoprodutoFacade() {
        super(Pedidoproduto.class);
    }
    
}
