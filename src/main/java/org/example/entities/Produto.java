package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SKU", nullable = false, length = 20)
    private String sku;
    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;
    @Column(name = "PRECO", nullable = false, length = 10)
    private Float preco;

    public Produto() {
    }

    public Produto(Long id, String sku, String nome, Float preco) {
        this.id = id;
        this.sku = sku;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
