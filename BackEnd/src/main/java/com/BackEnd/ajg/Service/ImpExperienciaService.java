/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Service;

import com.BackEnd.ajg.Entity.Experiencia;
import com.BackEnd.ajg.Repository.IExperienciaRepository;
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
public class ImpExperienciaService {
    @Autowired
    IExperienciaRepository iExperienciaRepository;
    
    public List<Experiencia> lista(){
        return iExperienciaRepository.findAll();
    }
    
     public Optional<Experiencia> getExperiencia(Long id){
         return iExperienciaRepository.findById(id);
     }
     
     public Optional<Experiencia> getByNombreExperiencia(String nombreExperiencia){
         return iExperienciaRepository.findByNombreExperiencia(nombreExperiencia);
     }
     
     public void save(Experiencia expe){
         iExperienciaRepository.save(expe);
     }
     
     public void delete(Long id){
         iExperienciaRepository.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return iExperienciaRepository.existsById(id);
     }
     
     public boolean existsByNombreExperiencia(String nombreExperiencia){
         return iExperienciaRepository.existsByNombreExperiencia(nombreExperiencia);
     }
}
