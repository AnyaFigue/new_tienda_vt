
package com.tienda_vt.dao;


import com.tienda_vt.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao  extends JpaRepository<Usuario, Long>{
    
    public Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);
    
    //valida si existe ya un registro con dicho nombre o correo
    boolean existsByUsernameOrCorreo(String username, String correo);
    
}