/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siscom.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author windows
 */
@Entity
@Table(name = "cartaos", catalog = "siscomjava", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cartaos.findAll", query = "SELECT c FROM Cartaos c"),
    @NamedQuery(name = "Cartaos.findByCartCodigo", query = "SELECT c FROM Cartaos c WHERE c.cartCodigo = :cartCodigo"),
    @NamedQuery(name = "Cartaos.findByCartNome", query = "SELECT c FROM Cartaos c WHERE c.cartNome = :cartNome"),
    @NamedQuery(name = "Cartaos.findByCartTaxa", query = "SELECT c FROM Cartaos c WHERE c.cartTaxa = :cartTaxa")})
public class Cartaos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CART_CODIGO")
    private Integer cartCodigo;
    @Column(name = "CART_NOME")
    private String cartNome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CART_TAXA")
    private Double cartTaxa;

    public Cartaos() {
    }

    public Cartaos(Integer cartCodigo) {
        this.cartCodigo = cartCodigo;
    }

    public Integer getCartCodigo() {
        return cartCodigo;
    }

    public void setCartCodigo(Integer cartCodigo) {
        Integer oldCartCodigo = this.cartCodigo;
        this.cartCodigo = cartCodigo;
        changeSupport.firePropertyChange("cartCodigo", oldCartCodigo, cartCodigo);
    }

    public String getCartNome() {
        return cartNome;
    }

    public void setCartNome(String cartNome) {
        String oldCartNome = this.cartNome;
        this.cartNome = cartNome;
        changeSupport.firePropertyChange("cartNome", oldCartNome, cartNome);
    }

    public Double getCartTaxa() {
        return cartTaxa;
    }

    public void setCartTaxa(Double cartTaxa) {
        Double oldCartTaxa = this.cartTaxa;
        this.cartTaxa = cartTaxa;
        changeSupport.firePropertyChange("cartTaxa", oldCartTaxa, cartTaxa);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartCodigo != null ? cartCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartaos)) {
            return false;
        }
        Cartaos other = (Cartaos) object;
        if ((this.cartCodigo == null && other.cartCodigo != null) || (this.cartCodigo != null && !this.cartCodigo.equals(other.cartCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.view.Cartaos[ cartCodigo=" + cartCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
