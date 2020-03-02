package modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.eclipse.persistence.annotations.Index;

@Entity
@Table(name = "Pessoa")
@Index(name = "Ind", columnNames="Nome")
public class Pessoa {
	
	@Id
	@Column(name = "CPF")
	String CPF;
	@Index
	@Column(name = "Nome")
	String Nome;
	@Column(name = "Endereco")
	String Endereço;


	@OneToMany( mappedBy = "pessoa",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
            orphanRemoval=true, 
            fetch=FetchType.EAGER)
	ArrayList<Emprestimo> emp = new ArrayList<Emprestimo>();
	
	@Version
	int version;
	
	public Pessoa() {}
	
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
	public void removerEmprestimo(Emprestimo e) {
		this.emp.remove(e);
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
