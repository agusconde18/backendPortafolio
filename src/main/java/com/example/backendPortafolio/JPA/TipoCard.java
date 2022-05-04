package com.example.backendPortafolio.JPA;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_card")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"cards"})
public class TipoCard {

    public TipoCard(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "tipoCard",fetch = FetchType.LAZY)
    private Set<Card> cards = new LinkedHashSet<>();

}