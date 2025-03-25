package com.example.demo.mapper;

import java.time.LocalDate;
 
import com.example.demo.dto.ForoDto;
import com.example.demo.model.Foro;
import com.example.demo.model.Usuarios;

public class ForoMapper {
 
    public static ForoDto toDto(Foro foro) {
        ForoDto dtof = new ForoDto();
        dtof.setId(foro.getId());
        dtof.setComentario(foro.getComentario());
        dtof.setFechaCreacion(foro.getFechaCreacion());
        dtof.setNombreUsuario(foro.getUsuario().getNombreUsuario());
        return dtof;
    }

     public static Foro toEntity(ForoDto dto, Usuarios usuario) {
        Foro foro = new Foro();
        foro.setComentario(dto.getComentario());
        foro.setFechaCreacion(LocalDate.now());       
        foro.setUsuario(usuario);
        return foro;
    }
}


