/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_vt.service.impl;

import com.tienda_vt.dao.UsuarioDao;
import com.tienda_vt.domain.Rol;
import com.tienda_vt.domain.Usuario;
import com.tienda_vt.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author EstivenQ
 */
@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Se busca el usuario por el username
        Usuario usuario=usuarioDao.findByUsername(username);
        if(usuario==null){
            throw new UsernameNotFoundException(username);
        }
        
        //si estamosa acá, si se encontro el usuario
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        //se deben crear los roles de seguridad
        var roles=new ArrayList<GrantedAuthority>();
        //aca se devuelve el arraylist de roles y se itera por cada rol que tenga cada usuario
        for(Rol r: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        //Acá ya tenemos toda la info del usuario...
        
        
        return new User(usuario.getUsername(),usuario.getPassword(), roles);
    }
    
}
