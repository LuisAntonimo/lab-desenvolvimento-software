package lab04.aluno;

import javax.persistence.*;

@Entity
@Table
public class Aluno {
    @Id
    @SequenceGenerator(name = "aluno_sequence", sequenceName = "aluno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_sequence")
    private long id;
    private String nome;
    private String email;

    public Aluno() {

    }

    public Aluno(String nome, String email) {
        setNome(nome);
        setEmail(email);
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return int return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "{" +
                "Id: " + getId() +
                "; Nome: " + getNome() +
                "; Email: " + getEmail() +
                "}";
    }

}
