/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackEnd.ajg.Repository;

import com.BackEnd.ajg.Entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad, Long>{
    public Optional<Habilidad> findByNameHab(String nameHab);
    public boolean existsByNameHab(String nameHab);
    
}
