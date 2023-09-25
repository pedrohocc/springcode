package main.java.projeto.clinica.models;

import java.sql.Date;

@Entity
@Table(name = "tb_fisioterapeuta")
public class Agendamento {
    @id
    @generetedValue
    private long id;
    private Date data;
    private Fisioterapeuta Fisioterapeuta;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Fisioterapeuta getFisioterapeuta() {
        return Fisioterapeuta;
    }
    public void setFisioterapeuta(Fisioterapeuta fisioterapeuta) {
        Fisioterapeuta = fisioterapeuta;
    }
}
