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
 * @author user
 */
@Entity
@Setter @Getter
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String imgHab;
    private String nameHab;
    private int progressHab;

    public Habilidad() {
    }

    public Habilidad(String imgHab, String nameHab, int progressHab) {
        this.imgHab = imgHab;
        this.nameHab = nameHab;
        this.progressHab = progressHab;
    }
    
    
}
