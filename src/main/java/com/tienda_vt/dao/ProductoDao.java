package com.tienda_vt.dao;

import com.tienda_vt.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoDao extends JpaRepository<Producto, Long> {

    public List<Producto> findByPrecioBetweenOrderByPrecio(double precioInf, double precioSup);


    @Query(value = "SELECT p "
            + "FROM Producto p "
            + "WHERE p.precio "
            + "BETWEEN :precioInf and :precioSup "
            + "ORDER BY p.precio ASC")
    public List<Producto> consultaJPQL(double precioInf, double precioSup);


    @Query(nativeQuery = true, value = "SELECT * "
            + "FROM producto p"
            + " WHERE p.precio BETWEEN :precioInf and :precioSup "
            + "ORDER BY p.precio ASC")
    public List<Producto> consultaSQL(double precioInf, double precioSup);
    
    

    //acá se pone para hacer una consulta ampliada con JPA

    public List<Producto> findByExistenciasBetweenOrderByExistencias(int existenciaInf, int existenciaSup);
    //acá para que busque en un rango de precios JPQL ampliada
    //con la funcion  findByPrecioBetweenOrderByPrecio(double precioInf,double precioSup);

    @Query(value = "SELECT p "
            + "FROM Producto p "
            + "WHERE p.existencias "
            + "BETWEEN :existenciaInf and :existenciaSup "
            + "ORDER BY p.existencias ASC")

    public List<Producto> consultaJPQL_Existencias(int existenciaInf, int existenciaSup);
    //acá para que haga una busqueda ampliada en un rango de precios CON SQL NATIVA


    @Query(nativeQuery = true, value = "SELECT * "
            + "FROM producto p"
            + " WHERE p.existencias BETWEEN :existenciaInf and :existenciaSup "
            + "ORDER BY p.existencias ASC")
    public List<Producto> consultaSQL_Existencias(int existenciaInf, int existenciaSup);

}
