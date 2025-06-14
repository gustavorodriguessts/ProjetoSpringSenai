package org.example.controller;

import org.example.entities.Cliente;
import org.example.entities.FormaPagamento;
import org.example.services.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{formaPagamento}")

public class FormaPagamentoController {

    @Autowired
    FormaPagamentoService formaPagamentoService;

    @GetMapping
    public List<FormaPagamento> listarTodos(){
        return formaPagamentoService.listarTodos();
    }

    @GetMapping
    public ResponseEntity<FormaPagamento> buscarPorId(@PathVariable Long id){
        return formaPagamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FormaPagamento> criar(@RequestBody FormaPagamento formaPagamento) {
        FormaPagamento salvo = formaPagamentoService.salvar(formaPagamento);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long id, @RequestBody FormaPagamento formaPagamento) {
        try {
            FormaPagamento atualizado = formaPagamentoService.atualizar(id, formaPagamento);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FormaPagamento> deletar(@PathVariable Long id) {
        try{
            formaPagamentoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
