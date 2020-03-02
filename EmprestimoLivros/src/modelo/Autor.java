package modelo;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.eclipse.persistence.annotations.Index;


@Entity
@EntityListeners(Trigger.class)
@Table(name = "Autor")
@Index(name = "Ind", columnNames="Nome")
public class Autor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Index
	@Column(name = "Nome")
	String Nome;
	
	@ManyToMany
	ArrayList<Livro> livros = new ArrayList<Livro>();
	
	@Version
	int version;
	
	public Autor() {}
	
	public Autor(String nome) {
		super();
		this.Nome = nome;
	}
	public int getID() {
		return id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public void setLivro(Livro livro) {
		this.livros.add(livro);
	}
	public ArrayList<Livro> getLivro(){
		return livros;
	}
	 public void remover(Livro l){
	        livros.remove(l);
	}
	 public ArrayList<Livro> getLivros() {
	        return livros;
	}
	 public void adicionar(Livro l){
	        livros.add(l);
	    }
	 
	 public String toString() {
	        String texto="nome:" + String.format("%8s", Nome) +
	                ", tot. livros:" + livros.size() +  " livros:" ;
	        if (livros.isEmpty())
	            texto += "Sem livros";
	        else   
	            for(Livro a: livros) 
	                texto += a.getTitulo() + ", "; 
	        return texto;
	 
	    } 
}
