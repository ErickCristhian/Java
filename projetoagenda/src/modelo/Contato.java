package modelo;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
import java.util.ArrayList;
import java.util.Scanner;


public class Contato {
	private String nome;
	private String email;
	private String cep;
	private String endereco;
	private String numero;
	private String linkfacebook;
	private int grauproximidade;
	private int grau;
	private int mesaniversario;
	

	public Contato(String nome, String email, String cep,String numero, String linkfacebook, int grau, int diaani, int mesani) {
		super();
		this.nome = nome;
		this.email = email;
		this.cep = cep;
		this.numero = numero;
		setEndereco(cep);
		this.linkfacebook = linkfacebook;
		this.grau = grau;
		this.mesaniversario = mesani;
		this.diaaniversario = diaani;
	}
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String cep) {
		try {
			URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
			//URL url = new URL("http://ifpb.edu.br");
			URLConnection conexao = url.openConnection();
			InputStream input = conexao.getInputStream();
			Scanner scan = new Scanner(input);
			while (scan.hasNext())	{
				endereco += scan.nextLine();
				endereco = endereco.trim();		//remover brancos externos
			}
			scan.close();


		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getLinkfacebook() {
		return linkfacebook;
	}


	public void setLinkfacebook(String linkfacebook) {
		this.linkfacebook = linkfacebook;
	}

	public int getMesaniversario() {
		return mesaniversario;
	}


	public void setMesaniversario(int mesaniversario) {
		this.mesaniversario = mesaniversario;
	}


	public int getDiaaniversario() {
		return diaaniversario;
	}


	public void setDiaaniversario(int diaaniversario) {
		this.diaaniversario = diaaniversario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public void adicionar(Telefone p){
		telefones.add(p);
	}
	public void remover(Telefone p){
		telefones.remove(p);
	}

	public Telefone localizarTelefone(String numero){
		for(Telefone p : telefones){
			if(p.getNumero().equals(numero))
				return p;
		}
		return null;
	}
	
	public int getGrau() {
		return grau;
	}


	public void setGrau(int grau) {
		this.grau = grau;
	}



	private int diaaniversario;	
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();

	
	
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}


	@Override
	public String toString() {
		String texto = "Contato [nome=" + nome ;
		texto += ", telefones:";
		if (telefones.isEmpty())
			texto += " vazia";
		else 	
			for(Telefone p: telefones) 
				texto += " " + p.getNumero() ;
		
		texto += ", email:";
		if (email.isEmpty())
			texto += " vazia";
		else
			texto += " " + this.getEmail();
		
		texto += ", cep:";
		if (email.isEmpty())
			texto += " vazia";
		else
			texto += " " + this.getCep();
		
		texto += ", endereco:";
		if (email.isEmpty())
			texto += " vazia";
		else
			texto += " " + this.getEndereco();
		
		texto += ", numero:";
		if (email.isEmpty())
			texto += " vazia";
		else
			texto += " " + this.getNumero();
		
		texto += ", Facebook:";
		if (email.isEmpty())
			texto += " vazia";
		else
			texto += " " + this.getLinkfacebook();
		
		texto += ", Proximidade:";
		if (email.isEmpty())
			texto += " vazia";
		else
			texto += " " + this.getGrau();
		
		texto += ", Mês do Aniversário:";
		if (email.isEmpty())
			texto += " vazia";
		else
			texto += " " + this.getMesaniversario();
		
		texto += ", Dia do Aniversário:";
		if (email.isEmpty())
			texto += " vazia";
		else
			texto += " " + this.getDiaaniversario();
		

		return texto + "]";
	}


}
	


