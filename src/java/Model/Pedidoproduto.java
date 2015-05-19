package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@SequenceGenerator(name = "ped_prod_seq", sequenceName = "ped_prod_seq", allocationSize = 1, initialValue = 1)
@Table(name = "PEDIDOPRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidoproduto.findAll", query = "SELECT p FROM Pedidoproduto p"),
    @NamedQuery(name = "Pedidoproduto.findByQuantidade", query = "SELECT p FROM Pedidoproduto p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Pedidoproduto.findById", query = "SELECT p FROM Pedidoproduto p WHERE p.id = :id")})
public class Pedidoproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private BigInteger quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ped_prod_seq")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "PEDIDO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pedido pedidoId;
    @JoinColumn(name = "PRODUTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Produto produtoId;

    public Pedidoproduto() {
    }

    public Pedidoproduto(BigDecimal id) {
        this.id = id;
    }

    public Pedidoproduto(BigDecimal id, BigInteger quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public BigInteger getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigInteger quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
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
        if (!(object instanceof Pedidoproduto)) {
            return false;
        }
        Pedidoproduto other = (Pedidoproduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Pedidoproduto[ id=" + id + " ]";
    }

}
