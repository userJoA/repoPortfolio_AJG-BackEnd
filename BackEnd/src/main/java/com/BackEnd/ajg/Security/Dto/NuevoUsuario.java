/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Security.Dto;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
//@Component
@Getter @Setter
public class NuevoUsuario {
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();

    public NuevoUsuario() {
    }

    public NuevoUsuario(String nombre, String nombreUsuario, String email, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }
    
    
}
