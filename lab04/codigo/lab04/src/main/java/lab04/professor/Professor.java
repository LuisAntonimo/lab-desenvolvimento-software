package lab04.professor;

import javax.persistence.*;

import lab04.usuario.Usuario;

@Entity
@Table
public class Professor extends Usuario {

    private String cpf;
    private double saldo;

    public Professor() {
        super();
    }

    public Professor(String nome, String email, String senha, String cpf, double saldo) {
        super(nome, email, senha);
        setCpf(cpf);
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

    @Override
    public String toString() {
        return super.toString() +
                "; CPF: " + getCpf() +
                "}";
    }

}
