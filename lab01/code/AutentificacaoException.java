package lab01;

@SuppressWarnings("serial")
public class AutentificacaoException extends Exception {

	public AutentificacaoException() {
		super("Erro no processo de autentificação. Por favor, verifique se você está logado");
	}

}
