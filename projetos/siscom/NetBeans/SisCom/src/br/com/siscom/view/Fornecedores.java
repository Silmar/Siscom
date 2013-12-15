/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siscom.view;

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
@Table(name = "fornecedores", catalog = "siscomjava", schema = "")
@NamedQueries({
    @NamedQuery(name = "Fornecedores.findAll", query = "SELECT f FROM Fornecedores f"),
    @NamedQuery(name = "Fornecedores.findByFornecCod", query = "SELECT f FROM Fornecedores f WHERE f.fornecCod = :fornecCod"),
    @NamedQuery(name = "Fornecedores.findByFornecNome", query = "SELECT f FROM Fornecedores f WHERE f.fornecNome = :fornecNome"),
    @NamedQuery(name = "Fornecedores.findByFornecCpf", query = "SELECT f FROM Fornecedores f WHERE f.fornecCpf = :fornecCpf"),
    @NamedQuery(name = "Fornecedores.findByFornecRg", query = "SELECT f FROM Fornecedores f WHERE f.fornecRg = :fornecRg"),
    @NamedQuery(name = "Fornecedores.findByFornecRgOrgao", query = "SELECT f FROM Fornecedores f WHERE f.fornecRgOrgao = :fornecRgOrgao"),
    @NamedQuery(name = "Fornecedores.findByFornecCnpj", query = "SELECT f FROM Fornecedores f WHERE f.fornecCnpj = :fornecCnpj"),
    @NamedQuery(name = "Fornecedores.findByFornecedorTipo", query = "SELECT f FROM Fornecedores f WHERE f.fornecedorTipo = :fornecedorTipo"),
    @NamedQuery(name = "Fornecedores.findByFornecEndereco", query = "SELECT f FROM Fornecedores f WHERE f.fornecEndereco = :fornecEndereco"),
    @NamedQuery(name = "Fornecedores.findByFornecBairro", query = "SELECT f FROM Fornecedores f WHERE f.fornecBairro = :fornecBairro"),
    @NamedQuery(name = "Fornecedores.findByFornecCidade", query = "SELECT f FROM Fornecedores f WHERE f.fornecCidade = :fornecCidade"),
    @NamedQuery(name = "Fornecedores.findByFornecUf", query = "SELECT f FROM Fornecedores f WHERE f.fornecUf = :fornecUf"),
    @NamedQuery(name = "Fornecedores.findByFornecCep", query = "SELECT f FROM Fornecedores f WHERE f.fornecCep = :fornecCep"),
    @NamedQuery(name = "Fornecedores.findByFornecEmail", query = "SELECT f FROM Fornecedores f WHERE f.fornecEmail = :fornecEmail"),
    @NamedQuery(name = "Fornecedores.findByFornecSite", query = "SELECT f FROM Fornecedores f WHERE f.fornecSite = :fornecSite"),
    @NamedQuery(name = "Fornecedores.findByFornecFone", query = "SELECT f FROM Fornecedores f WHERE f.fornecFone = :fornecFone"),
    @NamedQuery(name = "Fornecedores.findByFornecCelular", query = "SELECT f FROM Fornecedores f WHERE f.fornecCelular = :fornecCelular"),
    @NamedQuery(name = "Fornecedores.findByFornecFax", query = "SELECT f FROM Fornecedores f WHERE f.fornecFax = :fornecFax")})
public class Fornecedores implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FORNEC_COD")
    private Integer fornecCod;
    @Column(name = "FORNEC_NOME")
    private String fornecNome;
    @Column(name = "FORNEC_CPF")
    private String fornecCpf;
    @Column(name = "FORNEC_RG")
    private String fornecRg;
    @Column(name = "FORNEC_RG_ORGAO")
    private String fornecRgOrgao;
    @Column(name = "FORNEC_CNPJ")
    private String fornecCnpj;
    @Column(name = "FORNECEDOR_TIPO")
    private Character fornecedorTipo;
    @Column(name = "FORNEC_ENDERECO")
    private String fornecEndereco;
    @Column(name = "FORNEC_BAIRRO")
    private String fornecBairro;
    @Column(name = "FORNEC_CIDADE")
    private String fornecCidade;
    @Column(name = "FORNEC_UF")
    private String fornecUf;
    @Column(name = "FORNEC_CEP")
    private String fornecCep;
    @Column(name = "FORNEC_EMAIL")
    private String fornecEmail;
    @Column(name = "FORNEC_SITE")
    private String fornecSite;
    @Column(name = "FORNEC_FONE")
    private String fornecFone;
    @Column(name = "FORNEC_CELULAR")
    private String fornecCelular;
    @Column(name = "FORNEC_FAX")
    private String fornecFax;

    public Fornecedores() {
    }

    public Fornecedores(Integer fornecCod) {
        this.fornecCod = fornecCod;
    }

    public Integer getFornecCod() {
        return fornecCod;
    }

    public void setFornecCod(Integer fornecCod) {
        Integer oldFornecCod = this.fornecCod;
        this.fornecCod = fornecCod;
        changeSupport.firePropertyChange("fornecCod", oldFornecCod, fornecCod);
    }

    public String getFornecNome() {
        return fornecNome;
    }

    public void setFornecNome(String fornecNome) {
        String oldFornecNome = this.fornecNome;
        this.fornecNome = fornecNome;
        changeSupport.firePropertyChange("fornecNome", oldFornecNome, fornecNome);
    }

    public String getFornecCpf() {
       String tfCPF =null; 
       javax.swing.JFormattedTextField fCPF;

       try{  
           javax.swing.text.MaskFormatter fornecCpfFormatado = new javax.swing.text.MaskFormatter("###.###.###-##");  
  
           fCPF = new javax.swing.JFormattedTextField(fornecCpfFormatado);
           fCPF.setText(null);
           fCPF.setText(fornecCpf);
           tfCPF = fCPF.getText();
  
        }catch (Exception e){}  
          return (fornecCpf == null) ? fornecCpf : tfCPF;
        
    }

    public void setFornecCpf(String fornecCpf) {
        String oldFornecCpf = this.fornecCpf;
        fornecCpf = fornecCpf.replaceAll("\\.", "");
        fornecCpf = fornecCpf.replace("-", "");
        this.fornecCpf = fornecCpf;
        changeSupport.firePropertyChange("fornecCpf", oldFornecCpf, fornecCpf);
    }

    public String getFornecRg() {

        return this.fornecRg;
    }

    public void setFornecRg(String fornecRg) {
        
        String oldFornecRg = this.fornecRg;

        this.fornecRg = fornecRg;
        changeSupport.firePropertyChange("fornecRg", oldFornecRg, fornecRg);
    }

    public String getFornecRgOrgao() {
        return fornecRgOrgao;
    }

    public void setFornecRgOrgao(String fornecRgOrgao) {
        String oldFornecRgOrgao = this.fornecRgOrgao;
        this.fornecRgOrgao = fornecRgOrgao;
        changeSupport.firePropertyChange("fornecRgOrgao", oldFornecRgOrgao, fornecRgOrgao);
    }

    public String getFornecCnpj() {
                String sFCNPJ =null; // string Formatted CNPJ
        javax.swing.JFormattedTextField fFCNPJ;//formattedFieldCNPJ

       try{  
           javax.swing.text.MaskFormatter fornecCNPJFormatado = new javax.swing.text.MaskFormatter("##.###.###/####-##");  
           fFCNPJ = new javax.swing.JFormattedTextField(fornecCNPJFormatado);
           fFCNPJ.setText(null);
           fFCNPJ.setText(fornecCnpj);
           sFCNPJ = fFCNPJ.getText();
  
        }catch (Exception e){}  
          
        return (fornecCnpj == null) ? null : sFCNPJ;
        
        
    }

    public void setFornecCnpj(String fornecCnpj) {
         /*
        Mascara para CNPJ == "##.###.###/####-##"
        */
        String oldForneCnpj = this.fornecCnpj;
        fornecCnpj = fornecCnpj.replaceAll("\\.", "");
        fornecCnpj = fornecCnpj.replace("-", "");
        fornecCnpj = fornecCnpj.replace("/", "");
        
        String oldFornecCnpj = this.fornecCnpj;
        this.fornecCnpj = fornecCnpj;
        changeSupport.firePropertyChange("fornecCnpj", oldFornecCnpj, fornecCnpj);
    }

    public Character getFornecedorTipo() {
        return fornecedorTipo;
    }

    public void setFornecedorTipo(Character fornecedorTipo) {
        Character oldFornecedorTipo = this.fornecedorTipo;
        this.fornecedorTipo = fornecedorTipo;
        changeSupport.firePropertyChange("fornecedorTipo", oldFornecedorTipo, fornecedorTipo);
    }

    public String getFornecEndereco() {
        return fornecEndereco;
    }

    public void setFornecEndereco(String fornecEndereco) {
        String oldFornecEndereco = this.fornecEndereco;
        this.fornecEndereco = fornecEndereco;
        changeSupport.firePropertyChange("fornecEndereco", oldFornecEndereco, fornecEndereco);
    }

    public String getFornecBairro() {
        return fornecBairro;
    }

    public void setFornecBairro(String fornecBairro) {
        String oldFornecBairro = this.fornecBairro;
        this.fornecBairro = fornecBairro;
        changeSupport.firePropertyChange("fornecBairro", oldFornecBairro, fornecBairro);
    }

    public String getFornecCidade() {
        return fornecCidade;
    }

    public void setFornecCidade(String fornecCidade) {
        String oldFornecCidade = this.fornecCidade;
        this.fornecCidade = fornecCidade;
        changeSupport.firePropertyChange("fornecCidade", oldFornecCidade, fornecCidade);
    }

    public String getFornecUf() {
        return fornecUf;
    }

    public void setFornecUf(String fornecUf) {
        String oldFornecUf = this.fornecUf;
        this.fornecUf = fornecUf;
        changeSupport.firePropertyChange("fornecUf", oldFornecUf, fornecUf);
    }

    public String getFornecCep() {
                  String sfnCEP =null; // string Formatted CEP
        javax.swing.JFormattedTextField fFCep;//formattedFieldCep

       try{  
           javax.swing.text.MaskFormatter fornecCEFormatado = new javax.swing.text.MaskFormatter("#####-###");  
           fFCep = new javax.swing.JFormattedTextField(fornecCEFormatado);
           fFCep.setText(null);
           fFCep.setText(fornecCep);
           sfnCEP = fFCep.getText();
  
        }catch (Exception e){}  
          
               return (fornecCep == null) ? null : fornecCep;
    }

    public void setFornecCep(String fornecCep) {
          /*
        Mascara para CEP == "#####-###"
        */
        String oldFornecCep = this.fornecCep;

        fornecCep = fornecCep.replace("\\.", "");
        fornecCep = fornecCep.replace("-", "");

        this.fornecCep = fornecCep;
        changeSupport.firePropertyChange("fornecCep", oldFornecCep, fornecCep);
    }

    public String getFornecEmail() {
        return fornecEmail;
    }

    public void setFornecEmail(String fornecEmail) {
        String oldFornecEmail = this.fornecEmail;
        this.fornecEmail = fornecEmail;
        changeSupport.firePropertyChange("fornecEmail", oldFornecEmail, fornecEmail);
    }

    public String getFornecSite() {
        return fornecSite;
    }

    public void setFornecSite(String fornecSite) {
        String oldFornecSite = this.fornecSite;
        this.fornecSite = fornecSite;
        changeSupport.firePropertyChange("fornecSite", oldFornecSite, fornecSite);
    }

    public String getFornecFone() {
        return fornecFone;
    }

    public void setFornecFone(String fornecFone) {
        String oldFornecFone = this.fornecFone;
        this.fornecFone = fornecFone;
        changeSupport.firePropertyChange("fornecFone", oldFornecFone, fornecFone);
    }

    public String getFornecCelular() {
        return fornecCelular;
    }

    public void setFornecCelular(String fornecCelular) {
        String oldFornecCelular = this.fornecCelular;
        this.fornecCelular = fornecCelular;
        changeSupport.firePropertyChange("fornecCelular", oldFornecCelular, fornecCelular);
    }

    public String getFornecFax() {
        return fornecFax;
    }

    public void setFornecFax(String fornecFax) {
        String oldFornecFax = this.fornecFax;
        this.fornecFax = fornecFax;
        changeSupport.firePropertyChange("fornecFax", oldFornecFax, fornecFax);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fornecCod != null ? fornecCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedores)) {
            return false;
        }
        Fornecedores other = (Fornecedores) object;
        if ((this.fornecCod == null && other.fornecCod != null) || (this.fornecCod != null && !this.fornecCod.equals(other.fornecCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.view.Fornecedores[ fornecCod=" + fornecCod + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
