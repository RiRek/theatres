package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Movie extends PanacheEntity {

    @Column(length = 100)
   public String title;
    @Column(length = 200)
   public  String description;
    @Column(length = 100)
   public String director;
    @Column(length = 100)
   public String country;

}
