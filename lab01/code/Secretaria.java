package lab01;

import java.util.ArrayList;

public class Secretaria {

	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Disciplina> curriculoSemestre = new ArrayList<Disciplina>();

	public void notificarFinanceiro(Aluno aluno) {
		Financeiro.calcularCobranca(aluno);
	}

	public void criarDisciplina(String nome, boolean isObrigatoria, int cargaHoraria, Professor professor, int creditos,
			float custo, Curso curso) throws CursoInexistenteException {
		Disciplina disciplina = new Disciplina(nome, isObrigatoria, cargaHoraria, professor, creditos, custo);
		if (!(this.cursos.contains(curso)))
			throw new CursoInexistenteException(curso.getNome());
		else
			curso.adicionarDisciplina(disciplina);
	}

	public void criarCurso(String nome, int creditos) {
		this.cursos.add(new Curso(nome, creditos));
	}

	public void cadastrarAluno(String nome, String senha) {
		alunos.add(new Aluno(nome, senha));
	}

	public void cadastrarProfessor(String nome, String senha) {
		professores.add(new Professor(nome, senha));
	}

	public void addDisciplinaSemestre(Disciplina disciplina) {
		curriculoSemestre.add(disciplina);
	}
	
	//como eu faria o 'toString' poliformicozasso? ou mesmo o 'add' polimorficozasso?
	
	
	

}