package EJB;

import Model.Endereco;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EnderecoFacadeLocal {

    void create(Endereco endereco);

    void edit(Endereco endereco);

    void remove(Endereco endereco);

    Endereco find(Object id);

    List<Endereco> findAll();

    List<Endereco> findRange(int[] range);

    int count();

}
