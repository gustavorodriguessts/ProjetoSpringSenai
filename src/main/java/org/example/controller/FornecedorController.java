package org.example.controller;

import org.example.entities.Fornecedor;
import org.example.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService FornecedorService;

    @GetMapping
    public List<Fornecedor> listarTodos(){
        return FornecedorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id){
        return FornecedorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse((ResponseEntity.notFound().build()) );
    }

    @PostMapping
    public ResponseEntity<Fornecedor> criar(@RequestBody Fornecedor Fornecedor){
        Fornecedor salvo = FornecedorService.salvar(Fornecedor);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id")
    public ResponseEntity<Fornecedor> atualizar(@RequestBody Long id, @RequestBody Fornecedor Fornecedor) {
        try {
            Fornecedor atualizado = FornecedorService.atualizar(id, Fornecedor);
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
            FornecedorService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
