package com.example.model;

public class Contato {
    
    private Integer id;
    private String nome;
    private String numero;
    private String email;
    private Grupo grupo;
    
    public Contato(Integer id, String nome, String numero, String email, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.grupo = grupo;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public Contato nome(String nome){
        this.nome = nome;
        return this;
    }
    
    public Contato numero(String numero){
        this.numero = numero;
        return this;
    }
    
    public Contato email(String email){
        this.email = email;
        return this;
    }

    public Grupo getGrupo() {
        return this.grupo;
    }


    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
    