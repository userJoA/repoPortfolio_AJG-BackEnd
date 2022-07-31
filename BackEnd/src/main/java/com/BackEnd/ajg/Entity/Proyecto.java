/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author usuario
 */

@Entity
@Setter @Getter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String namePro;
    
    private String imgPro;
    
    private String descriptionPro;

    public Proyecto() {
    }

    public Proyecto(String namePro, String imgPro, String descriptionPro) {
        this.namePro = namePro;
        this.imgPro = imgPro;
        this.descriptionPro = descriptionPro;
    }
    
    
}
