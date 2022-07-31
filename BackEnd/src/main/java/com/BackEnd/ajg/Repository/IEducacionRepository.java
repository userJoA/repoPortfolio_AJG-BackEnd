/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackEnd.ajg.Repository;

import com.BackEnd.ajg.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Long>{
    public Optional<Educacion> findByTitleEdu(String titleEdu);
    public boolean existsByTitleEdu(String titleEdu);
    
}
