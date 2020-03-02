package modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.eclipse.persistence.annotations.Index;



@Entity
@Index(name = "Ind", columnNames="Título")
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Index
	String Titulo;
	
	@Column(name = "Num_Exemplares")
	int exemplares;
	
	@ManyToMany( mappedBy="livros", 
            fetch=FetchType.EAGER)
	private List<Autor> autores = new ArrayList<Autor>();

	@OneToMany(mappedBy = "livro", 
            cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
            orphanRemoval=true, 
            fetch=FetchType.EAGER)
	private List<Emprestimo> emp = new ArrayList<Emprestimo>();
	
	@Version
	int version;
	
	public Livro() {}
	
	public Livro(String titulo, int exem) {
		super();
		this.Titulo = titulo;
		this.exemplares = exem;
	}
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setAutores(Autor a) {
		this.autores.add(a);
	}
	public List<Autor> getAutores(){
		return autores;
	}
	public void setEmprestimo(Emprestimo e) {
		this.emp.add(e);
		e.setLivro(this);
	}
	public List<Emprestimo> getEmprestimo(){
		return emp;
	}
	public void remover(Autor a){
        autores.remove(a);
    }
	public int getTotalAutores(){
        return autores.size();
    }
	public void setQuant(int quant) {
        this.exemplares = quant;
    }
	public int getQuant() {
		return exemplares;
	}
	public void resetEmprestimo() {
		emp = null;
	}
	 public Autor localizar(String nome){
	        for(Autor a : autores){
	            if(a.getNome().equals(nome))
	                return a;
	        }
	        return null;
	    }
	 public void adicionar(Autor a){
	        autores.add(a);
	    }
	 

	@Override
	public String toString() {
		String texto="Titulo:" + Titulo +
                ", Exemplares:" + exemplares +  " autores: " ;
        if (autores == null)
            texto += "Sem autor";
        else   
            for(Autor a: autores) 
                texto += a.getNome() + ", "; 
        return texto;
 
	}
	 

}
