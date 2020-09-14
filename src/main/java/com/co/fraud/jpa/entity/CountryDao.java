package com.co.fraud.jpa.entity;


import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

/**
 * Model of table based on DB
 *
 * @author Iván García
 * @version v1
 */

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "country_statistics")
public class CountryDao implements Serializable {

    private static final long serialVersionUID = 3215833037118051878L;

    @Id
    @Basic
    @NotNull
    @Column(name = "ID")
    private UUID id;

    @Column(name = "CODE_COUNTRY")
    private String numberCode;

    @Column(name = "DISTANCE_COUNTRY")
    private double distanceCountry;

    @Column(name = "NAME_COUNTRY")
    private String nameCountry;

    @Column(name = "INVOKE")
    private int numberTimes;


}
