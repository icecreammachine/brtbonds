package com.icecreammachine.brtbonds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sysparameters")
public class SysParameters {

    @Id
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "value", nullable = false, length = 30)
    private String value;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return (
            "SysParameters [code=" +
            code +
            ", value=" +
            value +
            ", description=" +
            description +
            "]"
        );
    }
}
