/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siscom.bean;

import br.com.siscom.bean.Clientes;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author windows
 */
@Entity
@Table(name = "clientes_enderecos", catalog = "siscomjava", schema = "")
@NamedQueries({
    @NamedQuery(name = "ClientesEnderecos.findAll", query = "SELECT c FROM ClientesEnderecos c"),
    @NamedQuery(name = "ClientesEnderecos.findByEndeCodigo", query = "SELECT c FROM ClientesEnderecos c WHERE c.endeCodigo = :endeCodigo"),
    @NamedQuery(name = "ClientesEnderecos.findByEndeLogradouro", query = "SELECT c FROM ClientesEnderecos c WHERE c.endeLogradouro = :endeLogradouro"),
    @NamedQuery(name = "ClientesEnderecos.findByEndeComplemento", query = "SELECT c FROM ClientesEnderecos c WHERE c.endeComplemento = :endeComplemento"),
    @NamedQuery(name = "ClientesEnderecos.findByEndeCep", query = "SELECT c FROM ClientesEnderecos c WHERE c.endeCep = :endeCep"),
    @NamedQuery(name = "ClientesEnderecos.findByEndeBairro", query = "SELECT c FROM ClientesEnderecos c WHERE c.endeBairro = :endeBairro"),
    @NamedQuery(name = "ClientesEnderecos.findByEndeCidade", query = "SELECT c FROM ClientesEnderecos c WHERE c.endeCidade = :endeCidade"),
    @NamedQuery(name = "ClientesEnderecos.findByEndeUf", query = "SELECT c FROM ClientesEnderecos c WHERE c.endeUf = :endeUf")})
public class ClientesEnderecos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ENDE_CODIGO")
    private Integer endeCodigo;
    @Basic(optional = false)
    @Column(name = "ENDE_LOGRADOURO")
    private String endeLogradouro;
    @Column(name = "ENDE_COMPLEMENTO")
    private String endeComplemento;
    @Column(name = "ENDE_CEP")
    private String endeCep;
    @Column(name = "ENDE_BAIRRO")
    private String endeBairro;
    @Column(name = "ENDE_CIDADE")
    private String endeCidade;
    @Column(name = "ENDE_UF")
    private String endeUf;
    @JoinColumn(name = "CLI_CODIGO", referencedColumnName = "CLI_CODIGO")
    @ManyToOne
    private Clientes cliCodigo;

    public ClientesEnderecos() {
    }

    public ClientesEnderecos(Integer endeCodigo) {
        this.endeCodigo = endeCodigo;
    }

    public ClientesEnderecos(Integer endeCodigo, String endeLogradouro) {
        this.endeCodigo = endeCodigo;
        this.endeLogradouro = endeLogradouro;
    }

    public Integer getEndeCodigo() {
        return endeCodigo;
    }

    public void setEndeCodigo(Integer endeCodigo) {
        Integer oldEndeCodigo = this.endeCodigo;
        this.endeCodigo = endeCodigo;
        changeSupport.firePropertyChange("endeCodigo", oldEndeCodigo, endeCodigo);
    }

    public String getEndeLogradouro() {
        return endeLogradouro;
    }

    public void setEndeLogradouro(String endeLogradouro) {
        String oldEndeLogradouro = this.endeLogradouro;
        this.endeLogradouro = endeLogradouro;
        changeSupport.firePropertyChange("endeLogradouro", oldEndeLogradouro, endeLogradouro);
    }

    public String getEndeComplemento() {
        return endeComplemento;
    }

    public void setEndeComplemento(String endeComplemento) {
        String oldEndeComplemento = this.endeComplemento;
        this.endeComplemento = endeComplemento;
        changeSupport.firePropertyChange("endeComplemento", oldEndeComplemento, endeComplemento);
    }

    public String getEndeCep() {
        return endeCep;
    }

    public void setEndeCep(String endeCep) {
        String oldEndeCep = this.endeCep;
        this.endeCep = endeCep;
        changeSupport.firePropertyChange("endeCep", oldEndeCep, endeCep);
    }

    public String getEndeBairro() {
        return endeBairro;
    }

    public void setEndeBairro(String endeBairro) {
        String oldEndeBairro = this.endeBairro;
        this.endeBairro = endeBairro;
        changeSupport.firePropertyChange("endeBairro", oldEndeBairro, endeBairro);
    }

    public String getEndeCidade() {
        return endeCidade;
    }

    public void setEndeCidade(String endeCidade) {
        String oldEndeCidade = this.endeCidade;
        this.endeCidade = endeCidade;
        changeSupport.firePropertyChange("endeCidade", oldEndeCidade, endeCidade);
    }

    public String getEndeUf() {
        return endeUf;
    }

    public void setEndeUf(String endeUf) {
        String oldEndeUf = this.endeUf;
        this.endeUf = endeUf;
        changeSupport.firePropertyChange("endeUf", oldEndeUf, endeUf);
    }

    public Clientes getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(Clientes cliCodigo) {
        Clientes oldCliCodigo = this.cliCodigo;
        this.cliCodigo = cliCodigo;
        changeSupport.firePropertyChange("cliCodigo", oldCliCodigo, cliCodigo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (endeCodigo != null ? endeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesEnderecos)) {
            return false;
        }
        ClientesEnderecos other = (ClientesEnderecos) object;
        if ((this.endeCodigo == null && other.endeCodigo != null) || (this.endeCodigo != null && !this.endeCodigo.equals(other.endeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.view.ClientesEnderecos[ endeCodigo=" + endeCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
