package fachada;
 
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import daojpa.DAO;
import daojpa.DAOAutor;
import daojpa.DAOEmprestimo;
import daojpa.DAOLivro;
import daojpa.DAOPessoa;
import modelo.Autor;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Pessoa;

public class Fachada {
    private static DAOPessoa daopessoa = new DAOPessoa();  
    private static DAOAutor daoautor = new DAOAutor();  
    private static DAOLivro daolivro = new DAOLivro();
    private static DAOEmprestimo daoemprestimo = new DAOEmprestimo();
	
 
 
    public static void inicializar(){
        DAO.open();
    }
    public static void finalizar() {
    	DAO.close();
    }
 
   //Fun��es de Pessoa
    public static String consultarLivroEmEmprestimoPorPessoa(String nome) throws Exception {
    	DAO.begin();
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
    public static String consultarNumeroDeEmprestimo(String nome) throws Exception {
    	DAO.begin();
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
    	DAO.begin();
    	Pessoa p = daopessoa.read(nome);
        if(p != null)
            throw new Exception("cadastrar pessoa - pessoa ja cadastrado:" + nome);
        p = new Pessoa(nome, CPF, Endereco);
        daopessoa.create(p);    
        DAO.commit();
    }
    public static Pessoa encontrarPessoa(String nome) throws Exception{
    	DAO.begin();
    	Pessoa p = daopessoa.read(nome);
    	if(p == null)
    		throw new Exception("Pessoa N�o Cadastrada");
    	return p;
    }


    public static void alterarPessoa(String nome, String novonome) throws Exception{
        DAO.begin();        
        Pessoa p = daopessoa.read(nome);    
        if (p==null)
            throw new Exception("alterar pessoa - nome inexistente:" + nome);
        p.setNome(novonome);            
        p = daopessoa.update(p);      
        DAO.commit();   
    }
    
 
    public static void excluirPessoa(String n) throws Exception {
        DAO.begin();
        Pessoa p = daopessoa.read(n);
        if (p==null) 
            throw new Exception("excluir pessoa - nome inexistente:" + n);
        daopessoa.delete(p);
        DAO.commit();
    }
 
 
    public void excluirPessoaManualmente(String nome) throws Exception{
        DAO.begin();
        Pessoa p = daopessoa.read(nome);    
        if(p==null)
            throw new Exception("excluir pessoa - nome inexistente:" + nome);
        daopessoa.delete(p);      
        DAO.commit();
    }
    
    public static ArrayList<Pessoa> listarPessoas() throws Exception{
        List<Pessoa> pessoas = daopessoa.readAll();
        ArrayList<Pessoa> texto = new ArrayList<Pessoa>();
        for (Pessoa pe : pessoas) {
            texto.add(pe);
        }
        return texto;
    }
    public static String consultarPessoasPorParteNome(String caracteres) throws Exception {
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
    	DAO.begin();
    	Autor a = daoautor.read(nome);
    	if(a != null)
    		throw new Exception("cadastrar autor - autor ja cadastrado:" + nome);
        a = new Autor(nome);
        daoautor.create(a);    
        DAO.commit();
    }
    public static ArrayList<Autor> listarAutores() throws Exception{
    	List<Autor> aut = daoautor.readAll();
    	ArrayList<Autor> texto = new ArrayList<Autor>();
        for (Autor a : aut) {
            texto.add(a);
        }
        return texto;
    }
    public static void excluirAutor(String Nome)  throws  Exception {
        DAO.begin();
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
        DAO.commit();
    }
    public static String consultarAutorPorParteNome(String caracteres) throws Exception {
		List<Autor> result = daoautor.consultarAutorPorParteNome(caracteres);

		String texto = "\nConsultar autor por parte do nome:"+caracteres;
		if (result == null)  
			texto += "consulta vazia";
		if(result.isEmpty())
			texto += "Consulta vazia";
		else 
			for(Autor a: result)texto += "\n" + a;
		return texto;
	}
        //Fun��es de Livro
    public static String consultarNumeroDeEmprestimoLivro(String nome) {
    	DAO.begin();
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
        DAO.begin();
        Livro livro = daolivro.read(titulo);
        if(livro != null)
            throw new Exception("livro ja cadastrado:" + titulo);
        livro = new Livro(titulo, quant);
        daolivro.create(livro);
        DAO.commit();
        return livro;
        
    }
    public static String consultarLivroPorParteTitulo(String caracteres) {
		List<Livro> result = daolivro.consultarLivroPorParteTitulo(caracteres);

		String texto = "\nConsultar livro por parte do titulo:"+caracteres;
		if (result == null)  
			texto += "consulta vazia";
		if (result.isEmpty())
			texto += "Consulta vazia";
		else 
			for(Livro l: result)texto += "\n" + l;
		return texto;
	}

    public static Autor incluirAutorLivro(String titulo, String nomeautor) throws  Exception {
    	 
        DAO.begin();
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
        DAO.commit();
 
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
    	DAO.begin();
    	Livro l = daolivro.read(titulo);
    	if(l == null)
    		throw new Exception("Livro N�o Cadastrado");
    	return l;
    }
    
    public static void excluirLivro(String titulo)  throws  Exception {
        DAO.begin();
        
        Livro livro = daolivro.read(titulo);
        if(livro == null)
            throw new Exception("livro nao cadastrado:" + titulo);
        
        for (Autor autor : livro.getAutores()) {            
            autor.remover(livro);
            if(autor.getLivros().isEmpty())   //autor est� orf�o?
                daoautor.delete(autor);
            else
                autor = daoautor.update(autor);
        }

        for (Emprestimo e : livro.getEmprestimo()) {      
            e.removerLivro();
            Pessoa p = e.getPessoa();
            e.removerPessoa();
            p.removerEmprestimo(e);
            
            if(e.getLivro() == null)
            	if(e.getPessoa() == null)
            		daoemprestimo.delete(e);
        }
        
        daolivro.delete(livro); 
        DAO.commit();
    }
    
    //Fun��es de Emprestimo
    public static void cadastrarEmprestimo(Pessoa p, Livro li,LocalDateTime datadev) throws Exception {
    	DAO.begin();
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
    	DAO.commit();
    }
    public static ArrayList<Emprestimo> listarEmprestimos() throws Exception{
    	List<Emprestimo> emp = daoemprestimo.readAll();
    	ArrayList<Emprestimo> texto = new ArrayList<Emprestimo>();
        for (Emprestimo e : emp) {
            texto.add(e);
        }
        return texto;
    }
    public static void excluirEmprestimo(int i) throws Exception {
        DAO.begin();
        Emprestimo e = daoemprestimo.read(i);
        if (e==null) 
            throw new Exception("excluir Emprestimo - Emprestimo inexistente:" + i);
        daoemprestimo.delete(e);
        DAO.commit();
    }
	public static String listarEmprestimoPorLivro(String caracteres) {
		List<Livro> result = daolivro.consultarLivroPorParteTitulo(caracteres);

		String texto = "\nConsultar Emprestimo por parte do titulo do livro: "+caracteres;
		if (result == null)  
			texto += "consulta vazia";
		if (result.isEmpty())
			texto += "Consulta vazia";
		else 
			for(Livro l: result)
				texto += "\n" + l.getEmprestimo().toString();
		return texto;
		
	}
	public static String consultarLivroPorEmprestimoErick(String CPF) {
		Livro result = (Livro) daolivro.consultarLivroPorEmprestimoErick(CPF);
		String texto = "\n Consulta de livros emprestados por esse CPF: " + CPF;
		texto += "\n" + result.toString();
		return texto;
	}
}