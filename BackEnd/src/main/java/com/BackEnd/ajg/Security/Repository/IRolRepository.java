/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackEnd.ajg.Security.Repository;

import com.BackEnd.ajg.Security.Entity.Rol;
import com.BackEnd.ajg.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface IRolRepository extends JpaRepository<Rol,Long>{
        Optional<Rol> findByRolNombre(RolNombre rolnombre);
        
}
