package fachada;
 
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.DAOdb4o;
import dao.DAOAutordb4o;
import dao.DAOEmprestimodb4o;
import dao.DAOLivrodb4o;
import dao.DAOPessoadb4o;
import modelo.Autor;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Pessoa;

public class Fachada {
    private static DAOPessoadb4o daopessoa = new DAOPessoadb4o();  
    private static DAOAutordb4o daoautor = new DAOAutordb4o();  
    private static DAOLivrodb4o daolivro = new DAOLivrodb4o();
    private static DAOEmprestimodb4o daoemprestimo = new DAOEmprestimodb4o();
	private static Livro l;
 
 
    public static void inicializar(){
        DAOdb4o.open();
    }
    public static void finalizar(){
        DAOdb4o.close();
    }
 
   //Fun��es de Pessoa
    public static String consultarLivroEmEmprestimoPorPessoa(String nome) {
    	DAOdb4o.begin();
    	List<Pessoa> p = daopessoa.consultarPessoasPorParteNome(nome);
    	String texto = "";
    	if(p == null)
    		return "Pessoa n�o cadastrada";
    	
    	for(Pessoa pe: p) {
    		ArrayList<Emprestimo> emp = pe.getEmprestimo();
    		texto += pe.getNome();
    		texto += " tem o(s) seguinte(s) livro(s): ";
    		for(Emprestimo e : emp) {
    			texto += e.getLivro().getTitulo();
    		}
    		texto += "\ncadastrado nos seus empr�stimos";
    	}
    	return texto;
    	
    	
    }
    public static String consultarNumeroDeEmprestimo(String nome) {
    	DAOdb4o.begin();
    	List<Pessoa> p = daopessoa.consultarPessoasPorParteNome(nome);
    	String texto = "";
    	if(p == null)
    		return "Pessoa n�o cadastrada";
    	for(Pessoa pe: p) {
    		texto += pe.getNome();
    		texto += " tem " + pe.getEmprestimo().size() + " Emprestimos registrados";
    	}
    	return texto; 	
    }
    
    public static void cadastrarPessoa(String nome, String CPF, String Endereco) throws  Exception{
    	DAOdb4o.begin();
    	Pessoa p = daopessoa.read(nome);
        if(p != null)
            throw new Exception("cadastrar pessoa - pessoa ja cadastrado:" + nome);
        p = new Pessoa(nome, CPF, Endereco);
        daopessoa.create(p);    
        DAOdb4o.commit();
    }
    public static Pessoa encontrarPessoa(String nome) throws Exception{
    	DAOdb4o.begin();
    	Pessoa p = daopessoa.read(nome);
    	if(p == null)
    		throw new Exception("Pessoa N�o Cadastrada");
    	return p;
    }


    public static void alterarPessoa(String nome, String novonome) throws Exception{
        DAOdb4o.begin();        
        Pessoa p = daopessoa.read(nome);    
        if (p==null)
            throw new Exception("alterar pessoa - nome inexistente:" + nome);
        p.setNome(novonome);            
        p = daopessoa.update(p);      
        DAOdb4o.commit();   
    }
    
 
    public static void excluirPessoa(String n) throws Exception {
        DAOdb4o.begin();
        Pessoa p = daopessoa.read(n);
        if (p==null) 
            throw new Exception("excluir pessoa - nome inexistente:" + n);
        daopessoa.delete(p);
        DAOdb4o.commit();
    }
 
 
    public void excluirPessoaManualmente(String nome) throws Exception{
        DAOdb4o.begin();
        Pessoa p = daopessoa.read(nome);    
        if(p==null)
            throw new Exception("excluir pessoa - nome inexistente:" + nome);
        daopessoa.delete(p);      
        DAOdb4o.commit();
    }
    
    public static ArrayList<Pessoa> listarPessoas(){
        List<Pessoa> pessoas = daopessoa.readAll();
        ArrayList<Pessoa> texto = new ArrayList<Pessoa>();
        for (Pessoa pe : pessoas) {
            texto.add(pe);
        }
        return texto;
    }
    public static String consultarPessoasPorParteNome(String caracteres) {
		List<Pessoa> result = daopessoa.consultarPessoasPorParteNome(caracteres);

		String texto = "\nConsultar pessoas por parte do nome:"+caracteres;
		if (result == null)  
			texto += "consulta vazia";
		else 
			for(Pessoa p: result)texto += "\n" + p;
		return texto;
	}
 
    //Fun��es de Autor
    
    public static void cadastrarAutor(String nome) throws Exception{
    	DAOdb4o.begin();
    	Autor a = daoautor.read(nome);
    	if(a != null)
    		throw new Exception("cadastrar autor - autor ja cadastrado:" + nome);
        a = new Autor(nome);
        daoautor.create(a);    
        DAOdb4o.commit();
    }
    public static ArrayList<Autor> listarAutores(){
    	List<Autor> aut = daoautor.readAll();
    	ArrayList<Autor> texto = new ArrayList<Autor>();
        for (Autor a : aut) {
            texto.add(a);
        }
        return texto;
    }
    public static void excluirAutor(String Nome)  throws  Exception {
        DAOdb4o.begin();
        Autor autor = daoautor.read(Nome);
        if(autor == null)
            throw new Exception("Autor nao cadastrado:" + Nome);
 
        for (Livro livro : autor.getLivros()) {            
            livro.remover(autor);
            if(livro.getAutores().isEmpty())
                daolivro.delete(livro);
            else
                daolivro.update(livro);
        }       
        daoautor.delete(autor); 
        DAOdb4o.commit();
    }
    public static String consultarAutorPorParteNome(String caracteres) {
		List<Autor> result = daoautor.consultarAutorPorParteNome(caracteres);

		String texto = "\nConsultar autor por parte do nome:"+caracteres;
		if (result == null)  
			texto += "consulta vazia";
		else 
			for(Autor a: result)texto += "\n" + a;
		return texto;
	}
        //Fun��es de Livro
    public static String consultarNumeroDeEmprestimoLivro(String nome) {
    	DAOdb4o.begin();
    	List<Livro> l = daolivro.consultarLivroPorParteTitulo(nome);
    	String texto = "";
    	if(l == null)
    		return "Pessoa n�o cadastrada";
    	for(Livro li: l) {
    		texto += li.getTitulo();
    		texto += " tem " + li.getEmprestimo().size() + " Emprestimos registrados";
    	}
    	return texto; 	
    }
    
    public static Livro cadastrarLivro(String titulo, int quant)   throws  Exception{
        DAOdb4o.begin();
        Livro livro = daolivro.read(titulo);
        if(livro != null)
            throw new Exception("livro ja cadastrado:" + titulo);
 
        livro = new Livro(titulo, quant);
        daolivro.create(livro);
        DAOdb4o.commit();
        return livro;
        
    }
    public static String consultarLivroPorParteTitulo(String caracteres) {
		List<Livro> result = daolivro.consultarLivroPorParteTitulo(caracteres);

		String texto = "\nConsultar livro por parte do titulo:"+caracteres;
		if (result == null)  
			texto += "consulta vazia";
		else 
			for(Livro l: result)texto += "\n" + l;
		return texto;
	}

    public static Autor incluirAutorLivro(String titulo, String nomeautor) throws  Exception {
    	 
        DAOdb4o.begin();
        Livro livro = daolivro.read(titulo);
        if(livro == null)
            throw new Exception("livro nao cadastrado:" + titulo);
 
        Autor autor = daoautor.read(nomeautor);
        if (autor == null) {            
            autor = new Autor(nomeautor);
        }
        else {
            if (livro.localizar(autor.getNome()) != null) {
                throw new Exception("livro ja possui este autor:"+nomeautor);
            }
        }
        livro.adicionar(autor);
        autor.adicionar(livro);
 
        daolivro.update(livro);
        daoautor.update(autor);
        DAOdb4o.commit();
 
        return autor;
    }
    
    public static ArrayList<Livro> listarLivros(){
    	List<Livro> livros = daolivro.readAll();
    	ArrayList<Livro> texto = new ArrayList<Livro>();
        for (Livro li : livros) {
            texto.add(li);
        }
        return texto;
    }
    
    public static Livro encontrarLivro(String titulo) throws Exception{
    	DAOdb4o.begin();
    	Livro l = daolivro.read(titulo);
    	if(l == null)
    		throw new Exception("Livro N�o Cadastrado");
    	return l;
    }
    
    public static void excluirLivro(String titulo)  throws  Exception {
        DAOdb4o.begin();
        Livro livro = daolivro.read(titulo);
        if(livro == null)
            throw new Exception("livro nao cadastrado:" + titulo);
 
        for (Autor autor : livro.getAutores()) {            
            autor.remover(livro);
            if(autor.getLivros().isEmpty())   //autor est� orf�o?
                daoautor.delete(autor);
            else
                daoautor.update(autor);
        }       
        daolivro.delete(livro); 
        DAOdb4o.commit();
    }
    
    //Fun��es de Emprestimo
    public static void cadastrarEmprestimo(Pessoa p, Livro li,LocalDateTime datadev) throws Exception {
    	DAOdb4o.begin();
    	Emprestimo e;
    	if(li.getQuant() < 1) {
    		throw new Exception("Exemplares insuficientes deste livro");
    	}
    	e = new Emprestimo(p, li, datadev);
    	daoemprestimo.create(e);
    	p.setEmprestimo(e);
    	li.setEmprestimo(e);
    	daopessoa.update(p);
    	daolivro.update(li);
    	DAOdb4o.commit();
    }
    public static ArrayList<Emprestimo> listarEmprestimos(){
    	List<Emprestimo> emp = daoemprestimo.readAll();
    	ArrayList<Emprestimo> texto = new ArrayList<Emprestimo>();
        for (Emprestimo e : emp) {
            texto.add(e);
        }
        return texto;
    }
    public static void excluirEmprestimo(int i) throws Exception {
        DAOdb4o.begin();
        Emprestimo e = daoemprestimo.read(i);
        if (e==null) 
            throw new Exception("excluir Emprestimo - Emprestimo inexistente:" + i);
        daoemprestimo.delete(e);
        DAOdb4o.commit();
    }
}