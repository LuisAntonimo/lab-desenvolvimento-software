package lab01;

import java.util.ArrayList;

public class Disciplina {

	private static final int MIN_ALUNOS = 3;
	private static final int MAX_ALUNOS = 60;
	private String nome;
	private boolean isObrigatoria;
	/* private boolean isAtiva; */
	private int cargaHoraria;
	private Professor professor;
	private int creditos;
	private float custo;
	private ArrayList<Aluno> alunos;

	public Disciplina() {
	}

	public Disciplina(String nome, boolean isObrigatoria, int cargaHoraria, Professor professor, int creditos,
			float custo) {
		this.nome = nome;
		this.isObrigatoria = isObrigatoria;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
		this.creditos = creditos;
		this.custo = custo;
	}

	// Getters

	public String getNome() {
		return nome;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public int getCreditos() {
		return creditos;
	}

	public float getCusto() {
		return custo;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public boolean isObrigatoria() {
		return isObrigatoria;
	}

	public boolean isAtiva() {
		return alunos.size() >= MIN_ALUNOS && alunos.size() <= MAX_ALUNOS;
	}

	// Setters

	/*
	 * public void ativarDisciplina() { this.isAtiva = true; }
	 * 
	 * public void desativarDisciplina() { this.isAtiva = false; }
	 */

	// Lista todos os alunos matriculados na disciplina
	public StringBuffer listarAlunos() {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < alunos.size(); i++) {
			sb.append(alunos.get(i).getNome());
		}

		return sb;
	}

	// Valida a matrícula do aluno

	public boolean validarMatricula() {
		if (getAlunos().size() < MAX_ALUNOS) {
			return true;
		} else {
			return false;
		}

	}

	// Iniciar disciplina

	/*
	 * public void iniciarDisciplina() { if (alunos.size() >= MIN_ALUNOS) {
	 * ativarDisciplina(); } }
	 */

	// Mostrar relatório

	public String mostrarRelatorio() {
		return "Nome da disciplina: " + getNome() + " || Professor: " + professor.getNome() + " || Créditos: "
				+ getCreditos() + " || Custo: " + getCusto() + " || Carga horária: " + getCargaHoraria()
				+ " || Status ativa: " + isAtiva() + " || Obrigatória: " + isObrigatoria();
	}
}
