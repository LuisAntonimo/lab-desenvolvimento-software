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

    // getters/setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
    }

    //

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    // Lista as disciplinas do curso
    public StringBuffer listarDisciplinas(){

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < disciplinas.size(); i++) {
            sb.append(disciplinas.get(i).getNome());
        }

        return sb;
    }

    // Adicionar disciplina a lista
    public void adicionarDisciplina(Disciplina nova){
        this.getDisciplinas().add(nova);
    }

    
    
}
