package com.hospital.seguridad.service;

import com.hospital.seguridad.dao.BitacoraDAO;
import com.hospital.seguridad.dao.UsuarioDAO;
import com.hospital.seguridad.model.Bitacora;
import com.hospital.seguridad.model.LoginRequest;
import com.hospital.seguridad.model.LoginResponse;
import com.hospital.seguridad.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private BitacoraDAO bitacoraDAO;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<Usuario> usuarioOpt = usuarioDAO.findByNombreUsuarioAndContrasena(
                loginRequest.getNombreUsuario(),
                loginRequest.getContrasena()
        );

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            Bitacora bitacora = new Bitacora();
            bitacora.setIdUsuario(usuario.getIdUsuario());
            bitacora.setAccion("Login exitoso");
            bitacora.setFechaHora(LocalDateTime.now());
            bitacoraDAO.save(bitacora);

            return new LoginResponse(
                    true,
                    "Login exitoso",
                    usuario.getIdUsuario(),
                    usuario.getNombreUsuario(),
                    usuario.getRol()
            );
        } else {
            return new LoginResponse(false, "Usuario o contraseña incorrectos", null, null, null);
        }
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        return usuarioDAO.findByNombreUsuario(nombreUsuario).orElse(null);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioDAO.findAll();
    }
}