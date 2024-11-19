package com.icecreammachine.brtbonds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "issued_bonds")
public class IssuedBond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_issued_bond", nullable = false)
    private int idIssuedBond;

    @ManyToOne
    @JoinColumn(name = "id_bond_type")
    private BondType bondType;

    @Column(name = "maturity_date", nullable = false)
    private Date maturityDate;

    @Column(name = "code", nullable = false, length = 24, unique = true)
    private String code;

    public int getIdIssuedBond() {
        return idIssuedBond;
    }

    public void setIdIssuedBond(int idIssuedBond) {
        this.idIssuedBond = idIssuedBond;
    }

    public BondType getBondType() {
        return bondType;
    }

    public void setBondType(BondType bondType) {
        this.bondType = bondType;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return (
            "IssuedBond [idIssuedBond=" +
            idIssuedBond +
            ", bondType=" +
            bondType +
            ", maturityDate=" +
            maturityDate +
            ", code=" +
            code +
            "]"
        );
    }
}
