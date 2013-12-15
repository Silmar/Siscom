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
@Table(name = "bancos", catalog = "siscomjava", schema = "")
@NamedQueries({
    @NamedQuery(name = "Bancos.findAll", query = "SELECT b FROM Bancos b"),
    @NamedQuery(name = "Bancos.findByBancoCod", query = "SELECT b FROM Bancos b WHERE b.bancoCod = :bancoCod"),
    @NamedQuery(name = "Bancos.findByBancoNome", query = "SELECT b FROM Bancos b WHERE b.bancoNome = :bancoNome"),
    @NamedQuery(name = "Bancos.findByBancoAgencia", query = "SELECT b FROM Bancos b WHERE b.bancoAgencia = :bancoAgencia"),
    @NamedQuery(name = "Bancos.findByBancoConta", query = "SELECT b FROM Bancos b WHERE b.bancoConta = :bancoConta"),
    @NamedQuery(name = "Bancos.findByBancoGerente", query = "SELECT b FROM Bancos b WHERE b.bancoGerente = :bancoGerente"),
    @NamedQuery(name = "Bancos.findByBancoFone", query = "SELECT b FROM Bancos b WHERE b.bancoFone = :bancoFone")})
public class Bancos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
   
    @Basic(optional = false)
    @Column(name = "BANCO_COD")
    private Integer bancoCod;
    @Basic(optional = false)
    @Column(name = "BANCO_NOME")
    private String bancoNome;
    @Column(name = "BANCO_AGENCIA")
    private Integer bancoAgencia;
    @Column(name = "BANCO_CONTA")
    private Integer bancoConta;
    @Column(name = "BANCO_GERENTE")
    private String bancoGerente;
    @Column(name = "BANCO_FONE")
    private String bancoFone;

    public Bancos() {
    }

    public Bancos(Integer bancoCod) {
        this.bancoCod = bancoCod;
    }

    public Bancos(Integer bancoCod, String bancoNome) {
        this.bancoCod = bancoCod;
        this.bancoNome = bancoNome;
    }

    public Integer getBancoCod() {
        return bancoCod;
    }

    public void setBancoCod(Integer bancoCod) {
        Integer oldBancoCod = this.bancoCod;
        this.bancoCod = bancoCod;
        changeSupport.firePropertyChange("bancoCod", oldBancoCod, bancoCod);
    }

    public String getBancoNome() {
        return bancoNome;
    }

    public void setBancoNome(String bancoNome) {
        String oldBancoNome = this.bancoNome;
        this.bancoNome = bancoNome;
        changeSupport.firePropertyChange("bancoNome", oldBancoNome, bancoNome);
    }

    public Integer getBancoAgencia() {
        return bancoAgencia;
    }

    public void setBancoAgencia(Integer bancoAgencia) {
        Integer oldBancoAgencia = this.bancoAgencia;
        this.bancoAgencia = bancoAgencia;
        changeSupport.firePropertyChange("bancoAgencia", oldBancoAgencia, bancoAgencia);
    }

    public Integer getBancoConta() {
        return bancoConta;
    }

    public void setBancoConta(Integer bancoConta) {
        Integer oldBancoConta = this.bancoConta;
        this.bancoConta = bancoConta;
        changeSupport.firePropertyChange("bancoConta", oldBancoConta, bancoConta);
    }

    public String getBancoGerente() {
        return bancoGerente;
    }

    public void setBancoGerente(String bancoGerente) {
        String oldBancoGerente = this.bancoGerente;
        this.bancoGerente = bancoGerente;
        changeSupport.firePropertyChange("bancoGerente", oldBancoGerente, bancoGerente);
    }

    public String getBancoFone() {
        return bancoFone;
    }

    public void setBancoFone(String bancoFone) {
        String oldBancoFone = this.bancoFone;
        this.bancoFone = bancoFone;
        changeSupport.firePropertyChange("bancoFone", oldBancoFone, bancoFone);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bancoCod != null ? bancoCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bancos)) {
            return false;
        }
        Bancos other = (Bancos) object;
        if ((this.bancoCod == null && other.bancoCod != null) || (this.bancoCod != null && !this.bancoCod.equals(other.bancoCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.view.Bancos[ bancoCod=" + bancoCod + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
