package lab04.usuario;

import javax.persistence.*;

public abstract class Usuario {
    @Id
    @SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    private long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {

    }

    public Usuario(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    /**
     * @return long return the id
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
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "{" +
                "; id: " + getId() +
                "; nome: " + getNome() +
                "; email: " + getEmail() +
                "; senha: " + getSenha();
    }

}
