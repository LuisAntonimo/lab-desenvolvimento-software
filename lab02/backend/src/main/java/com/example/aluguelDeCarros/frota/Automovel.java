package com.example.aluguelDeCarros.frota;

public class Automovel {

    private int matricula, ano, notaCondicao;
    private String marca, modelo, placa;

    public Automovel(int matricula, int ano, int notaCondicao, String marca, String modelo, String placa) {
      this.matricula = matricula;
      this.ano = ano;
      this.notaCondicao = notaCondicao;
      this.marca = marca;
      this.modelo = modelo;
      this.placa = placa;
    }

    // getters

    public int getMatricula() {
      return matricula;
    }
   
    public int getAno() {
      return ano;
    }

    public int getNotaCondicao() {
      return notaCondicao;
    }
    
    public String getMarca() {
      return marca;
    }
    
    public String getModelo() {
      return modelo;
    }
    
    public String getPlaca() {
      return placa;
    }

    // setters

    public void setMatricula(int matricula) {
      this.matricula = matricula;
    }

    public void setAno(int ano) {
      this.ano = ano;
    }

    public void setNotaCondicao(int notaCondicao) {
      this.notaCondicao = notaCondicao;
    }

    public void setMarca(String marca) {
      this.marca = marca;
    }

    public void setModelo(String modelo) {
      this.modelo = modelo;
    }

    public void setPlaca(String placa) {
      this.placa = placa;
    }


    public void avaliarEstadoAutomovel(int notaCondicao) {
      this.setNotaCondicao(notaCondicao);
    }
}
