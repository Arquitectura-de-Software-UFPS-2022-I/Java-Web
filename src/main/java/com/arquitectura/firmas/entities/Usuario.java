package com.arquitectura.firmas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String name;
    private String username;
    private String password;
    private String rol;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @PrePersist
    public void PrePersist(){
        this.createDate= new Date();
    }

}
