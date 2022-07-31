/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Controller;

import com.BackEnd.ajg.Dto.dtoEducacion;
import com.BackEnd.ajg.Entity.Educacion;
import com.BackEnd.ajg.Security.Controller.MensajeController;
import com.BackEnd.ajg.Service.ImpEducacionService;
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
 * @author usuario
 */

@RestController
@RequestMapping ("/Educacion")
@CrossOrigin (origins = "https://ajg-portfolio.web.app/")
public class EducacionController {
    @Autowired
    ImpEducacionService educacionService;
    
    @GetMapping ("/List")
    public ResponseEntity <List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/Find/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id) {
        if (!educacionService.existById(id)) {
            return new ResponseEntity(new MensajeController("no existe"), HttpStatus.NOT_FOUND);
        }
            Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping ("/Create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getTitleEdu()))
            return new ResponseEntity(new MensajeController("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(educacionService.existsByTitleEdu(dtoEdu.getTitleEdu()))
            return new ResponseEntity(new MensajeController("El Titulo ingresado ya existe"), HttpStatus.BAD_REQUEST);
        Educacion educacion = new Educacion(dtoEdu.getImgEdu(), dtoEdu.getTitleEdu(), dtoEdu.getYearsEdu(),
                                            dtoEdu.getDurationEdu(), dtoEdu.getDescriptionEdu());
        educacionService.save(educacion);
        return new ResponseEntity(new MensajeController("nuevo elemento agregado"), HttpStatus.OK);
        
    }
    
    @PutMapping ("/Edit/{id}")
    public ResponseEntity<?> Edit(@PathVariable("id")long id, @RequestBody dtoEducacion dtoEdu){
        if(!educacionService.existById(id))
            return new ResponseEntity(new MensajeController("El ID no Existe"),HttpStatus.BAD_REQUEST);
        if(educacionService.existsByTitleEdu(dtoEdu.getTitleEdu()) &&  educacionService.getByTitleEdu(dtoEdu.getTitleEdu()).get().getId() !=id)
                return new ResponseEntity(new MensajeController("Esa Educación ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEdu.getTitleEdu()))
            return new ResponseEntity(new MensajeController("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        Educacion educacion = educacionService.getOne(id).get();
        educacion.setImgEdu(dtoEdu.getImgEdu());
        educacion.setTitleEdu(dtoEdu.getTitleEdu());
        educacion.setYearsEdu(dtoEdu.getYearsEdu());
        educacion.setDurationEdu(dtoEdu.getDurationEdu());
        educacion.setDescriptionEdu(dtoEdu.getDescriptionEdu());
        educacionService.save(educacion);
            return new ResponseEntity(new MensajeController("Educación Actualizada Correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/Delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!educacionService.existById(id))
            return new ResponseEntity(new MensajeController("El ID no Existe"),HttpStatus.BAD_REQUEST);
        educacionService.delete(id);
            return new ResponseEntity(new MensajeController("Educación Eliminada"), HttpStatus.OK);
    }
    
    
}
