package com.icecreammachine.brtbonds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bonds_history_link")
public class BondHistoryLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbond_hist_link", nullable = false)
    private int idBondHistoryLink;

    @Column(name = "year", nullable = false)
    private int year;

    @ManyToOne
    @JoinColumn(name = "id_bond_type")
    private BondType bondType;

    @Column(name = "link", nullable = false, length = 255)
    private String link;

    public int getIdBondHistoryLink() {
        return idBondHistoryLink;
    }

    public void setIdBondHistoryLink(int idBondHistoryLink) {
        this.idBondHistoryLink = idBondHistoryLink;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BondType getBondType() {
        return bondType;
    }

    public void setBondType(BondType bondType) {
        this.bondType = bondType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return (
            "BondHistoryLink [idBondHistoryLink=" +
            idBondHistoryLink +
            ", year=" +
            year +
            ", bondType=" +
            bondType +
            ", link=" +
            link +
            "]"
        );
    }
}
