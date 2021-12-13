package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Showtime extends PanacheEntity {

    @Column(length = 100)
    public String theaterId;
    @Column(length = 200)
    public  String movieId;
    @Column(length = 100)
    public String startTime;
    @Column(length = 100)
    public String date;
}
