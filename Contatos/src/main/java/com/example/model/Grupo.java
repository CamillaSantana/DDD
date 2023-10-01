package com.example.model;

public class Grupo {
    private Integer id;
    private String nome;

    public Grupo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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
    
    public Grupo nome(String nome){
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return nome;
    }
}
