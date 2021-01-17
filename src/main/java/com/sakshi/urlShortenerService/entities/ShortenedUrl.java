package com.sakshi.urlShortenerService.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name="shorten_url", uniqueConstraints={@UniqueConstraint(columnNames={"code"})})
@Data
public class ShortenedUrl extends BaseEntity {
    @Column(name="code")
    private String code;

    @Column(name="url")
    private String url;

    @Column(name="hits")
    private Long hits;

    @Column(name = "expiration_date")
    private Date expirationDate;

    //TODO code for concurrency
    public void increaseHits(){
        this.hits += 1;
    }
}

