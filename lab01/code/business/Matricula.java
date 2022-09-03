package lab01.code.business;

public class Matricula {

	private Curso curso;
	private static int GERADOR_ID;
	private int id;

	// Mostra relatorio contendo dados da matricula
	public String mostrarRelatorio() {
		return "";
	}

	// Getters

	public Curso getCurso() {
		return curso;
	}

	public int getIdentificador() {
		return id;
	}

	// Gera número de matrícula
	public void gerarNumeroMatricula() {
		this.id = GERADOR_ID++;
	}

}
