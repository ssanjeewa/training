/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.cps.training.models;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author sasilva
 */
@Entity
@Table(name = "customer", catalog = "ccmsystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cus_id")
    private Integer cusId;
    @Basic(optional = false)
    @Column(name = "cus_name")
    private String cusName;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "customer")
    private Collection<Inquiry> inquiryCollection;

    public Customer() {
    }

    public Customer(Integer cusId) {
        this.cusId = cusId;
    }

    public Customer(Integer cusId, String cusName) {
        this.cusId = cusId;
        this.cusName = cusName;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Inquiry> getInquiryCollection() {
        return inquiryCollection;
    }

    public void setInquiryCollection(Collection<Inquiry> inquiryCollection) {
        this.inquiryCollection = inquiryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusId != null ? cusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.cusId == null && other.cusId != null) || (this.cusId != null && !this.cusId.equals(other.cusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bv.cps.training.models.Customer[ cusId=" + cusId + " ]";
    }
    
}
