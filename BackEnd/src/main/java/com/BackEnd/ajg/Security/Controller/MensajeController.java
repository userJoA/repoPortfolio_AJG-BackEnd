/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Security.Controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
//@Component
@Getter @Setter
public class MensajeController {
    private String mensaje;

    public MensajeController() {
    }

    public MensajeController(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    
}
