package modelo;

import java.util.ArrayList;

public class Pessoa {
	String Nome;
	String CPF;
	String Endereço;
	ArrayList<Emprestimo> emp = new ArrayList<Emprestimo>();
	
	public Pessoa(String nome, String cpf, String Endereco) {
		super();
		this.Nome = nome;
		this.CPF = cpf;
		this.Endereço = Endereco;
	}

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getEndereco() {
		return Endereço;
	}
	public void setEndereco(String endereco) {
		this.Endereço = endereco;
	}
	public void setEmprestimo(Emprestimo e) {
		this.emp.add(e);
	}
	public ArrayList<Emprestimo> getEmprestimo(){
		return emp;
	}
	@Override
	public String toString() {
		String classe = getClass().getSimpleName() + ":";
		String texto =  String.format("%10s", classe)  + 
				" nome=" + String.format("%10s", Nome) + 
				" CPF=" + String.format("%10s", CPF) +
				" Endere�o=" + String.format("%10s", Endereço);
		return texto;
	}
}
