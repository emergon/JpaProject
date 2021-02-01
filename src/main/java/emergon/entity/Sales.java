/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s")
    , @NamedQuery(name = "Sales.findByScode", query = "SELECT s FROM Sales s WHERE s.scode = :scode")
    , @NamedQuery(name = "Sales.findByQuant", query = "SELECT s FROM Sales s WHERE s.quant = :quant")
    , @NamedQuery(name = "Sales.findByCost", query = "SELECT s FROM Sales s WHERE s.cost = :cost")
    , @NamedQuery(name = "Sales.findBySdate", query = "SELECT s FROM Sales s WHERE s.sdate = :sdate")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scode")
    private Integer scode;
    @Column(name = "quant")
    private Integer quant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "sdate")
    @Temporal(TemporalType.DATE)
    private Date sdate;
    @JoinColumn(name = "pcode", referencedColumnName = "pcode")
    @ManyToOne(optional = false)
    private Product pcode;
    @JoinColumn(name = "smcode", referencedColumnName = "scode")
    @ManyToOne
    private Salesman smcode;

    public Sales() {
    }

    public Sales(Integer scode) {
        this.scode = scode;
    }

    public Integer getScode() {
        return scode;
    }

    public void setScode(Integer scode) {
        this.scode = scode;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Product getPcode() {
        return pcode;
    }

    public void setPcode(Product pcode) {
        this.pcode = pcode;
    }

    public Salesman getSmcode() {
        return smcode;
    }

    public void setSmcode(Salesman smcode) {
        this.smcode = smcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scode != null ? scode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.scode == null && other.scode != null) || (this.scode != null && !this.scode.equals(other.scode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emergon.entity.Sales[ scode=" + scode + " ]";
    }
    
}
