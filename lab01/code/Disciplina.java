package lab01.code;

public class Disciplina {

    private static final int MIN_ALUNOS = 3;
    private static final int MAX_ALUNOS = 60;
    private String nome;
    private boolean isObrigatoria;
    private boolean isAtiva;
    private int cargaHoraria;
    private Professor professor;
    private int creditos;
    private float custo;
    private ArrayList<Aluno> alunos;
    
    public Disciplina(){

    }

    // Getters

    public String getNome() {
        return nome;
    }

    public boolean isObrigatoria() {
        return isObrigatoria;
    }

    public boolean isAtiva() {
        return isAtiva;
    }

    // Setters

    // Lista todos os alunos matriculados na disciplina
    public String listarAlunos(){

        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < alunos.size(); i++) {
            sb.append(alunos.get(i).getNome());
        }

        return sb;
    }
}
