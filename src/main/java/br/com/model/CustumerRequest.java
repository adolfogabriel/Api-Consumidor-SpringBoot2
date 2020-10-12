package br.com.model;

import java.sql.Date;

public class CustumerRequest {

    private String endereco;
    private String cidade;
    private String uf;
    private String genero;
    private String nome;
    private String sobreNome;
    private String numCpf;
    private Date dthNascimento;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNumCpf() {
        return numCpf;
    }

    public void setNumCpf(String numCpf) {
        this.numCpf = numCpf;
    }

    public Date getDthNascimento() {
        return dthNascimento;
    }

    public void setDthNascimento(Date dthNascimento) {
        this.dthNascimento = dthNascimento;
    }
}
