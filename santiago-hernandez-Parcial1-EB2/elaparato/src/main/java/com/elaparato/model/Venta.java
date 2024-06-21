package com.elaparato.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_venta;
    private Date fecha;
    //@OneToMany(mappedBy="venta")
    @ManyToMany (mappedBy = "listaVentas", cascade = CascadeType.MERGE)
    private List<Producto> listaProductos;

}
