/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_vt.service;

import com.tienda_vt.domain.Producto;
import java.util.List;


/**
 *
 * @author EstivenQ
 */
public interface ProductoService {

    /*
    Se define la firma del metodo que recupera la lista de objetos tipo producto de la tabla Producto
     */
    public List<Producto> getProductos(boolean activos);

    /*se define la firma del metodo para recuperar un registro de tabla producto,
    recuperando el registro que tiene el idProducto, si no lo encuentra retorna null
     */
    public Producto getProducto(Producto producto);

    /*se define la firma del metodo para actualizar un registro de tabla producto,
    recuperando el registro que tiene el idProducto, si no lo encuentra retorna null
     */
    public void save(Producto producto);

    /*se define la firma del metodo para eliminar un registro de tabla producto,
     si no lo encuentra retorna null
     */
    public void delete(Producto producto);

    public List<Producto> consultaJPA(double precioInf, double precioSup);

    //acá para que busque en un rango de precios JPQL ampliada
    //con la funcion  findByPrecioBetweenOrderByPrecio(double precioInf,double precioSup);
   
    public List<Producto> consultaJPQL(double precioInf, double precioSup);

    //acá para que haga una busqueda ampliada en un rango de precios CON SQL NATIVA
    //con la funcion  findByPrecioBetweenOrderByPrecio(double precioInf,double precioSup);
   
    public List<Producto> consultaSQL(double precioInf, double precioSup);
    
    
    
      public List<Producto> consultaJPA_Existencias(int existenciaInf, int existenciaSup);

    //acá para que busque en un rango de precios JPQL ampliada
    //con la funcion  findByPrecioBetweenOrderByPrecio(double precioInf,double precioSup);
   
    public List<Producto> consultaJPQL_Existencias(int existenciaInf, int existenciaSup);

    //acá para que haga una busqueda ampliada en un rango de precios CON SQL NATIVA
    //con la funcion  findByPrecioBetweenOrderByPrecio(double precioInf,double precioSup);
   
    public List<Producto> consultaSQL_Existencias(int existenciaInf, int existenciaSup);

}
