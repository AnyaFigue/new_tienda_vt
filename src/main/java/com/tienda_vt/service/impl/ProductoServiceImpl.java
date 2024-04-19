package com.tienda_vt.service.impl;

import com.tienda_vt.dao.ProductoDao;
import com.tienda_vt.domain.Producto;
import com.tienda_vt.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Aqui se obtiene la informacion de una lista
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();

        if (activos) {
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    //acá para que busque en un rango de precios 
    //con la funcion  findByPrecioBetweenOrderByPrecio(double precioInf,double precioSup);
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPA(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByPrecio(precioInf, precioSup);

    }

    //acá para que busque en un rango de precios JPQL ampliada
    //con la funcion  findByPrecioBetweenOrderByPrecio(double precioInf,double precioSup);
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPQL(double precioInf, double precioSup) {
        return productoDao.consultaJPQL(precioInf, precioSup);
    }

    //acá para que haga una busqueda ampliada en un rango de precios CON SQL NATIVA
    //con la funcion  findByPrecioBetweenOrderByPrecio(double precioInf,double precioSup);
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaSQL(double precioInf, double precioSup) {
        return productoDao.consultaSQL(precioInf, precioSup);
    }

    @Override
     @Transactional(readOnly = true)
    public List<Producto> consultaJPA_Existencias(int existenciaInf, int existenciaSup) {
        return productoDao.findByExistenciasBetweenOrderByExistencias(existenciaInf, existenciaSup);
    }

    @Override
    public List<Producto> consultaJPQL_Existencias(int existenciaInf, int existenciaSup) {
        return productoDao.consultaJPQL_Existencias(existenciaInf, existenciaSup);
    }

    @Override
    public List<Producto> consultaSQL_Existencias(int existenciaInf, int existenciaSup) {
        return productoDao.consultaSQL_Existencias(existenciaInf, existenciaSup);

    }
    

}
