package org.example.controller;

import org.example.entities.Produto;
import org.example.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService ProdutoService;

    @GetMapping
    public List<Produto> listarTodos(){
        return ProdutoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        return ProdutoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse((ResponseEntity.notFound().build()) );
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto Produto){
        Produto salvo = ProdutoService.salvar(Produto);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id")
    public ResponseEntity<Produto> atualizar(@RequestBody Long id, @RequestBody Produto Produto) {
        try {
            Produto atualizado = ProdutoService.atualizar(id, Produto);
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
            ProdutoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
