package org.example.services;

import org.example.entities.Cliente;
import org.example.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository ClienteRepository;

    public List<Cliente> listarTodos(){
        return ClienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){
        return ClienteRepository.findById(id);
    }

    public Cliente salvar(Cliente Cliente){
        return ClienteRepository.save(Cliente);
    }

    public Cliente atualizar(Long id, Cliente ClienteAtualizado){
        return ClienteRepository.findById(id)
                .map(Cliente -> {
                    Cliente.setNome(ClienteAtualizado.getNome());
                    Cliente.setEmail(ClienteAtualizado.getEmail());
                    Cliente.setCpf(ClienteAtualizado.getCpf());
                    return ClienteRepository.save(Cliente);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID "+ id));
    }

    public void deletar(Long id){
        if(!ClienteRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado com ID "+ id);
        }
        ClienteRepository.deleteById(id);
    }
}