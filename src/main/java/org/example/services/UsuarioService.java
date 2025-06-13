package org.example.services;

import org.example.entities.Usuario;
import org.example.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado){
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    usuario.setSenha(usuarioAtualizado.getSenha());
                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID "+ id));
    }

    public void deletar(Long id){
        if(!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado com ID "+ id);
        }
        usuarioRepository.deleteById(id);
    }
}