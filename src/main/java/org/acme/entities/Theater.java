package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Theater extends PanacheEntity {

    @Column(length = 100)
    public String name;
    @Column(length = 200)
    public  String address;
    @Column(length = 100)
    public String city;
    @Column(length = 100)
    public String state;

}
