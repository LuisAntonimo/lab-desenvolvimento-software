package lab01.code;

public class Matricula {

    private Curso curso;
    private static int ID;
    private int identificador;

    // Mostra relatorio contendo dados da matricula
    public String mostrarRelatorio(){
        return "";
    }

    // Getters 

    public Curso getCurso() {
        return curso;
    }

    public int getIdentificador() {
        return identificador;
    }

    // Gera número de matrícula
    public void gerarNumeroMatricula(){
        this.identificador = ID++;
        this.ID++;

    }
    
}
