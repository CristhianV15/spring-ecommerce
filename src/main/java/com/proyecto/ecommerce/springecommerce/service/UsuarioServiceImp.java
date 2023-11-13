package com.proyecto.ecommerce.springecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.springecommerce.models.Producto;
import com.proyecto.ecommerce.springecommerce.models.Usuario;
import com.proyecto.ecommerce.springecommerce.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService{

    @Autowired
    private IUsuarioRepository  usuarioRepository;

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
        }

    @Override
    public Usuario save(Usuario usuario) {
       return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> get(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> findAll() {
       return usuarioRepository.findAll();  
    }
    
    
    
}
