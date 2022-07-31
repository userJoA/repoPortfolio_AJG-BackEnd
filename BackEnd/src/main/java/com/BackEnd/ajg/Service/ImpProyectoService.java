/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Service;

import com.BackEnd.ajg.Entity.Proyecto;
import com.BackEnd.ajg.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
@Transactional
public class ImpProyectoService {
    @Autowired
    IProyectoRepository proyectoRepository;
    
    public List<Proyecto> list(){
        return proyectoRepository.findAll();
    }
    
    public Optional<Proyecto> getOne(long id){
        return proyectoRepository.findById(id);
    }
    
    public Optional<Proyecto> getByNameHab(String namePro){
        return proyectoRepository.findByNamePro(namePro);
    }
    
    public void save(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }
    
    public void delete(long id){
        proyectoRepository.deleteById(id);
    }
    
    public boolean existById(long id){
        return proyectoRepository.existsById(id);
    }
    
    public boolean existsByNamePro(String namePro){
        return proyectoRepository.existsByNamePro(namePro);
    }
                
}
