package fachada;

import java.util.List;

import daojpa.DAO;
import daojpa.DAOAluno;
import daojpa.DAOPessoa;
import daojpa.DAOProfessor;
import daojpa.DAOTelefone;
import modelo.Aluno;
import modelo.Pessoa;
import modelo.Professor;
import modelo.Sexo;
import modelo.Telefone;

public class Fachada {
	private static DAOPessoa daopessoa = new DAOPessoa();  
	private static DAOAluno daoaluno = new DAOAluno();  
	private static DAOProfessor daoprofessor = new DAOProfessor();  
	private static DAOTelefone daotelefone = new DAOTelefone();  

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	public static Pessoa cadastrarPessoa(String nome, Sexo sexo) throws  Exception{
		DAO.begin();	
		Pessoa p = daopessoa.read(nome);
		if(p != null) {
			DAO.rollback();		
			throw new Exception("pessoa ja cadastrada:" + nome);
		}
		p = new Pessoa(nome,sexo);
		daopessoa.create(p);	
		DAO.commit();
		return p;
	}	
	public static Aluno cadastrarAluno(String nome, Sexo sexo, double nota) throws  Exception{
		DAO.begin();	
		Aluno a = daoaluno.read(nome);	
		if(a != null) {
			DAO.rollback();	
			throw new Exception("pessoa ja cadastrado:" + nome);
		}
		
		a = new Aluno(nome,sexo,nota);
		daoaluno.create(a);		
		DAO.commit();
		return a;
	}
	
	public static Professor cadastrarProfessor(String nome, Sexo sexo,  double salario) 
			throws  Exception{
		DAO.begin();	
		Professor p = daoprofessor.read(nome);
		if(p != null){
			DAO.rollback();	
			throw new Exception("cadastrar professor - pessoa ja cadastrado:" + nome);
		}
		
		p = new Professor(nome,sexo, salario);
		daoprofessor.create(p);	
		DAO.commit();
		return (Professor) p;
	}

	
	public static Telefone adicionarTelefonePessoa(String nome, String numero) 
			throws  Exception{
		DAO.begin();	
		Pessoa p = daopessoa.read(nome);
		if(p == null) {
			DAO.rollback();	
			throw new Exception("adicionar telefone - pessoa nao cadastrada:" + nome);
		}

		Telefone t = daotelefone.read(numero);
		if(t != null) {
			DAO.rollback();	
			throw new Exception("adicionar telefone - telefone ja cadastrado:" + numero);
		}
		
		t = new Telefone(numero);
		p.adicionar(t);
		daopessoa.update(p);	
		DAO.commit();
		return t;
	}
	
	public static Telefone excluirTelefonePessoa(String nome, String numero) 
			throws  Exception{
		DAO.begin();	
		Pessoa p = daopessoa.read(nome);
		if(p == null){
			DAO.rollback();	
			throw new Exception("excluir telefone - pessoa nao cadastrada:" + nome);
		}
		Telefone t = daotelefone.read(numero);
		if(t == null){
			DAO.rollback();	
			throw new Exception("excluir telefone - telefone nao cadastrado:" + numero);
		}
		
		t = p.localizar(numero);	//localiza dentro da pessoa
		if(t == null){
			DAO.rollback();	
			throw new Exception("excluir telefone - pessoa nao possui este telefone:" + nome);
		}
		
		p.remover(t);
		daopessoa.update(p);	//excluir tb telefone orfao
		//daotelefone.delete(t);	//nao eh necessario quando orphanremoval=true
		DAO.commit();
		return t;
	}
	
	public static void alterarPessoa(String nome, String novonome) throws Exception{
		DAO.begin();		
		Pessoa p = daopessoa.read(nome);	//usando  chave primaria
		if (p!=null) {
			p.setNome(novonome); 			
			p=daopessoa.update(p);     	
		}
		else {
			DAO.rollback();	
			throw new Exception("pesssoa inexistente:" + nome);
		}
		DAO.commit();	
	}

	public static void alterarTelefone(String numero, String novonumero) throws Exception{
		DAO.begin();		
		Telefone t = daotelefone.read(numero);	
		if (t==null) {
			DAO.rollback();	
			throw new Exception("alterar telefone - numero inexistente:" + numero);
		}
		
		Telefone t2 = daotelefone.read(novonumero);	
		if (t2!=null) {
			DAO.rollback();	
			throw new Exception("alterar telefone - novo numero ja existe:" + novonumero);
		}
		
		t.setNumero(novonumero); 			
		t=daotelefone.update(t);     	
		DAO.commit();	
	}
	
	public static void excluirPessoa(String n) throws Exception {
		DAO.begin();
		Pessoa p = daopessoa.read(n);
		if (p!=null) 
			daopessoa.delete(p);
		else{
			DAO.rollback();	
			throw new Exception("pesssoa inexistente:" + n);
		}
		DAO.commit();
	}

	public static String listarPessoas(){
		List<Pessoa> pessoas = daopessoa.readAll();
		String texto="-----------listagem de Pessoas-----------\n";
		for (Pessoa pe : pessoas) {
			texto += pe +"\n";
		}
		return texto;
	}
	
	public static String listarHomens(){
		List<Pessoa> pessoas = daopessoa.consultarSexo(Sexo.MASCULINO);
		String texto="-----------listagem de HOMENS-----------\n";
		for (Pessoa pe : pessoas) {
			texto += pe +"\n";
		}
		return texto;
	}
	
	public static String listarMulheres(){
		List<Pessoa> pessoas = daopessoa.consultarSexo(Sexo.FEMININO);
		String texto="-----------listagem de MULHERES-----------\n";
		for (Pessoa pe : pessoas) {
			texto += pe +"\n";
		}
		return texto;
	}
	public static String listarAlunos(){
		List<Aluno> alunos = daoaluno.readAll();
		String texto="-----------listagem de Alunos-----------\n";
		for (Aluno pe : alunos) {
			texto += pe +"\n";
		}
		return texto;
	}
	public static String listarProfessores(){
		List<Professor> alunos = daoprofessor.readAll();
		String texto="-----------listagem de Professores-----------\n";
		for (Professor pe : alunos) {
			texto += pe +"\n";
		}
		return texto;
	}


	public static String listarTelefones() { 	
		List<Telefone> aux = daotelefone.readAll();
		String texto="-----------listagem de Telefones---------\n";
		for(Telefone t: aux) {
			texto += "\n" + t; 
		}
		return texto;
	}
	

	/**********************************************************
	 * 
	 * CONSULTAS 
	 * 
	 **********************************************************/

		public static String consultarPessoasPorParteNome(String caracteres) {
		List<Pessoa> result = daopessoa.consultarPessoasPorParteNome(caracteres);

		String texto = "\nConsultar pessoas por parte do nome:"+caracteres;
		if (result.isEmpty())  
			texto += "\nconsulta vazia";
		else 
			for(Pessoa p: result)texto += "\n" + p;
		return texto;
	}


	public static String consultarPessoasNTelefones(int n) {
		List<Pessoa> result = daopessoa.consultarPessoasNTelefones(n);

		String texto = "\nConsultar pessoas com "+n+" telefones:";
		if (result.isEmpty())  
			texto += "\nconsulta vazia";
		else 
			for(Pessoa p: result)texto += "\n" + p;
		return texto;
	}

	public static String consultarPessoaPorNumero(String n) {
		Pessoa result = daopessoa.consultarPessoaPorNumero(n);
		if(result==null)
			return "\nConsultar pessoa do numero "+n+" => nao encontrado";
		else
			return "\nConsultar pessoa do numero "+n+" \n " +result.getNome();

	}

	public static String consultarTelefonesPorNome(String n) {
		List<Telefone> result = daotelefone.consultarTelefonesPorNome(n);
		String texto = "\nConsultar telefones de " + n;
		if (result.isEmpty())  
			texto += "\nconsulta vazia";
		else 
			for(Telefone t: result)texto += "\n" + t;
		return texto;
	}

	public static String consultarTelefonesPorPrefixo(String prefixo) {
		List<Telefone> result = daotelefone.consultarTelefonesPorPrefixo(prefixo);
		String texto = "\nConsultar telefones do prefixo " + prefixo;
		if (result.isEmpty())  
			texto += "\nconsulta vazia";
		else 
			for(Telefone t: result)texto += "\n" + t;
		return texto;
	}

	public static String consultarSexo(Sexo s){
		List<Pessoa> pessoas = daopessoa.consultarSexo(s);
		String texto="-----------consulta por Sexo: " + s +" -----------\n";
		for (Pessoa pe : pessoas) {
			texto += pe +"\n";
		}
		return texto;
	}

}
