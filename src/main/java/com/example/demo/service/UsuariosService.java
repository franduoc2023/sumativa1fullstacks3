package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ForoDto;
import com.example.demo.dto.UsuariosDto;
import com.example.demo.model.Foro;
import com.example.demo.model.Usuarios;

public interface UsuariosService {

    UsuariosDto createUsuarios(UsuariosDto usuariodto);

    List<UsuariosDto> getAllUsuarios();
    UsuariosDto updateUsario(Long id, UsuariosDto dto);
    void deleteUsuario(Long id);
    Usuarios login(String email, String password);
     List<ForoDto> getForosPorUsuario(Usuarios usuario);
     ForoDto comentarioForo(ForoDto foroDto, Usuarios usuario );
 }  