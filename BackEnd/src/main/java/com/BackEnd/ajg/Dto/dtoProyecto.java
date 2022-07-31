/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author usuario
 */
@Getter @Setter
public class dtoProyecto {
    private String namePro;
    
    private String imgPro;
    
    private String descriptionPro;

    public dtoProyecto() {
    }

    public dtoProyecto(String namePro, String imgPro, String descriptionPro) {
        this.namePro = namePro;
        this.imgPro = imgPro;
        this.descriptionPro = descriptionPro;
    }
    
    
}
