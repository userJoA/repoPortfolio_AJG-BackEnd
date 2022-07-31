/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Service;

import com.BackEnd.ajg.Entity.Persona;
import com.BackEnd.ajg.Interface.IPersonaService;
import com.BackEnd.ajg.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class ImpPersonaService implements IPersonaService{

    @Autowired
    private IPersonaRepository personaRepository;
    
    
    @Override
    public List<Persona> listaPersonas() {
        List<Persona> personas= personaRepository.findAll();
        return personas;
    }

    @Override
    public Persona getPersona() {
        return new Persona();
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersonaPorId(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona buscarPorId(Long id) {
        Persona personaBuscada=personaRepository.findById(id).orElse(null);
        return personaBuscada;
    }
    
}
