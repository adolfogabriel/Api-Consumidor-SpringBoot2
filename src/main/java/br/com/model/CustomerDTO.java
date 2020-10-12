package br.com.model;

import java.sql.Date;

public class CustomerDTO {
    private Long id;
    private String endereco;
    private String cidade;
    private String uf;
    private String genero;
    private String nome;
    private String sobreNome;
    private String numCpf;
    private Date dthNascimento;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return this.sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNumCpf() {
        return this.numCpf;
    }

    public void setNumCpf(String numCpf) {
        this.numCpf = numCpf;
    }

    public Date getDthNascimento() {
        return this.dthNascimento;
    }

    public void setDthNascimento(Date dthNascimento) {
        this.dthNascimento = dthNascimento;
    }
}
