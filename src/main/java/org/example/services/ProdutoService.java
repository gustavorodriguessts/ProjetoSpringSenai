package org.example.services;

import org.example.entities.Produto;
import org.example.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository ProdutoRepository;

    public List<Produto> listarTodos(){
        return ProdutoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){
        return ProdutoRepository.findById(id);
    }

    public Produto salvar(Produto Produto){
        return ProdutoRepository.save(Produto);
    }

    public Produto atualizar(Long id, Produto ProdutoAtualizado){
        return ProdutoRepository.findById(id)
                .map(Produto -> {
                    Produto.setNome(ProdutoAtualizado.getNome());
                    Produto.setSku(ProdutoAtualizado.getSku());
                    Produto.setPreco(ProdutoAtualizado.getPreco());
                    return ProdutoRepository.save(Produto);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID "+ id));
    }

    public void deletar(Long id){
        if(!ProdutoRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado com ID "+ id);
        }
        ProdutoRepository.deleteById(id);
    }
}