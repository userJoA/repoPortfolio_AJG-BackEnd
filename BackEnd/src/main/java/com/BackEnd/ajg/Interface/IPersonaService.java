/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackEnd.ajg.Interface;

import com.BackEnd.ajg.Entity.Persona;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IPersonaService {
    public List<Persona> listaPersonas();
    
    public Persona getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersonaPorId(Long id);
    
    public Persona buscarPorId(Long id);
    
}
