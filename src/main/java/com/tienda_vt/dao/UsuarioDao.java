
package com.tienda_vt.dao;


import com.tienda_vt.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao  extends JpaRepository<Usuario, Long>{
    
    public Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);
    
    //valida 
    boolean existsByUsernameOrCorreo(String username, String correo);
    
}
