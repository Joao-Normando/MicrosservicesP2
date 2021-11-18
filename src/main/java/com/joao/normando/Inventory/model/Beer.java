package com.joao.normando.Inventory.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "Beer")
public class Beer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBeer;


    @Column(name = "name")
    private String name;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Origem origem;

    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "quantity")
    private Double quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beer)) return false;
        Beer beer = (Beer) o;
        return Objects.equals(idBeer, beer.idBeer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBeer);
    }
}
