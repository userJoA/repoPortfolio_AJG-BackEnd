/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author usuario
 */

@Getter @Setter
public class dtoExperiencia {
    @NotBlank
    private String nombreExperiencia;
    @NotBlank
    private String descripcionExperiencia;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExperiencia, String descripcionExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
        this.descripcionExperiencia = descripcionExperiencia;
    }
    
    
}
