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
@Table(name = "members", catalog = "ccmsystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Members.findAll", query = "SELECT m FROM Members m")})
public class Members implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "memid")
    private Integer memid;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "f_name")
    private String fName;
    @Column(name = "l_name")
    private String lName;
    @Column(name = "enable")
    private Short enable;
    @OneToMany(mappedBy = "recBy")
    private Collection<Inquiry> inquiryCollection;

    public Members() {
    }

    public Members(Integer memid) {
        this.memid = memid;
    }

    public Members(Integer memid, String username) {
        this.memid = memid;
        this.username = username;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public Short getEnable() {
        return enable;
    }

    public void setEnable(Short enable) {
        this.enable = enable;
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
        hash += (memid != null ? memid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Members)) {
            return false;
        }
        Members other = (Members) object;
        if ((this.memid == null && other.memid != null) || (this.memid != null && !this.memid.equals(other.memid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bv.cps.training.models.Members[ memid=" + memid + " ]";
    }
    
}
