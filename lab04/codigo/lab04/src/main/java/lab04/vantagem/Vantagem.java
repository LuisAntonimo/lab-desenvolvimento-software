package lab04.vantagem;

import javax.persistence.*;

@Entity
@Table
public class Vantagem {
    @Id
    @SequenceGenerator(name = "vantagem_sequence", sequenceName = "vantagem_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vantagem_sequence")
    private long id;
    private String nome;
    private String descricao;
    private String comentario;

    public Vantagem() {

    }

    public Vantagem(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param descricao the Descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
     * @return String return the Descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return String return the comentario
     */

    public String getComentario() {
        return comentario;
    }

    /**
     * @return String return the evaluation
     */

    @Override
    public String toString() {
        return "{" +
                "Id: " + getId() +
                "; Nome: " + getNome() +
                "; Descricao: " + getDescricao() +
                "}";
    }

}
