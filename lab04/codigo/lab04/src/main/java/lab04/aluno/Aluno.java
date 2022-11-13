package lab04.aluno;

import javax.persistence.*;

import lab04.vantagem.Vantagem;

@Entity
@Table
public class Aluno {
    @Id
    @SequenceGenerator(name = "aluno_sequence", sequenceName = "aluno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_sequence")
    private long id;
    private String nome;
    private String cpf;
    private String rg;
    private String curso;
    private double saldo;

    public Aluno() {

    }

    public Aluno(String nome, String cpf, String rg, String curso, double saldo) {
        setNome(nome);
        setCpf(cpf);
        setRg(rg);
        setCurso(curso);
        setSaldo(saldo);
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return String return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return String return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return double return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void trocarMoedas(Vantagem vantegem){
        
    }

    @Override
    public String toString() {
        return "{" +
                "Id: " + getId() +
                "; Nome: " + getNome() +
                "; CPF: " + getCpf() +
                "; RG: " + getRg() +
                "; curso: " + getCurso() +
                "; saldo: " + getSaldo() +
                "}";
    }
}
