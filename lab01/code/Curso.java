package lab01.code;

import java.util.ArrayList;

public class Curso {
    
    private String nome;
    private int numCreditos;
    private ArrayList<Disciplina> disciplinas;

    public Curso(String nome, int creditos){
        this.nome = nome;
        this.numCreditos = creditos;

    }

    // Lista as disciplinas do curso
    public String listarDisciplinas(){
        return "";
    }
    
}
