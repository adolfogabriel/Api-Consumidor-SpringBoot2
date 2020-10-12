package br.com.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    @Size(min = 2, max = 2)
    private String uf;

    @Column(name = "genero")
    @Size(min = 1, max = 1)
    private String genero;

    @Column(name = "nome")
    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @Column(name = "sobre_nome")
    private String sobreNome;

    @Column(name = "num_cpf")
    @NotBlank(message = "CPF obrigatório")
    @Size(min = 11, max = 11)
    private String numCpf;

    @Column(name = "dth_nascimento")
    @NotBlank(message = "Data Nascimento obrigatório")
    private java.sql.Timestamp dthNascimento;


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

    public java.sql.Timestamp getDthNascimento() {
        return this.dthNascimento;
    }

    public void setDthNascimento(java.sql.Timestamp dthNascimento) {
        this.dthNascimento = dthNascimento;
    }
}
