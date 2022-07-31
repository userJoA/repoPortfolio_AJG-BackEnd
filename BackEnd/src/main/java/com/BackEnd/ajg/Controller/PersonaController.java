/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Controller;


import com.BackEnd.ajg.Entity.Persona;
import com.BackEnd.ajg.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class PersonaController {
    @Autowired
    private IPersonaService iPersonaService;
    
    @GetMapping("/persona/lista")
    public List<Persona> listaPersonas(){
        return iPersonaService.listaPersonas();
    }
    
    
    /*CRUD*/
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/nuevo")
    public String nuevaPersona(@RequestBody Persona persona ){
         iPersonaService.savePersona(persona);
         return "Persona agregada";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/eliminar/{id}")
    public String eliminarPersona(@PathVariable ("id") Long id){
        iPersonaService.deletePersonaPorId(id);
        return "Persona Eliminada";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                 @RequestParam("nombre")String nombre,
                                 @RequestParam("apellido")String apellido,
                                 @RequestParam("descripcion")String descripcion)
                                {
                                    
       Persona personaBusacada= iPersonaService.buscarPorId(id);
       personaBusacada.setNombre(nombre);
       personaBusacada.setApellido(apellido);
       personaBusacada.setDescripcion(descripcion);
       
       iPersonaService.savePersona(personaBusacada);
       return personaBusacada;
       
       
    }
    
    
    @GetMapping("/persona/buscar/{id}")
   public Persona buscarPersona1(@PathVariable ("id") Long id){
       Persona personaBuscada= iPersonaService.buscarPorId(id);
       return personaBuscada;
    }
}
