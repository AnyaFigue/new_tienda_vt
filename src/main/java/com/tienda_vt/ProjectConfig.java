/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_vt;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {

        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locate");
        slr.setTimeZoneAttributeName("session.curent.timezone");
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());

    }

    //el siguiente metodo se supera la proxima semana :D cuando usamos usuarios de bases de datos
    @Bean
    public UserDetailsService user() {
        UserDetails admin = User.builder().username("juan").password("{noop}123").roles("USER", "VENDEDOR", "ADMIN").build();//Con esto creamos un usario y definimos sus caracteristicas
        UserDetails vendedor = User.builder().username("rebeca").password("{noop}456").roles("USER", "VENDEDOR").build();//Con esto creamos un usario y definimos sus caracteristicas
        UserDetails usuario = User.builder().username("pedro").password("{noop}789").roles("USER").build();//Con esto creamos un usario y definimos sus caracteristicas
        return new InMemoryUserDetailsManager(admin, vendedor, usuario);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registro) {
        registro.addViewController("/").setViewName("index.html");
        registro.addViewController("/index").setViewName("index");
        registro.addViewController("/login").setViewName("login");
        registro.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((request) -> request
                .requestMatchers("/","/index","/webjars/**","/js/**","/registro/**")
                .permitAll()
                .requestMatchers("/categoria/listado","/producto/listado")
                .hasRole("VENDEDOR")         
                .requestMatchers("/categoria/nuevo","/categoria/modificar/**","/categoria/eliminar/**","/categoria/guardar",
                        "producto/guardar","/producto/nuevo","/producto/modificar/**","producto/eliminar**","producto/guardar","/pruebas/**")
                .hasRole("ADMIN")
        ).formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout)-> logout.permitAll());
        
        return http.build();
                
                
    }
    

    @Autowired
    private UserDetailsService userDetaulsService;
    
     @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        
        builder.userDetailsService(userDetaulsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
