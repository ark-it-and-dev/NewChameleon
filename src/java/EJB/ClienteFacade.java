package EJB;

import Model.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "Chameleon_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public Cliente findByEmail(String email) {
        Cliente cliente;
        Query q = em.createNamedQuery("Cliente.findByEmail");
        q.setParameter("email", email);
        cliente = (Cliente) q.getSingleResult();
        return cliente;
    }

}
