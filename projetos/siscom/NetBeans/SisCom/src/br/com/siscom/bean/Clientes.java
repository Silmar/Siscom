/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siscom.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author windows
 */
@Entity
@Table(name = "clientes", catalog = "siscomjava", schema = "")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByCliCodigo", query = "SELECT c FROM Clientes c WHERE c.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "Clientes.findByCliNome", query = "SELECT c FROM Clientes c WHERE c.cliNome = :cliNome"),
    @NamedQuery(name = "Clientes.findByCliCpf", query = "SELECT c FROM Clientes c WHERE c.cliCpf = :cliCpf"),
    @NamedQuery(name = "Clientes.findByCliRg", query = "SELECT c FROM Clientes c WHERE c.cliRg = :cliRg"),
    @NamedQuery(name = "Clientes.findByCliOrgaoRg", query = "SELECT c FROM Clientes c WHERE c.cliOrgaoRg = :cliOrgaoRg"),
    @NamedQuery(name = "Clientes.findByCliNascimento", query = "SELECT c FROM Clientes c WHERE c.cliNascimento = :cliNascimento"),
    @NamedQuery(name = "Clientes.findByCliDesde", query = "SELECT c FROM Clientes c WHERE c.cliDesde = :cliDesde"),
    @NamedQuery(name = "Clientes.findByCliProfissao", query = "SELECT c FROM Clientes c WHERE c.cliProfissao = :cliProfissao"),
    @NamedQuery(name = "Clientes.findByCliEmpresa", query = "SELECT c FROM Clientes c WHERE c.cliEmpresa = :cliEmpresa"),
    @NamedQuery(name = "Clientes.findByCliFoneEmpresa", query = "SELECT c FROM Clientes c WHERE c.cliFoneEmpresa = :cliFoneEmpresa"),
    @NamedQuery(name = "Clientes.findByCliRenda", query = "SELECT c FROM Clientes c WHERE c.cliRenda = :cliRenda"),
    @NamedQuery(name = "Clientes.findByCliTipoFisJuri", query = "SELECT c FROM Clientes c WHERE c.cliTipoFisJuri = :cliTipoFisJuri"),
    @NamedQuery(name = "Clientes.findByCliCnpj", query = "SELECT c FROM Clientes c WHERE c.cliCnpj = :cliCnpj"),
    @NamedQuery(name = "Clientes.findByCliReferencia", query = "SELECT c FROM Clientes c WHERE c.cliReferencia = :cliReferencia"),
    @NamedQuery(name = "Clientes.findByCliFoneReferencia", query = "SELECT c FROM Clientes c WHERE c.cliFoneReferencia = :cliFoneReferencia"),
    @NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email")})
public class Clientes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLI_CODIGO")
    private Integer cliCodigo;
    @Basic(optional = false)
    @Column(name = "CLI_NOME")
    private String cliNome;
    @Column(name = "CLI_CPF")
    private String cliCpf;
    @Column(name = "CLI_RG")
    private String cliRg;
    @Column(name = "CLI_ORGAO_RG")
    private String cliOrgaoRg;
    @Column(name = "CLI_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date cliNascimento;
    @Column(name = "CLI_DESDE")
    @Temporal(TemporalType.DATE)
    private Date cliDesde;
    @Column(name = "CLI_PROFISSAO")
    private String cliProfissao;
    @Column(name = "CLI_EMPRESA")
    private String cliEmpresa;
    @Column(name = "CLI_FONE_EMPRESA")
    private String cliFoneEmpresa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CLI_RENDA")
    private Double cliRenda;
    @Column(name = "CLI_TIPO_FIS_JURI")
    private Character cliTipoFisJuri;
    @Column(name = "CLI_CNPJ")
    private String cliCnpj;
    @Column(name = "CLI_REFERENCIA")
    private String cliReferencia;
    @Column(name = "CLI_FONE_REFERENCIA")
    private String cliFoneReferencia;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "cliCodigo")
    private List<ClientesEnderecos> clientesEnderecosList;

    public Clientes() {
    }

    public Clientes(Integer cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public Clientes(Integer cliCodigo, String cliNome) {
        this.cliCodigo = cliCodigo;
        this.cliNome = cliNome;
    }

    public Integer getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(Integer cliCodigo) {
        Integer oldCliCodigo = this.cliCodigo;
        this.cliCodigo = cliCodigo;
        changeSupport.firePropertyChange("cliCodigo", oldCliCodigo, cliCodigo);
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        String oldCliNome = this.cliNome;
        this.cliNome = cliNome;
        changeSupport.firePropertyChange("cliNome", oldCliNome, cliNome);
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        String oldCliCpf = this.cliCpf;
        this.cliCpf = cliCpf;
        changeSupport.firePropertyChange("cliCpf", oldCliCpf, cliCpf);
    }

    public String getCliRg() {
        return cliRg;
    }

    public void setCliRg(String cliRg) {
        String oldCliRg = this.cliRg;
        this.cliRg = cliRg;
        changeSupport.firePropertyChange("cliRg", oldCliRg, cliRg);
    }

    public String getCliOrgaoRg() {
        return cliOrgaoRg;
    }

    public void setCliOrgaoRg(String cliOrgaoRg) {
        String oldCliOrgaoRg = this.cliOrgaoRg;
        this.cliOrgaoRg = cliOrgaoRg;
        changeSupport.firePropertyChange("cliOrgaoRg", oldCliOrgaoRg, cliOrgaoRg);
    }

    public Date getCliNascimento() {
        return cliNascimento;
    }

    public void setCliNascimento(Date cliNascimento) {
        Date oldCliNascimento = this.cliNascimento;
        this.cliNascimento = cliNascimento;
        changeSupport.firePropertyChange("cliNascimento", oldCliNascimento, cliNascimento);
    }

    public Date getCliDesde() {
        return cliDesde;
    }

    public void setCliDesde(Date cliDesde) {
        Date oldCliDesde = this.cliDesde;
        this.cliDesde = cliDesde;
        changeSupport.firePropertyChange("cliDesde", oldCliDesde, cliDesde);
    }

    public String getCliProfissao() {
        return cliProfissao;
    }

    public void setCliProfissao(String cliProfissao) {
        String oldCliProfissao = this.cliProfissao;
        this.cliProfissao = cliProfissao;
        changeSupport.firePropertyChange("cliProfissao", oldCliProfissao, cliProfissao);
    }

    public String getCliEmpresa() {
        return cliEmpresa;
    }

    public void setCliEmpresa(String cliEmpresa) {
        String oldCliEmpresa = this.cliEmpresa;
        this.cliEmpresa = cliEmpresa;
        changeSupport.firePropertyChange("cliEmpresa", oldCliEmpresa, cliEmpresa);
    }

    public String getCliFoneEmpresa() {
        return cliFoneEmpresa;
    }

    public void setCliFoneEmpresa(String cliFoneEmpresa) {
        String oldCliFoneEmpresa = this.cliFoneEmpresa;
        this.cliFoneEmpresa = cliFoneEmpresa;
        changeSupport.firePropertyChange("cliFoneEmpresa", oldCliFoneEmpresa, cliFoneEmpresa);
    }

    public Double getCliRenda() {
        return cliRenda;
    }

    public void setCliRenda(Double cliRenda) {
        Double oldCliRenda = this.cliRenda;
        this.cliRenda = cliRenda;
        changeSupport.firePropertyChange("cliRenda", oldCliRenda, cliRenda);
    }

    public Character getCliTipoFisJuri() {
        return cliTipoFisJuri;
    }

    public void setCliTipoFisJuri(Character cliTipoFisJuri) {
        Character oldCliTipoFisJuri = this.cliTipoFisJuri;
        this.cliTipoFisJuri = cliTipoFisJuri;
        changeSupport.firePropertyChange("cliTipoFisJuri", oldCliTipoFisJuri, cliTipoFisJuri);
    }

    public String getCliCnpj() {
        return cliCnpj;
    }

    public void setCliCnpj(String cliCnpj) {
        String oldCliCnpj = this.cliCnpj;
        this.cliCnpj = cliCnpj;
        changeSupport.firePropertyChange("cliCnpj", oldCliCnpj, cliCnpj);
    }

    public String getCliReferencia() {
        return cliReferencia;
    }

    public void setCliReferencia(String cliReferencia) {
        String oldCliReferencia = this.cliReferencia;
        this.cliReferencia = cliReferencia;
        changeSupport.firePropertyChange("cliReferencia", oldCliReferencia, cliReferencia);
    }

    public String getCliFoneReferencia() {
        return cliFoneReferencia;
    }

    public void setCliFoneReferencia(String cliFoneReferencia) {
        String oldCliFoneReferencia = this.cliFoneReferencia;
        this.cliFoneReferencia = cliFoneReferencia;
        changeSupport.firePropertyChange("cliFoneReferencia", oldCliFoneReferencia, cliFoneReferencia);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public List<ClientesEnderecos> getClientesEnderecosList() {
        return clientesEnderecosList;
    }

    public void setClientesEnderecosList(List<ClientesEnderecos> clientesEnderecosList) {
        this.clientesEnderecosList = clientesEnderecosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliCodigo != null ? cliCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.cliCodigo == null && other.cliCodigo != null) || (this.cliCodigo != null && !this.cliCodigo.equals(other.cliCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.view.Clientes[ cliCodigo=" + cliCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
