/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.siscom.bean;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author windows
 */
@Entity
@Table(name = "tipo_pagamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPagamentos.findAll", query = "SELECT t FROM TipoPagamentos t"),
    @NamedQuery(name = "TipoPagamentos.findByTipopgtoCod", query = "SELECT t FROM TipoPagamentos t WHERE t.tipopgtoCod = :tipopgtoCod"),
    @NamedQuery(name = "TipoPagamentos.findByTipopgtoDesc", query = "SELECT t FROM TipoPagamentos t WHERE t.tipopgtoDesc = :tipopgtoDesc")})
public class TipoPagamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPOPGTO_COD")
    private Integer tipopgtoCod;
    @Column(name = "TIPOPGTO_DESC")
    private String tipopgtoDesc;

    public TipoPagamentos() {
    }

    public TipoPagamentos(Integer tipopgtoCod) {
        this.tipopgtoCod = tipopgtoCod;
    }

    public Integer getTipopgtoCod() {
        return tipopgtoCod;
    }

    public void setTipopgtoCod(Integer tipopgtoCod) {
        this.tipopgtoCod = tipopgtoCod;
    }

    public String getTipopgtoDesc() {
        return tipopgtoDesc;
    }

    public void setTipopgtoDesc(String tipopgtoDesc) {
        this.tipopgtoDesc = tipopgtoDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipopgtoCod != null ? tipopgtoCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPagamentos)) {
            return false;
        }
        TipoPagamentos other = (TipoPagamentos) object;
        if ((this.tipopgtoCod == null && other.tipopgtoCod != null) || (this.tipopgtoCod != null && !this.tipopgtoCod.equals(other.tipopgtoCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.siscom.bean.TipoPagamentos[ tipopgtoCod=" + tipopgtoCod + " ]";
    }
    
}
