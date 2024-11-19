package com.icecreammachine.brtbonds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bonds_history_data")
public class BondHistoryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bond_history", nullable = false)
    private int idBondHistory;

    @ManyToOne
    @JoinColumn(name = "id_issued_bond")
    private IssuedBond issuedBond;

    @Column(name = "hist_date", nullable = false)
    private Date histDate;

    @Column(name = "rate_buy", nullable = false, precision = 5, scale = 2)
    private BigDecimal rateBuy;

    @Column(name = "rate_sell", nullable = false, precision = 5, scale = 2)
    private BigDecimal rateSell;

    @Column(name = "pu_buy", nullable = false, precision = 15, scale = 2)
    private BigDecimal puBuy;

    @Column(name = "pu_sell", nullable = false, precision = 15, scale = 2)
    private BigDecimal puSell;

    @Column(name = "pu_base", precision = 15, scale = 2)
    private BigDecimal puBase;

    public int getIdBondHistory() {
        return idBondHistory;
    }

    public void setIdBondHistory(int idBondHistory) {
        this.idBondHistory = idBondHistory;
    }

    public IssuedBond getIssuedBond() {
        return issuedBond;
    }

    public void setIssuedBond(IssuedBond issuedBond) {
        this.issuedBond = issuedBond;
    }

    public Date getHistDate() {
        return histDate;
    }

    public void setHistDate(Date histDate) {
        this.histDate = histDate;
    }

    public BigDecimal getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(BigDecimal rateBuy) {
        this.rateBuy = rateBuy;
    }

    public BigDecimal getRateSell() {
        return rateSell;
    }

    public void setRateSell(BigDecimal rateSell) {
        this.rateSell = rateSell;
    }

    public BigDecimal getPuBuy() {
        return puBuy;
    }

    public void setPuBuy(BigDecimal puBuy) {
        this.puBuy = puBuy;
    }

    public BigDecimal getPuSell() {
        return puSell;
    }

    public void setPuSell(BigDecimal puSell) {
        this.puSell = puSell;
    }

    public BigDecimal getPuBase() {
        return puBase;
    }

    public void setPuBase(BigDecimal puBase) {
        this.puBase = puBase;
    }

    @Override
    public String toString() {
        return (
            "BondHistoryData [idBondHistory=" +
            idBondHistory +
            ", issuedBond=" +
            issuedBond +
            ", histDate=" +
            histDate +
            ", rateBuy=" +
            rateBuy +
            ", rateSell=" +
            rateSell +
            ", puBuy=" +
            puBuy +
            ", puSell=" +
            puSell +
            ", puBase=" +
            puBase +
            "]"
        );
    }
}
