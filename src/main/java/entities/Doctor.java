package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 private String nome;
 private String departament;
 private String phone;



    public Doctor(Long id, String nome, String departament, String phone) {
        this.id = id;
        this.nome = nome;
        this.departament = departament;
        this.phone = phone;
    }

    public Doctor(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
