/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author usuario
 */
@Getter @Setter
public class dtoEducacion {
    private String imgEdu;
    @NotBlank
    private String titleEdu;
    
    private Date yearsEdu;
    @NotBlank
    private String durationEdu;
    @NotBlank
    private String descriptionEdu;

    public dtoEducacion() {
    }

    public dtoEducacion(String imgEdu, String titleEdu, Date yearsEdu, String durationEdu, String descriptionEdu) {
        this.imgEdu = imgEdu;
        this.titleEdu = titleEdu;
        this.yearsEdu = yearsEdu;
        this.durationEdu = durationEdu;
        this.descriptionEdu = descriptionEdu;
    }

    
    
    
}
