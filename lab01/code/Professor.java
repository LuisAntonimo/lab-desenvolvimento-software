package lab01;

import java.util.ArrayList;

public class Professor extends Usuario {

    private ArrayList<Disciplina> disciplinasLecionadas;

    public Professor(String nome, String senha) {
        super(nome, senha);
    }

    // Retorna todas as disciplinas lecionadas pelo professor
    public StringBuffer listarDisciplinas() throws AutentificacaoException {
        
        StringBuffer sb = new StringBuffer();

        if (isAutenticado()) {

            for (int i = 0; i < disciplinasLecionadas.size(); i++) {
                sb.append(disciplinasLecionadas.get(i).getNome());
            }
        }
        else {
            throw new AutentificacaoException();
        }

        return sb;

    }

}