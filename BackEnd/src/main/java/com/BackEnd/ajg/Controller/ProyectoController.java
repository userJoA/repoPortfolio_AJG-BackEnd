/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Controller;

import com.BackEnd.ajg.Dto.dtoProyecto;
import com.BackEnd.ajg.Entity.Proyecto;
import com.BackEnd.ajg.Service.ImpProyectoService;
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
import com.BackEnd.ajg.Security.Controller.MensajeController;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping ("/Proyecto")
@CrossOrigin (origins = "https://ajg-portfolio.web.app/")
public class ProyectoController {
    @Autowired 
    ImpProyectoService proyectoService;
    
    @GetMapping ("/List")
    public ResponseEntity <List<Proyecto>> list(){
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/Find/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id) {
        if (!proyectoService.existById(id)) {
            return new ResponseEntity(new MensajeController("no existe"), HttpStatus.NOT_FOUND);
        }
          Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping ("/Create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoPro){
        if(StringUtils.isBlank(dtoPro.getNamePro()))
            return new ResponseEntity(new MensajeController("campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(proyectoService.existsByNamePro(dtoPro.getNamePro()))
            return new ResponseEntity(new MensajeController("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        Proyecto proyecto = new Proyecto(dtoPro.getNamePro(),dtoPro.getImgPro(),dtoPro.getDescriptionPro());
        proyectoService.save(proyecto);
        return new ResponseEntity(new MensajeController("Nueva Habilidad agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping ("/Edit/{id}")
    public ResponseEntity<?> Edit(@PathVariable("id")long id, @RequestBody dtoProyecto dtoPro){
        if(!proyectoService.existById(id))
            return new ResponseEntity(new MensajeController("El ID no Existe"),HttpStatus.BAD_REQUEST);
        if(proyectoService.existsByNamePro(dtoPro.getNamePro()) &&  proyectoService.getByNameHab(dtoPro.getNamePro()).get().getId() !=id)
                return new ResponseEntity(new MensajeController("El componente ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoPro.getNamePro()))
            return new ResponseEntity(new MensajeController("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        Proyecto proyecto = proyectoService.getOne(id).get();
        
        proyecto.setNamePro(dtoPro.getNamePro());
        proyecto.setImgPro(dtoPro.getImgPro());
        proyecto.setDescriptionPro(dtoPro.getDescriptionPro());
        proyectoService.save(proyecto);
            return new ResponseEntity(new MensajeController("Campo actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/Delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!proyectoService.existById(id))
            return new ResponseEntity(new MensajeController("El ID no Existe"),HttpStatus.BAD_REQUEST);
        proyectoService.delete(id);
            return new ResponseEntity(new MensajeController("componente Eliminado"), HttpStatus.OK);
    }
    
    
 }
