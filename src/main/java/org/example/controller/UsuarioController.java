package org.example.controller;

import org.example.entities.Usuario;
import org.example.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse((ResponseEntity.notFound().build()) );
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario){
        Usuario salvo = usuarioService.salvar(usuario);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id")
    public ResponseEntity<Usuario> atualizar(@RequestBody Long id, @RequestBody Usuario usuario) {
        try {
            Usuario atualizado = usuarioService.atualizar(id, usuario);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            {
                return ResponseEntity.notFound().build();
            }
        }
    }
    
    @DeleteMapping("/{id")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            usuarioService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
