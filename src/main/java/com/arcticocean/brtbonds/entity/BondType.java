package com.icecreammachine.brtbonds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bondtype")
public class BondType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bond_type", nullable = false)
    private int idBondType;

    @Column(name = "code", nullable = false, length = 5)
    private String code;

    @Column(name = "smalldesc", nullable = false, length = 15)
    private String smallDesc;

    @Column(name = "fulldesc", nullable = false, length = 40)
    private String fullDesc;

    public int getIdBondType() {
        return idBondType;
    }

    public void setIdBondType(int idBondType) {
        this.idBondType = idBondType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSmallDesc() {
        return smallDesc;
    }

    public void setSmallDesc(String smallDesc) {
        this.smallDesc = smallDesc;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    @Override
    public String toString() {
        return (
            "BondType [idBondType=" +
            idBondType +
            ", code=" +
            code +
            ", smallDesc=" +
            smallDesc +
            ", fullDesc=" +
            fullDesc +
            "]"
        );
    }
}
