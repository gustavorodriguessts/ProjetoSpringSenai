package org.example.services;

import org.example.entities.FormaPagamento;
import org.example.repositories.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {
    @Autowired
    private FormaPagamentoRepository FormaPagamentoRepository;

    public List<FormaPagamento> listarTodos(){
        return FormaPagamentoRepository.findAll();
    }

    public Optional<FormaPagamento> buscarPorId(Long id){
        return FormaPagamentoRepository.findById(id);
    }

    public FormaPagamento salvar(FormaPagamento FormaPagamento){
        return FormaPagamentoRepository.save(FormaPagamento);
    }

    public FormaPagamento atualizar(Long id, FormaPagamento FormaPagamentoAtualizado){
        return FormaPagamentoRepository.findById(id)
                .map(FormaPagamento -> {
                    FormaPagamento.setTipoPagamento(FormaPagamentoAtualizado.getTipoPagamento());
                    FormaPagamento.setData(FormaPagamentoAtualizado.getData());
                    FormaPagamento.setPreco(FormaPagamentoAtualizado.getPreco());
                    return FormaPagamentoRepository.save(FormaPagamento);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID "+ id));
    }

    public void deletar(Long id){
        if(!FormaPagamentoRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado com ID "+ id);
        }
        FormaPagamentoRepository.deleteById(id);
    }
}