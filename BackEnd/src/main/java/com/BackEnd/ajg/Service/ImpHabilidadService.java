/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Service;

import com.BackEnd.ajg.Entity.Habilidad;
import com.BackEnd.ajg.Repository.IHabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
@Transactional
public class ImpHabilidadService {
    @Autowired
    IHabilidadRepository habilidadRepository;
    
    public List<Habilidad> list(){
        return habilidadRepository.findAll();
    }
    
    public Optional<Habilidad> getOne(long id){
        return habilidadRepository.findById(id);
    }
    
    public Optional<Habilidad> getByNameHab(String nameHab){
        return habilidadRepository.findByNameHab(nameHab);
    }
    
    public void save(Habilidad habilidad){
        habilidadRepository.save(habilidad);
    }
    
    public void delete(long id){
        habilidadRepository.deleteById(id);
    }
    
    public boolean existById(long id){
        return habilidadRepository.existsById(id);
    }
    
    public boolean existsByNameHab(String nameHab){
        return habilidadRepository.existsByNameHab(nameHab);
                
    }
    
}
