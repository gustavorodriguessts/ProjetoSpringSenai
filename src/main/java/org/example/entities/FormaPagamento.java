package org.example.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TIPOPAGAMENTO", nullable = false, length = 30)
    private String tipoPagamento;
    @Column(name = "PRECO", nullable = false, length = 10)
    private Float preco;
    @Column(name = "DATA", nullable = false, length = 10)
    private Date data;

    public FormaPagamento() {
    }

    public FormaPagamento(Long id, String tipoPagamento, Float preco, Date data) {
        this.id = id;
        this.tipoPagamento = tipoPagamento;
        this.preco = preco;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
