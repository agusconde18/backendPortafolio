package com.example.backendPortafolio.JPA;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Card  {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 200)
    private String titulo;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imageSource")
    private String imageSource;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_creator")
    private User userCreator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_card")
    private TipoCard tipoCard;

    public void updateCard(Card c2){
        titulo=c2.titulo;
        descripcion=c2.descripcion;
        imageSource=c2.imageSource;
        userCreator=c2.userCreator;
        tipoCard=c2.tipoCard;
    }


}