/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackEnd.ajg.Security.Controller;

import com.BackEnd.ajg.Security.Dto.JwtDto;
import com.BackEnd.ajg.Security.Dto.LoginUsuario;
import com.BackEnd.ajg.Security.Dto.NuevoUsuario;
import com.BackEnd.ajg.Security.Entity.Rol;
import com.BackEnd.ajg.Security.Entity.Usuario;
import com.BackEnd.ajg.Security.Enums.RolNombre;
import com.BackEnd.ajg.Security.Service.RolService;
import com.BackEnd.ajg.Security.Service.UsuarioService;
import com.BackEnd.ajg.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private RolService rolService;
    
    @Autowired
    private JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo (@Valid @RequestBody NuevoUsuario nuevoUsuario,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity (new MensajeController("Los campos son incorrectos"),HttpStatus.BAD_REQUEST);
        }
        
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombre()))
            return new ResponseEntity(new MensajeController("El nombre Ya Existe"),HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new MensajeController("El email Ya Existe"),HttpStatus.BAD_REQUEST);
        
        Usuario usuario= new Usuario( nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(),passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new MensajeController("Nuevo Usuario Guardado"),HttpStatus.CREATED);
        
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario , BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity (new MensajeController("Los campos son incorrectos"),HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginUsuario
                .getNombreUsuario(),loginUsuario.getPassword()) );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt,userDetails.getUsername(),userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto,HttpStatus.OK);
    }
}
