package com.example.aluguelDeCarros.utilizador;

public abstract class Usuario {
    private String email, senha;

    public String getEmail() {
      return email;
    }

    public String getSenha() {
      return senha;
    }


    public void setEmail(String email) {
      this.email = email;
    }

    public void setSenha(String senha) {
      this.senha = senha;
    }

    
    public void logar(String email, String senha) {

    }

    public void cadastrar(String email, String senha) {
      this.setEmail(email);
      this.setSenha(senha);
    }

    public void modificarPedido() {};

    private boolean isValido() {
      return true;
    }
}
