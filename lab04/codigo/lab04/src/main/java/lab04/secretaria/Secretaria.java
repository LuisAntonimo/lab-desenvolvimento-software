package lab04.secretaria;

import java.util.LinkedList;
import java.util.List;

import lab04.aluno.Aluno;
import lab04.professor.Professor;

public class Secretaria {
    List<Professor> professores;
    List<Aluno> alunos;
    /*List<Transacao> Transacoes;*/
    private static int MOEDAS_SEMESTRE = 1000;
    private int codigoDeEmail=0;

    public Secretaria(){
        professores = new LinkedList<>();
        alunos = new LinkedList<>();
    }

    public void pagarMoedasProfessores() {
        for (Professor professor : professores) {
            professor.setSaldo(MOEDAS_SEMESTRE+professor.getSaldo());
        }
    }

    public void gerenciarNotificacao() {
        codigoDeEmail++;
        notificarAluno(codigoDeEmail);
        notificarEmpresa(codigoDeEmail);
    }

    private String notificarEmpresa(int codigoDeEmail){
        return "Email enviado para empresa. Código: "+codigoDeEmail;
    }

    private String notificarAluno(int codigoDeEmail/* , Transicao transicao */){
        return "Email enviado para aluno. Código: "+codigoDeEmail;
    }
}
