package lab01.code.business;

public class Usuario {
	private String nome;
	private String senha;
	private boolean isAutenticado = false;

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	// Getters

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public boolean isAutenticado() {
		return isAutenticado;
	}

	// Setters

	public void setAutenticado(boolean isAutenticado) {
		this.isAutenticado = isAutenticado;
	}

	// Realizar login no sistema
	public void realizarLogin(String nome, String senha) throws AutentificacaoException {
		if (isAutenticado() == false) {
			if (getNome().equals(nome) && this.senha.equals(senha)) {
				setAutenticado(true);
			}
		} else {
			throw new AutentificacaoException();
		}

	}

}
