package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.ForoRepository;
import com.example.demo.Repository.UsuariosRepository;
import com.example.demo.dto.ForoDto;
import com.example.demo.dto.UsuariosDto;
import com.example.demo.mapper.ForoMapper;
import com.example.demo.mapper.UsuariosMapper;
import com.example.demo.model.Foro;
import com.example.demo.model.Usuarios;

@Service
public class UsuariosImpl implements UsuariosService {
    @Autowired 
    private UsuariosRepository usuariosRepository;

    @Autowired
private ForoRepository foroRepository;

  
    @Override
    public UsuariosDto createUsuarios(UsuariosDto dto) {
         Usuarios transUsuario = UsuariosMapper.toEntity(dto);
        Usuarios guardado = usuariosRepository.save(transUsuario);
        return UsuariosMapper.toDto(guardado);
    }

    @Override
    public List<UsuariosDto> getAllUsuarios() {
         List<Usuarios> usuarios = usuariosRepository.findAll();
        return usuarios.stream() .map(UsuariosMapper::toDto)   .collect(Collectors.toList());
    }
//https://stackoverflow.com/questions/75503819/mapping-stream-in-dto-or-passing-mapped-value-to-dto-separately
    @Override 
    public UsuariosDto updateUsario(Long id, UsuariosDto dto) {
        Usuarios usuarioActivo = usuariosRepository.findById(id).get(); 
        usuarioActivo.setNombre(dto.getNombre());
        usuarioActivo.setApellido(dto.getApellido());
        usuarioActivo.setNombreUsuario(dto.getNombreUsuario());
        usuarioActivo.setPassword(dto.getPassword());
        usuarioActivo.setFechaNacimiento(dto.getFechaNacimiento());
        usuarioActivo.setEmail(dto.getEmail());
        Usuarios actualizado = usuariosRepository.save(usuarioActivo);
        return UsuariosMapper.toDto(actualizado);
    }
    @Override
    public void deleteUsuario(Long id){
            if (usuariosRepository.existsById(id)){usuariosRepository.deleteById(id); }
    }

    @Override
    public Usuarios login(String email, String password) {
        return usuariosRepository.findByEmail(email)
                             .filter(u -> u.getPassword().equals(password))
            .orElse(null);
    }

public List<ForoDto> getForosPorUsuario(Usuarios usuario) {
                  List<Foro> foros = foroRepository.findByUsuario(usuario);
     return foros.stream()
                 .map(ForoMapper::toDto)
                .toList();
}
@Override
public ForoDto comentarioForo(ForoDto foroDto, Usuarios usuario) {
    Foro foro = foroRepository.findById(foroDto.getId())
            .orElseThrow(() -> new RuntimeException("Foro no encontrado"));

    foro.setComentario(foroDto.getComentario());
    foro.setFechaCreacion(LocalDate.now());
    foro.setUsuario(usuario);  
    Foro guardado = foroRepository.save(foro);

    return ForoMapper.toDto(guardado);
}







}
// Falta el password Encoder pero no se solicita para sumativa 