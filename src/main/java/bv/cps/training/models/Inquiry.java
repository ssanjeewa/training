/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bv.cps.training.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sasilva
 */
@Entity
@Table(name = "inquiry", catalog = "ccmsystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Inquiry.findAll", query = "SELECT i FROM Inquiry i")})
public class Inquiry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "in_id")
    private Integer inId;
    @Basic(optional = false)
    @Column(name = "report_no")
    private String reportNo;
    @Column(name = "rc_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rcDate;
    @Column(name = "rc_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rcTime;
    @Column(name = "complaint")
    private String complaint;
    @Column(name = "couse_of_inquiery")
    private String couseOfInquiery;
    @Column(name = "origin")
    private String origin;
    @Column(name = "action_taken")
    private String actionTaken;
    @Column(name = "del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date delDate;
    @Column(name = "del_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date delTime;
    @Column(name = "lead_time")
    private String leadTime;
    @JoinColumn(name = "customer", referencedColumnName = "cus_id")
    @ManyToOne
    private Customer customer;
    @JoinColumn(name = "rec_by", referencedColumnName = "memid")
    @ManyToOne
    private Members recBy;

    public Inquiry() {
    }

    public Inquiry(Integer inId) {
        this.inId = inId;
    }

    public Inquiry(Integer inId, String reportNo) {
        this.inId = inId;
        this.reportNo = reportNo;
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public Date getRcDate() {
        return rcDate;
    }

    public void setRcDate(Date rcDate) {
        this.rcDate = rcDate;
    }

    public Date getRcTime() {
        return rcTime;
    }

    public void setRcTime(Date rcTime) {
        this.rcTime = rcTime;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getCouseOfInquiery() {
        return couseOfInquiery;
    }

    public void setCouseOfInquiery(String couseOfInquiery) {
        this.couseOfInquiery = couseOfInquiery;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public Date getDelTime() {
        return delTime;
    }

    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    public String getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Members getRecBy() {
        return recBy;
    }

    public void setRecBy(Members recBy) {
        this.recBy = recBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inId != null ? inId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inquiry)) {
            return false;
        }
        Inquiry other = (Inquiry) object;
        if ((this.inId == null && other.inId != null) || (this.inId != null && !this.inId.equals(other.inId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bv.cps.training.models.Inquiry[ inId=" + inId + " ]";
    }
    
}
