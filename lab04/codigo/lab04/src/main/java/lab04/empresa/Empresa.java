package lab04.empresa;

import javax.persistence.*;

import lab04.usuario.Usuario;

@Entity
@Table
public class Empresa extends Usuario {

    private String cnpj;

    public Empresa() {

    }

    public Empresa(String nome, String email, String senha, String cnpj) {
        super(nome, email, senha);
        setCnpj(cnpj);
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return String return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return super.toString() +
                "; CNPJ: " + getCnpj() +
                "}";
    }

}
