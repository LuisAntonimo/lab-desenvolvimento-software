package lab01.code.business;

public class Financeiro {

	public static void calcularCobranca(Aluno aluno) {
		float valorFinal = 0;
		for (Disciplina disciplina : aluno.getDisciplinas()) {
			valorFinal += disciplina.getCusto();
		}
		enviarCobranca(aluno, valorFinal);
	}

	private static void enviarCobranca(Aluno aluno, float valorFinal) {
		aluno.setValorSemestre(valorFinal);
	}
}
