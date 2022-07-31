/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackEnd.ajg.Repository;

import com.BackEnd.ajg.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia,Long>{
       public Optional<Experiencia> findByNombreExperiencia(String nombreExperiencia);
       public boolean existsByNombreExperiencia(String nombreExperiencia);
}
