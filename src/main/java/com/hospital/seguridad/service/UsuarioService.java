package com.hospital.seguridad.service;

import com.hospital.seguridad.model.LoginRequest;
import com.hospital.seguridad.model.LoginResponse;
import com.hospital.seguridad.model.Usuario;

import java.util.List;

public interface UsuarioService {
    LoginResponse login(LoginRequest loginRequest);
    Usuario registrarUsuario(Usuario usuario);
    Usuario buscarPorNombreUsuario(String nombreUsuario);
    List<Usuario> listarTodos();
}