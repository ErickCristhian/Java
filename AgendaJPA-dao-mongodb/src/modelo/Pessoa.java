package modelo;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;


@Entity 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Pessoa {
	@Id		
	@GeneratedValue
	@Field(name="_id")		//chave
	private String id;
	private String nome;
	//@Column(columnDefinition = "DATE")	//columnDefinition="TIMESTAMP"
	private LocalDate dtcadastro = LocalDate.now();
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Version
	private int versao;

	// RELACIONAMENTO BIDIRECIONAL
	@OneToMany(	mappedBy="pessoa", 
				cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
				orphanRemoval=true, 
				fetch=FetchType.LAZY)
	private List<Telefone> telefones = new ArrayList<>();

	//construtor vazio
	public Pessoa (){}


	public Pessoa(String nome, Sexo sexo) {
		super();
		this.nome = nome;
		this.sexo = sexo;
	}
	

	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public void adicionar(Telefone t){
		telefones.add(t);
		t.setPessoa(this);
	}
	public void remover(Telefone t){
		telefones.remove(t);
		t.setPessoa(null);
	}
	public Telefone localizar(String numero){
		for(Telefone t : telefones)
			if(t.getNumero().equals(numero)) 
				return t;

		return null;			
	}

	public String toString() {
		String texto ;
		texto = "id="+id + ", nome=" + String.format("%10s", nome) + ", "	+ "cadastro=" + dtcadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) ; 
		texto += ",sexo="+sexo;
		texto += ", telefones:";
		for(Telefone t : telefones)
			texto+= t.getNumero() + ", ";

		return texto;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
}
