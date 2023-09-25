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
}