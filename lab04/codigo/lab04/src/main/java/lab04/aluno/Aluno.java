package lab04.aluno;

import javax.persistence.*;

import lab04.usuario.Usuario;
import lab04.vantagem.Vantagem;

@Entity
@Table
public class Aluno extends Usuario {
    private String cpf;
    private String rg;
    private String curso;
    private double saldo;

    public Aluno() {

    }

    public Aluno(String nome, String email, String senha, String cpf, String rg, String curso, double saldo) {
        super(nome, email, senha);
        setCpf(cpf);
        setRg(rg);
        setCurso(curso);
        setSaldo(saldo);
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
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

    public void trocarMoedas(Vantagem vantegem) {

    }

    @Override
    public String toString() {
        return super.toString() +
                "; CPF: " + getCpf() +
                "; RG: " + getRg() +
                "; curso: " + getCurso() +
                "; saldo: " + getSaldo() +
                "}";
    }
}
