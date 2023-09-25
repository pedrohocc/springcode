package main.java.projeto.clinica.models;

@Entity
@Table(name = "tb_fisioterapeuta")
public class Fisioterapeuta {
    @id
    @generetedValue
    private long id;
    private String coffito;
    private string cpf;
    private String nome;
    private String email;
    
    @Embedded 
    private Endereço endereço;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoffito() {
        return coffito;
    }

    public void setCoffito(String coffito) {
        this.coffito = coffito;
    }

    public string getCpf() {
        return cpf;
    }

    public void setCpf(string cpf) {
        this.cpf = cpf;
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

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
    }
}