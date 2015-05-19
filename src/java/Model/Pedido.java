package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@SequenceGenerator(name = "PEDIDO_SEQ", sequenceName = "PEDIDO_SEQ", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id"),
    @NamedQuery(name = "Pedido.findByStatus", query = "SELECT p FROM Pedido p WHERE p.status = :status"),
    @NamedQuery(name = "Pedido.findByValortotal", query = "SELECT p FROM Pedido p WHERE p.valortotal = :valortotal")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDO_SEQ")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 20)
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente clienteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoId")
    private Collection<Pedidoproduto> pedidoprodutoCollection;

    public Pedido() {
    }

    public Pedido(BigDecimal id) {
        this.id = id;
    }

    public Pedido(BigDecimal id, StatusPedido status, BigDecimal valortotal) {
        this.id = id;
        this.status = status;
        this.valortotal = valortotal;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    @XmlTransient
    public Collection<Pedidoproduto> getPedidoprodutoCollection() {
        return pedidoprodutoCollection;
    }

    public void setPedidoprodutoCollection(Collection<Pedidoproduto> pedidoprodutoCollection) {
        this.pedidoprodutoCollection = pedidoprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Pedido[ id=" + id + " ]";
    }

}
