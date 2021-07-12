package br.com.erickaraujo.api.productlist.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  String name;

    @Column
    private String description;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    private void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

}
