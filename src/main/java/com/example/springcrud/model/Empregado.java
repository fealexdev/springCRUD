package com.example.springcrud.model;

import javax.persistence.*;

@Entity
@Table(name = "empregados")
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "cargo")
    private String cargo;

    @Column(nullable = false, name = "email_id")
    private String emailId;

    public Empregado() {

    }

    public Empregado(String nome, String cargo, String emailId) {
        super();
        this.nome = nome;
        this.cargo = cargo;
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}