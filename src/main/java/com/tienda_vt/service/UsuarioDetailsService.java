/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_vt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author EstivenQ
 */
public interface UsuarioDetailsService {
    //Esto hace los mismo que estaba en projectConfig
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
}
