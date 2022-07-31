/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Service;

import com.BackEnd.ajg.Entity.Educacion;
import com.BackEnd.ajg.Repository.IEducacionRepository;
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
public class ImpEducacionService {
    @Autowired
    IEducacionRepository iEducacionRepository;
    
    public List<Educacion> list(){
        return iEducacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(long id){
        return iEducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByTitleEdu (String titleEdu){
        return iEducacionRepository.findByTitleEdu(titleEdu);
    }
    
    public void save(Educacion education){
        iEducacionRepository.save(education);
    }
    
    public void delete(long id){
        iEducacionRepository.deleteById(id);
    }
    
    public boolean existById(long id){
        return iEducacionRepository.existsById(id);
    }
    
    public boolean existsByTitleEdu(String titleEdu){
        return iEducacionRepository.existsByTitleEdu(titleEdu);
                
    }
    
}
