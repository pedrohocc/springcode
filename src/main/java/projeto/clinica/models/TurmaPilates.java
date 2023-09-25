package main.java.projeto.clinica.models;

@Entity
@Table(name = "tb_turma_pilates")
public class TurmaPilates {
    @id
    @generetedValue
    private long id;
    private String turno;
}
