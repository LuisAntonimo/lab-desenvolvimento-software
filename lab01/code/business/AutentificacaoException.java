package lab01.code.business;

@SuppressWarnings("serial")
public class AutentificacaoException extends Exception {

	public AutentificacaoException() {
		super("Erro no processo de autentificação. Por favor, verifique se você está logado");
	}

}
