package lab04.transacao;

import javax.persistence.*;

public class Transacao {
  @Id
  private long idAluno, idProfessor, id;
  private double quantia;
  private String justificativa;

  public Transacao(long idAluno, long idProfessor, double quantia) {
    setIdAluno(idAluno);
    setIdProfessor(idProfessor);
    setQuantia(quantia);
    setJustificativa(justificativa);
  }

  public Transacao() {}

  //Getters

  /**
     * @return long return the id
     */
    public long getId() {
      return id;
  }

  public long getIdAluno() {
    return idAluno;
  }
 
  public long getIdProfessor() {
    return idProfessor;
  }
 
  public double getQuantia() {
    return quantia;
  }
 
  public String getJustificativa() {
    return justificativa;
  }

  //Setters

  public void setIdAluno(long idAluno) {
    this.idAluno = idAluno;
  }

  public void setIdProfessor(long idProfessor) {
    this.idProfessor = idProfessor;
  }

  public void setQuantia(double quantia) {
    this.quantia = quantia;
  }

  public void setJustificativa(String justificativa) {
    this.justificativa = justificativa;
  }

  String enviarEmail() {
    return "Email enviado";
  }

  @Override
    public String toString() {
        return "{" +
                "; idAluno: " + getIdAluno() +
                "; idProfessor: " + getIdProfessor() +
                "; quantia: " + getQuantia() +
                "; justificativa: " + getJustificativa();
    }
}
