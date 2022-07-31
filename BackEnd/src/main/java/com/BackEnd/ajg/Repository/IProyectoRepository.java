/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackEnd.ajg.Repository;

import com.BackEnd.ajg.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Long>{
    public Optional<Proyecto> findByNamePro(String namePro);
    public boolean existsByNamePro(String namePro);
}
