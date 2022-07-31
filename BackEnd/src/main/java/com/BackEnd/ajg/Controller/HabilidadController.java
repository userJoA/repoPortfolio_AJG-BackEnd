/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Controller;

import com.BackEnd.ajg.Dto.dtoHabilidad;
import com.BackEnd.ajg.Entity.Habilidad;
import com.BackEnd.ajg.Security.Controller.MensajeController;
import com.BackEnd.ajg.Service.ImpHabilidadService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */

@RestController
@RequestMapping ("/Habilidad")
@CrossOrigin (origins = "https://ajg-portfolio.web.app/")
public class HabilidadController {
    @Autowired
    ImpHabilidadService habilidadService;
    
    @GetMapping ("/List")
    public ResponseEntity <List<Habilidad>> list(){
        List<Habilidad> list = habilidadService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/Find/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") Long id) {
        if (!habilidadService.existById(id)) {
            return new ResponseEntity(new MensajeController("no existe"), HttpStatus.NOT_FOUND);
        }
            Habilidad habilidad = habilidadService.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @PostMapping ("/Create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidad dtoHab){
        if(StringUtils.isBlank(dtoHab.getNameHab()))
            return new ResponseEntity(new MensajeController("campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(habilidadService.existsByNameHab(dtoHab.getNameHab()))
            return new ResponseEntity(new MensajeController("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        Habilidad habilidad = new Habilidad(dtoHab.getImgHab(),dtoHab.getNameHab(),dtoHab.getProgressHab());
        habilidadService.save(habilidad);
        return new ResponseEntity(new MensajeController("Nueva Habilidad agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping ("/Edit/{id}")
    public ResponseEntity<?> Edit(@PathVariable("id")long id, @RequestBody dtoHabilidad dtoHab){
        if(!habilidadService.existById(id))
            return new ResponseEntity(new MensajeController("El ID no Existe"),HttpStatus.BAD_REQUEST);
        if(habilidadService.existsByNameHab(dtoHab.getNameHab()) &&  habilidadService.getByNameHab(dtoHab.getNameHab()).get().getId() !=id)
                return new ResponseEntity(new MensajeController("El componente ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoHab.getNameHab()))
            return new ResponseEntity(new MensajeController("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        Habilidad habilidad = habilidadService.getOne(id).get();
        
        habilidad.setImgHab(dtoHab.getImgHab());
        habilidad.setNameHab(dtoHab.getNameHab());
        habilidad.setProgressHab(dtoHab.getProgressHab());
        habilidadService.save(habilidad);
            return new ResponseEntity(new MensajeController("Campo actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/Delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!habilidadService.existById(id))
            return new ResponseEntity(new MensajeController("El ID no Existe"),HttpStatus.BAD_REQUEST);
        habilidadService.delete(id);
            return new ResponseEntity(new MensajeController("componente Eliminado"), HttpStatus.OK);
    }
    
    
}
