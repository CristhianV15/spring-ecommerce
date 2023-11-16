package com.proyecto.ecommerce.springecommerce.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.springecommerce.models.Usuario;

import java.util.Optional;

import org.slf4j.*;

import jakarta.servlet.http.HttpSession;

@Service
public class userDetailServiceImp  implements UserDetailsService{
    @Autowired
    private IUsuarioService usuarioService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;    

    @Autowired
    HttpSession session;

    private  Logger log = LoggerFactory.getLogger(userDetailServiceImp.class);
        
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Este es el username");
        Optional<Usuario> optionalUser= usuarioService.findByEmail(username);
        if(optionalUser.isPresent()){
            log.info("Este es el id del usaioar mediante credenciales : {}", optionalUser.get().getIdUsuario());
            session.setAttribute("idusuario", optionalUser.get().getIdUsuario()); //enviar a vista el idusuario
            Usuario usuario = optionalUser.get();

            String role = getRoleFromNumber(usuario.getTipoUsuario().getIdTipoUsuario());

            return User.builder()
            .username(usuario.getNombre())
            .password(bCryptPasswordEncoder.encode(usuario.getPassword()))
            .roles(role) 
            .build();
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado con el nombre: " + username);
        }    
    }

    public String getRoleFromNumber(int roleNumber) {
        switch (roleNumber) {
            case 1:
                return "Administrador"; // Admin
            case 2:
                return "Usuario"; // Cliente
            default:
                return "Usuario"; // Por defecto, se asigna el rol de cliente
        }
    }
    
    
}