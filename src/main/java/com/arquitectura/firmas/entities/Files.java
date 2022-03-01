package com.arquitectura.firmas.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Lob
    @Column(name = "file", columnDefinition="BLOB")
    private byte[] file;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @PrePersist
    public void PrePersist(){
        this.createDate= new Date();
    }
}