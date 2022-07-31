/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Security.Service;

import com.BackEnd.ajg.Security.Entity.Usuario;
import com.BackEnd.ajg.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
@Transactional
public class UsuarioService {

    
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iUsuarioRepository.existsByEmail(email);
       
    }
    public void save(Usuario u){
        iUsuarioRepository.save(u);
    }

    
}
