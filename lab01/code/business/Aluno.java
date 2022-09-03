package lab01.code.business;

import java.util.ArrayList;

public class Aluno extends Usuario {

	private static final int MAX_DISC_OBRIGATORIAS = 4;
	private static final int MAX_DISC_OPTATIVAS = 2;
	private Matricula matricula;
	private ArrayList<Disciplina> disciplinasCursadas;
	private float valorSemestre;

	public Aluno(String nome, String senha) {
		super(nome, senha);
		getMatricula().gerarNumeroMatricula();
	}

	// Getters

	public ArrayList<Disciplina> getDisciplinas() {
		return this.disciplinasCursadas;
	}
	
	public Matricula getMatricula() {
		return matricula;
	}

	
	public float getValorSemestre() {
		return valorSemestre;
	}


	// Setters

	public void setValorSemestre(float valorSemestre) {
		this.valorSemestre = valorSemestre;
	}

	// Mostra os dados do aluno
	public String mostrarDados() {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < disciplinasCursadas.size(); i++) {
			sb.append(" " + disciplinasCursadas.get(i).getNome());
		}

		return "Nome: " + getNome() + " || " + "Disciplinas cursadas: " + sb;
	}

	// Adiciona aluno na disciplina
	public void adicionarDisciplina(Disciplina disciplina) {
		if (disciplina.validarMatricula()) {
			disciplinasCursadas.add(disciplina);
		}
	}

	// Matricula o aluno em determinada disciplina
	public void matricular(Disciplina disciplina) throws AutentificacaoException {
		int numDiscOptativas = disciplinasCursadas.size() - quantidadeDiscObrigatorias();
		if (isAutenticado()) {
			if (disciplina.isObrigatoria() && quantidadeDiscObrigatorias() < MAX_DISC_OBRIGATORIAS) {
				adicionarDisciplina(disciplina);
			} else if (disciplina.isObrigatoria() == false && numDiscOptativas < MAX_DISC_OPTATIVAS) {
				adicionarDisciplina(disciplina);
			}
		} else {
			throw new AutentificacaoException();
		}
	}

	// Checa o número de disciplinas obrigatórias do aluno
	public int quantidadeDiscObrigatorias() {
		return (int) disciplinasCursadas.stream().filter(disc -> disc.isObrigatoria()).count();
	}

	// Cancela a matricula do aluno em determinada disciplina
	public void cancelarMatricula(Disciplina disciplina) throws AutentificacaoException {
		if (isAutenticado()) {
			if (disciplinasCursadas.contains(disciplina)) {
				disciplinasCursadas.remove(disciplina);
			}
		} else {
			throw new AutentificacaoException();
		}
	}
	
	// Valida as matérias no semestre
	
	public void validarMateriasSemestre() throws AutentificacaoException {
		for (Disciplina disciplina : disciplinasCursadas) {
			if (!(disciplina.isAtiva())) {
				this.cancelarMatricula(disciplina);
			}
		}
	}
}
