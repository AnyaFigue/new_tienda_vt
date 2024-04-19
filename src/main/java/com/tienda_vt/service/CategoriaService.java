
package com.tienda_vt.service;

import com.tienda_vt.domain.Categoria;
import java.util.List;


public interface CategoriaService {

    /*
    Se define la firma del metodo que recupera la lista de objetos tipo categoria de la tabla Categoria
     */
    public List<Categoria> getCategorias(boolean activos);

    /*se define la firma del metodo para recuperar un registro de tabla categoria,
    recuperando el registro que tiene el idCategoria, si no lo encuentra retorna null
     */
    public Categoria getCategoria(Categoria categoria);

    /*se define la firma del metodo para actualizar un registro de tabla categoria,
    recuperando el registro que tiene el idCategoria, si no lo encuentra retorna null
     */
    public void save(Categoria categoria);

    /*se define la firma del metodo para eliminar un registro de tabla categoria,
     si no lo encuentra retorna null
     */
    public void delete(Categoria categoria);
}
