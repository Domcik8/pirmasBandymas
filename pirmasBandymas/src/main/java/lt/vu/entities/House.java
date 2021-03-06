/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dominik Lisovski
 */
@Entity
@Table(name = "HOUSE")
@NamedQueries({
    @NamedQuery(name = "House.findAll", query = "SELECT h FROM House h"),
    @NamedQuery(name = "House.findById", query = "SELECT h FROM House h WHERE h.id = :id"),
    @NamedQuery(name = "House.findByHousereg", query = "SELECT h FROM House h WHERE h.housereg = :housereg"),
    @NamedQuery(name = "House.findByIsactive", query = "SELECT h FROM House h WHERE h.isactive = :isactive"),
    @NamedQuery(name = "House.findByStartdate", query = "SELECT h FROM House h WHERE h.startdate = :startdate"),
    @NamedQuery(name = "House.findByEnddate", query = "SELECT h FROM House h WHERE h.enddate = :enddate"),
    @NamedQuery(name = "House.findByWeekprice", query = "SELECT h FROM House h WHERE h.weekprice = :weekprice"),
    @NamedQuery(name = "House.findByNumberofplaces", query = "SELECT h FROM House h WHERE h.numberofplaces = :numberofplaces"),
    @NamedQuery(name = "House.findByOptLockVersion", query = "SELECT h FROM House h WHERE h.optLockVersion = :optLockVersion")})
public class House implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "HOUSEREG")
    private String housereg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISACTIVE")
    private int isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEEKPRICE")
    private int weekprice;
    @Column(name = "NUMBEROFPLACES")
    private Integer numberofplaces;
    @Column(name = "OPT_LOCK_VERSION")
    @Version
    private Integer optLockVersion;
    @JoinTable(name = "MULTISELECTHOUSETOSERVICE", joinColumns = {
        @JoinColumn(name = "PARENTID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CHILDID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Service> serviceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "houseversionid")
    private List<Reservation> reservationList;
    @JoinColumn(name = "OBJECTID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private ObjectTable objectid;

    public House() {
    }

    public House(Long id) {
        this.id = id;
    }

    public House(Long id, String housereg, int isactive, Date startdate, Date enddate, int weekprice) {
        this.id = id;
        this.housereg = housereg;
        this.isactive = isactive;
        this.startdate = startdate;
        this.enddate = enddate;
        this.weekprice = weekprice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHousereg() {
        return housereg;
    }

    public void setHousereg(String housereg) {
        this.housereg = housereg;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getWeekprice() {
        return weekprice;
    }

    public void setWeekprice(int weekprice) {
        this.weekprice = weekprice;
    }

    public Integer getNumberofplaces() {
        return numberofplaces;
    }

    public void setNumberofplaces(Integer numberofplaces) {
        this.numberofplaces = numberofplaces;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public ObjectTable getObjectid() {
        return objectid;
    }

    public void setObjectid(ObjectTable objectid) {
        this.objectid = objectid;
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
        if (!(object instanceof House)) {
            return false;
        }
        House other = (House) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.entities.House[ id=" + id + " ]";
    }
    
}
