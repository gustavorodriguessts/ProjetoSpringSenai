package org.example.entities;

import jakarta.persistence.*;

@Entity // Declara que a classe 'Cliente' será uma entidade
public class Cliente {
    @Id // Declara a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz o BD gerar um valor para este atributo (auto_increment)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;
    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "CPF", nullable = false, length = 14)
    private String cpf;

    /*
    @Column: configurações da coluna

    name: como irá aparecer no BD

    nullable: atributo nulo?

    length: tamanho máximo de um valor

     unique: atributo único?
    */

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
