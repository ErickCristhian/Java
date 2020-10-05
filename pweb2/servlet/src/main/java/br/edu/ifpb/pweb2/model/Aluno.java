
package br.edu.ifpb.pweb2.model;

public class Aluno {
	private String nome;
	private String matricula;
	private int cre;
	
	public Aluno() {
		//Padrão para POJO
	}
	public Aluno(String nome, String matricula, int cre) {
		this.nome = nome;
		this.matricula = matricula;
		this.cre = cre;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getCre() {
		return cre;
	}
	public void setCre(int cre) {
		this.cre = cre;
	}
	
	
}
