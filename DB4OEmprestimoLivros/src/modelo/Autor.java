package modelo;

import java.util.ArrayList;

public class Autor {
	String Nome;
	ArrayList<Livro> livros = new ArrayList<Livro>();
	
	public Autor(String nome) {
		super();
		this.Nome = nome;
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
