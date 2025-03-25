package com.example.demo.controller;

import com.example.demo.Repository.ForoRepository;
import com.example.demo.dto.ForoDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UsuariosDto;
import com.example.demo.model.Foro;
import com.example.demo.model.Usuarios;
import com.example.demo.service.UsuariosService;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
@Autowired
private ForoRepository foroRepository;
    @Autowired
    private UsuariosService usuariosservice;

    @PostMapping("/registro")
    public ResponseEntity<UsuariosDto> crearUsuario(@RequestBody UsuariosDto usuarioDto) {
        UsuariosDto usuarioGuardado = usuariosservice.createUsuarios(usuarioDto);
        return ResponseEntity.ok(usuarioGuardado);
    }

    @GetMapping
    public ResponseEntity<List<UsuariosDto>> obtenerUsuarios() {
        List<UsuariosDto> usuarios = usuariosservice.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UsuariosDto> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody UsuariosDto usuarioDto) {
        
        UsuariosDto actualizado = usuariosservice.updateUsario(id, usuarioDto);
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
    usuariosservice.deleteUsuario(id);
    return ResponseEntity.ok().build();
 }


@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody LoginDto loginDTO, HttpSession session) {
    Usuarios usuario = usuariosservice.login(loginDTO.getEmail(), loginDTO.getPassword());

    if (usuario != null) {
        session.setAttribute("usuarioLogueado", usuario);
        return ResponseEntity.ok("loginId " + usuario.getEmail());
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}
 
    @GetMapping("/foro")
    public ResponseEntity<List<ForoDto>> obtenerForosDelUsuario(HttpSession session) {
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioLogueado");

       

        List<ForoDto> forosDelUsuario = usuariosservice.getForosPorUsuario(usuario);
        return ResponseEntity.ok(forosDelUsuario);
    }


    @PostMapping("/foro")
    public ResponseEntity<String> agregarComentarioAlForo(
            @RequestBody ForoDto foroDto,
            HttpSession session) {
    
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioLogueado");
    
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Salta el Security rutas");
        }
    
        Foro foro = new Foro();
        foro.setComentario(foroDto.getComentario());
        foro.setFechaCreacion(LocalDate.now());
        foro.setUsuario(usuario);  
        foroRepository.save(foro);
    
        return ResponseEntity.ok("Poste correcto");
    }
    

    

}


