package lab01.code.business;

import java.util.ArrayList;

public class Secretaria {

	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Disciplina> curriculoSemestre = new ArrayList<Disciplina>();

	// Notifica financeiro para cobrança do aluno

	public void notificarFinanceiro(Aluno aluno) {
		Financeiro.calcularCobranca(aluno);
	}

	// Cria disciplina 

	public void criarDisciplina(String nome, boolean isObrigatoria, int cargaHoraria, Professor professor, int creditos,
			float custo, Curso curso) throws CursoInexistenteException {
		Disciplina disciplina = new Disciplina(nome, isObrigatoria, cargaHoraria, professor, creditos, custo);
		if (!(this.cursos.contains(curso)))
			throw new CursoInexistenteException(curso.getNome());
		else
			curso.adicionarDisciplina(disciplina);
	}

	// Cria curso 

	public void criarCurso(String nome, int creditos) {
		this.cursos.add(new Curso(nome, creditos));
	}

	// Cadastra aluno 

	public void cadastrarAluno(String nome, String senha) {
		alunos.add(new Aluno(nome, senha));
	}

	// Cadastra professor

	public void cadastrarProfessor(String nome, String senha) {
		professores.add(new Professor(nome, senha));
	}

	// Adiciona Disciplina no semestre
	
	public void addDisciplinaSemestre(Disciplina disciplina) {
		curriculoSemestre.add(disciplina);
	}
	
	//como eu faria o 'toString' poliformicozasso? ou mesmo o 'add' polimorficozasso?
	
	
	

}