package org.example.services;

import org.example.entities.Fornecedor;
import org.example.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository FornecedorRepository;

    public List<Fornecedor> listarTodos(){
        return FornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id){
        return FornecedorRepository.findById(id);
    }

    public Fornecedor salvar(Fornecedor Fornecedor){
        return FornecedorRepository.save(Fornecedor);
    }

    public Fornecedor atualizar(Long id, Fornecedor FornecedorAtualizado){
        return FornecedorRepository.findById(id)
                .map(Fornecedor -> {
                    Fornecedor.setNome(FornecedorAtualizado.getNome());
                    Fornecedor.setEmail(FornecedorAtualizado.getEmail());
                    Fornecedor.setTelefone(FornecedorAtualizado.getTelefone());
                    return FornecedorRepository.save(Fornecedor);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID "+ id));
    }

    public void deletar(Long id){
        if(!FornecedorRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado com ID "+ id);
        }
        FornecedorRepository.deleteById(id);
    }
}