/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author usuario
 */
@Entity
@Setter @Getter
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String imgEdu;
    
    

    @NotNull
    @Size(min = 1, max = 50, message = "el campo debe contener entre 1 y 50 caracteres")
    private String titleEdu;

    
    
    private Date yearsEdu;

    @NotNull
    @Size(min = 1, max = 50, message = "el campo debe contener entre 1 y 50 caracteres")
    private String durationEdu;

    @NotNull
    @Size(min = 1, max = 50, message = "el campo debe contener entre 1 y 50 caracteres")
    private String descriptionEdu;

    public Educacion() {
    }

    public Educacion(String imgEdu, String titleEdu, Date yearsEdu, String durationEdu, String descriptionEdu) {
        this.imgEdu = imgEdu;
        this.titleEdu = titleEdu;
        this.yearsEdu = yearsEdu;
        this.durationEdu = durationEdu;
        this.descriptionEdu = descriptionEdu;
    }

   
    
    

}
