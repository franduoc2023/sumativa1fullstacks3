package com.example.demo.mapper;

import com.example.demo.dto.UsuariosDto;
import com.example.demo.model.Usuarios;

public class UsuariosMapper {
        public static Usuarios toEntity(UsuariosDto dto) {
        Usuarios usuario = new Usuarios();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setPassword(dto.getPassword());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setEmail(dto.getEmail());
        return usuario;
    }
    public static UsuariosDto toDto(Usuarios usuario) {
        UsuariosDto dto = new UsuariosDto();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setNombreUsuario(usuario.getNombreUsuario());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());
        dto.setEmail(usuario.getEmail());
        return dto;
    }

}
