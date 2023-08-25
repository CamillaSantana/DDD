package com.example;

public record Chamado (String user, String codigo, String categoria, String atividade) {
    
    @Override
    public String toString(){
        return codigo + ": " + user + " - " + categoria + " - " + atividade;
    }
}