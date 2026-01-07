package com.example.apioci.model;

import java.math.BigDecimal;

public class Cliente {
    private String cpf;
    private String nome;
    private String investimento;
    private BigDecimal valor;
    private String status;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String investimento, BigDecimal valor, String status) {
        this.cpf = cpf;
        this.nome = nome;
        this.investimento = investimento;
        this.valor = valor;
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInvestimento() {
        return investimento;
    }

    public void setInvestimento(String investimento) {
        this.investimento = investimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
