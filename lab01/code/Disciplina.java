package lab01.code;

public class Disciplina {

    private static final int MIN_ALUNOS = 3;
    private static final int MAX_ALUNOS = 60;
    private boolean isObrigatoria;
    private boolean isAtiva;
    private int cargaHoraria;
    private Professor professor;
    private int creditos;
    private float custo;
    
    public Disciplina(){

    }

    // Lista todos os alunos matriculados na disciplina
    public String listarAlunos(){
        return "";
    }
}