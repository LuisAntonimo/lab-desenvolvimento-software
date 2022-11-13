package lab04.empresa;

import javax.persistence.*;

@Entity
@Table
public class Empresa {

    @Id
    @SequenceGenerator(name = "empresa_sequence", sequenceName = "empresa_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_sequence")
    private long id;
    private String nome;
    private String cnpj;

    public Empresa() {

    }

    public Empresa(String nome, String cnpj) {
        setNome(nome);
        setCnpj(cnpj);
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
     * @return String return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "{" +
                "Id: " + getId() +
                "; Nome: " + getNome() +
                "; CNPJ: " + getCnpj() +
                "}";
    }

}
