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
 * @author user
 */
@Getter
@Setter
public class dtoHabilidad {

    @NotBlank
    private String imgHab;
    @NotBlank
    private String nameHab;
    @NotBlank
    private int progressHab;

    public dtoHabilidad() {
    }

    public dtoHabilidad(String imgHab, String nameHab, int progressHab) {
        this.imgHab = imgHab;
        this.nameHab = nameHab;
        this.progressHab = progressHab;
    }
    
    
}
