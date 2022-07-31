/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Controller;

import com.BackEnd.ajg.Dto.dtoExperiencia;
import com.BackEnd.ajg.Entity.Experiencia;
import com.BackEnd.ajg.Security.Controller.MensajeController;
import com.BackEnd.ajg.Service.ImpExperienciaService;
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
@RequestMapping("/experiencia/")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    @Autowired
    ImpExperienciaService experienciaService;

    @GetMapping("list")
    public ResponseEntity<List<Experiencia>> lista() {
        List<Experiencia> listaExperiencia = experienciaService.lista();
        return new ResponseEntity(listaExperiencia, HttpStatus.OK);
    }

    @GetMapping("getExperiencia/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new MensajeController("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = experienciaService.getExperiencia(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new MensajeController("no existe"), HttpStatus.NOT_FOUND);
        }
        experienciaService.delete(id);
        return new ResponseEntity(new MensajeController("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreExperiencia())) {
            return new ResponseEntity(new MensajeController("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaService.existsByNombreExperiencia(dtoexp.getNombreExperiencia())) {
            return new ResponseEntity(new MensajeController("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoexp.getNombreExperiencia(), dtoexp.getDescripcionExperiencia());
        experienciaService.save(experiencia);

        return new ResponseEntity(new MensajeController("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Long id, @RequestBody dtoExperiencia dtoexp) {

        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new MensajeController("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (experienciaService.existsByNombreExperiencia(dtoexp.getNombreExperiencia()) && experienciaService.getByNombreExperiencia(dtoexp.getNombreExperiencia()).get().getId() != id) {
            return new ResponseEntity(new MensajeController("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoexp.getNombreExperiencia())) {
            return new ResponseEntity(new MensajeController("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaService.getExperiencia(id).get();
        experiencia.setNombreExperiencia(dtoexp.getNombreExperiencia());
        experiencia.setDescripcionExperiencia((dtoexp.getDescripcionExperiencia()));

        experienciaService.save(experiencia);
        return new ResponseEntity(new MensajeController("Experiencia actualizada"), HttpStatus.OK);

    }

}
