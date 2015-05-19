package EJB;

import Model.Endereco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EnderecoFacade extends AbstractFacade<Endereco> implements EnderecoFacadeLocal {

    @PersistenceContext(unitName = "Chameleon_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnderecoFacade() {
        super(Endereco.class);
    }

}
