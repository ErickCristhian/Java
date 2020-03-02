package modelo;

import java.util.ArrayList;




public class Livro {
	String Titulo;
	int exemplares;
	ArrayList<Autor> autores = new ArrayList<Autor>();
	ArrayList<Emprestimo> emp = new ArrayList<Emprestimo>();
	
	public Livro(String titulo, int exem) {
		super();
		this.Titulo = titulo;
		this.exemplares = exem;
	}
	
	public String getTitulo() {
		return Titulo;
	}
	public void setAutores(Autor a) {
		this.autores.add(a);
	}
	public ArrayList<Autor> getAutores(){
		return autores;
	}
	public void setEmprestimo(Emprestimo e) {
		this.emp.add(e);
	}
	public ArrayList<Emprestimo> getEmprestimo(){
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
