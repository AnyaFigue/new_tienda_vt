package com.tienda_vt.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "Rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//La base de datos genera autmaticamente el IdCategoria
    
    @Column(name = "id_rol")
    private Long idRol;
    private String nombre;
    @Column(name = "id_usuario")
    private Long idUsuario;

    @OneToMany
    @JoinColumn(name = "id_categoria", updatable = false)
    private List<Producto> productos;
}

