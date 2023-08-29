package com.example;

public record Chamado (String user, String codigo, String categoria, String atividade) {
    
    @Override
    public String toString(){
        return "Código " + codigo + ": " + user + " - " + categoria + " - Status: " + atividade;
    }

   
}