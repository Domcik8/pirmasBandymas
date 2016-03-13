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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;

/**
 *
 * @author Dominik Lisovski
 */
@Entity
@Table(name = "OBJECTTABLE")
@NamedQueries({
    @NamedQuery(name = "ObjectTable.findAll", query = "SELECT o FROM ObjectTable o"),
    @NamedQuery(name = "ObjectTable.findById", query = "SELECT o FROM ObjectTable o WHERE o.id = :id"),
    @NamedQuery(name = "ObjectTable.findByInternalname", query = "SELECT o FROM ObjectTable o WHERE o.internalname = :internalname"),
    @NamedQuery(name = "ObjectTable.findByIsdeleted", query = "SELECT o FROM ObjectTable o WHERE o.isdeleted = :isdeleted"),
    @NamedQuery(name = "ObjectTable.findByCreateddate", query = "SELECT o FROM ObjectTable o WHERE o.createddate = :createddate"),
    @NamedQuery(name = "ObjectTable.findByDeleteddate", query = "SELECT o FROM ObjectTable o WHERE o.deleteddate = :deleteddate"),
    @NamedQuery(name = "ObjectTable.findByOptLockVersion", query = "SELECT o FROM ObjectTable o WHERE o.optLockVersion = :optLockVersion")})
public class ObjectTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "INTERNALNAME")
    private String internalname;
    @Column(name = "ISDELETED")
    private Integer isdeleted;
    @Column(name = "CREATEDDATE")
    @Temporal(TemporalType.DATE)
    private Date createddate;
    @Column(name = "DELETEDDATE")
    @Temporal(TemporalType.DATE)
    private Date deleteddate;
    @Column(name = "OPT_LOCK_VERSION")
    @Version
    private Integer optLockVersion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "objectid")
    private Role role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personid")
    private List<Payment> paymentList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "objectid")
    private Payment payment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<Person> personList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "objectid")
    private Person person;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personid")
    private List<Reservation> reservationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "houseid")
    private List<Reservation> reservationList1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "objectid")
    private Reservation reservation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "objectid")
    private Service service;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "objectid")
    private House house;
    @OneToMany(mappedBy = "deletedby")
    private List<ObjectTable> objecttableList;
    @JoinColumn(name = "DELETEDBY", referencedColumnName = "ID")
    @ManyToOne
    private ObjectTable deletedby;
    @OneToMany(mappedBy = "createdby")
    private List<ObjectTable> objecttableList1;
    @JoinColumn(name = "CREATEDBY", referencedColumnName = "ID")
    @ManyToOne
    private ObjectTable createdby;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeid")
    private List<ObjectTable> objecttableList2;
    @JoinColumn(name = "TYPEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ObjectTable typeid;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "objectid")
    private Type type;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "objectid")
    private Systemparameter systemparameter;

    public ObjectTable() {
    }

    public ObjectTable(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInternalname() {
        return internalname;
    }

    public void setInternalname(String internalname) {
        this.internalname = internalname;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getDeleteddate() {
        return deleteddate;
    }

    public void setDeleteddate(Date deleteddate) {
        this.deleteddate = deleteddate;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public List<Reservation> getReservationList1() {
        return reservationList1;
    }

    public void setReservationList1(List<Reservation> reservationList1) {
        this.reservationList1 = reservationList1;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<ObjectTable> getObjectTableList() {
        return objecttableList;
    }

    public void setObjectTableList(List<ObjectTable> objecttableList) {
        this.objecttableList = objecttableList;
    }

    public ObjectTable getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(ObjectTable deletedby) {
        this.deletedby = deletedby;
    }

    public List<ObjectTable> getObjectTableList1() {
        return objecttableList1;
    }

    public void setObjectTableList1(List<ObjectTable> objecttableList1) {
        this.objecttableList1 = objecttableList1;
    }

    public ObjectTable getCreatedby() {
        return createdby;
    }

    public void setCreatedby(ObjectTable createdby) {
        this.createdby = createdby;
    }

    public List<ObjectTable> getObjectTableList2() {
        return objecttableList2;
    }

    public void setObjectTableList2(List<ObjectTable> objecttableList2) {
        this.objecttableList2 = objecttableList2;
    }

    public ObjectTable getTypeid() {
        return typeid;
    }

    public void setTypeid(ObjectTable typeid) {
        this.typeid = typeid;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Systemparameter getSystemparameter() {
        return systemparameter;
    }

    public void setSystemparameter(Systemparameter systemparameter) {
        this.systemparameter = systemparameter;
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
        if (!(object instanceof ObjectTable)) {
            return false;
        }
        ObjectTable other = (ObjectTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.entities.ObjectTable[ id=" + id + " ]";
    }
    
}
