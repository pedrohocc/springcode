package main.java.projeto.clinica.models;

import java.sql.Date;

@Entity
@Table(name = "tb_fisioterapeuta")
public class Agendamento {
    @id
    @generetedValue
    private long id;
    private Date data;
}
