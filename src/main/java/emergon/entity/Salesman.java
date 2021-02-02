/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "salesman")
@NamedQueries(value = {
    @NamedQuery(name = "Salesman.findAll", query = "SELECT s FROM Salesman s"),//Query is written in JPQL 
    @NamedQuery(name = "Salesman.findBySname", query = "SELECT s FROM Salesman s WHERE s.sname = :onoma")
})
public class Salesman implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scode")
    private Integer scode;
    @Column(name = "sname")
    private String sname;
    @Column(name = "scity")
    private String scity;
    @Column(name = "scomm")
    private double scomm;
    @OneToMany(mappedBy = "salesman", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Family> familyMembers;

    public Salesman() {
    }

    public Salesman(Integer scode) {
        this.scode = scode;
    }

    public Salesman(String sname, String scity, double scomm) {
        this.sname = sname;
        this.scity = scity;
        this.scomm = scomm;
        this.familyMembers = new ArrayList();
    }

    public Salesman(Integer scode, String sname) {
        this.scode = scode;
        this.sname = sname;
    }

    public Integer getScode() {
        return scode;
    }

    public void setScode(Integer scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public double getScomm() {
        return scomm;
    }

    public void setScomm(double scomm) {
        this.scomm = scomm;
    }

    public List<Family> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<Family> familyMembers) {
        this.familyMembers = familyMembers;
    }
    
    public void addFamilyMember(Family family){
        if(familyMembers == null){
            familyMembers = new ArrayList();
        }
        familyMembers.add(family);
        family.setSalesman(this);
        System.out.println(family.getFname()+" has salesman:"+family.getSalesman());
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
        if (!(object instanceof Salesman)) {
            return false;
        }
        Salesman other = (Salesman) object;
        if ((this.scode == null && other.scode != null) || (this.scode != null && !this.scode.equals(other.scode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Salesman[ scode=").append(scode)
                .append(", sname=").append(sname)
                .append(", scity=").append(scity)
                .append("]");
        return builder.toString();
    }
    
}
