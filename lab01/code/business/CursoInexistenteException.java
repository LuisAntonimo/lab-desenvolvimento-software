package lab01.code.business;

@SuppressWarnings("serial")
public class CursoInexistenteException extends Exception {

	public String nomeCurso;

	public CursoInexistenteException(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getMassage() {
		return "O curso " + nomeCurso
				+ " nao foi encontrado no banco de dados. Tente cria-lo antes  de adicionar a disciplina";
	}
}
