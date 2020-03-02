/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO - Programação Orientada a Objetos
 * Prof. Fausto Ayres
 * Aluno: Erick Cristhian
 * Matrícula: 20171370035
 */
package fachada;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import modelo.CompromissoEmGrupo;
import modelo.Compromissos;
import modelo.Contato;
import modelo.Telefone;
import repositorio.Agenda;

public class Fachada {

	private static Agenda agenda = new Agenda();
	private static String[] c = {"Família", "Viagem", "Lazer", "Trabalho"};
	private static int[] grauproximidade = {1, 2, 3};


	public static Contato cadastrarContato(String nome, String email, String cep, String numero, String link, int grau, int mes, int dia) 	throws  Exception{
		Contato c = agenda.localizarContato(nome);
		if (c!=null)
			throw new Exception("cadastrar contato - nome ja cadastrado:" + nome);
		c = new Contato(nome, email, cep, numero, link, grau, mes, dia);
		agenda.adicionar(c);
		return c;
	}
	
	
	
	@SuppressWarnings("static-access")
	public static Compromissos cadastrarCompromisso(String titulo, int dia, int mes, int ano, int hora, int minuto, String tipo) throws Exception{
		Compromissos c = agenda.localizarCompromissos(titulo);
		System.out.print(titulo);
		if(c != null)
			throw new Exception("Compromisso já cadastrado " + titulo);
		c = new Compromissos(agenda.getCount(), titulo, dia, mes, ano, hora, minuto, tipo);
		agenda.adicionar(c);
		return c;
	}
	
	
	public static void adicionarTelefone(String nome,String ddd, String numero)	throws  Exception{
		Contato c = agenda.localizarContato(nome);
		if (c==null)
			throw new Exception("adicionar telefone - contato nao cadastrado:" + nome);


		Telefone t = agenda.localizarTelefone(numero);
		
		if (t==null) {
			t = new Telefone(ddd,numero);
			agenda.adicionar(t);
			c.adicionar(t);
			t.adicionar(c);
		}
		else {
			Telefone t2 = c.localizarTelefone(numero);
			if(t2!=null)
				throw new Exception("adicionar telefone - contato ja possui este numero:" + numero);
			else {
				c.adicionar(t);
				t.adicionar(c);
			}

		}

	}
	
	
	//Métodos de contato
	public static ArrayList<Contato> listarContatos() {
		return agenda.getContatos();
	}
	
	@SuppressWarnings("unused")
	public static ArrayList<Contato> listarContatosPorNome(String nome){
		ArrayList<Contato> a = agenda.getContatos();
		ArrayList<Contato> aux = new ArrayList<Contato>();
		for(Contato p : a){
			if(p.getNome().contains(nome))
				aux.addAll(a);
		}
		if(aux != null) {
			return aux;
		} 
		return a;
		
	}
	public static ArrayList<Contato> listarContatosPorTelefone(String digito){
		ArrayList<Contato> a = agenda.getContatos();
		ArrayList<Contato> aux = new ArrayList<Contato>();
		for(Contato p : a){
			if(!p.getTelefones().equals(null))
				for(Telefone j : p.getTelefones()) {
					if(j.getNumero().contains(digito)) {
						aux.add(p);
					}
				}
		}
		return aux;
	}
	
	public static  ArrayList<Contato> listarContatosPorProximidade(int valor){
		ArrayList<Contato> a = agenda.getContatos();
		ArrayList<Contato> aux = new ArrayList<Contato>();
		for(Contato p : a){
			if(p.getGrau() == valor)
				aux.add(p);
		}
		return aux;
	}
	public static int[] grau() {
		return grauproximidade;
	}
	
	//Métodos de Telefone
	public static ArrayList<Telefone> listarTelefones() {
		return agenda.getTelefones();
	}
	

	public static void removerTelefone(String nome, String numero) {
		ArrayList<Contato> a = agenda.getContatos();
		
		for(Contato p : a) {
			ArrayList<Telefone> t = p.getTelefones();
			for(Telefone x : t) {
				if (x.getNumero().equals(numero)) {
					p.remover(x);
					x.remover(p);
				}
			}
		}
		
	}

	//Métodos de Compromissos
	
	public static String[] tiposComp(){
		return c;
	}
	
	public static ArrayList<Compromissos> listarCompromissos() {
		return agenda.getCompromissos();
	}
	
	@SuppressWarnings("unused")
	public static ArrayList<Compromissos> listarCompromissosPorNome(String termo){
		ArrayList<Compromissos> a = agenda.getCompromissos();
		ArrayList<Compromissos> aux = new ArrayList<Compromissos>();
		for(Compromissos p : a){
			if(p.getTitulo().contains(termo))
				aux.add(p);
		}
		if(aux != null) {
			return aux;
		} 
		return a;
	}
	
	public static ArrayList<Compromissos> listarCompromissosPorTipo(String tipo){
		ArrayList<Compromissos> a = agenda.getCompromissos();
		ArrayList<Compromissos> aux = new ArrayList<Compromissos>();
		for(Compromissos p : a) {
			if(p.getTipo().equals(tipo))
				aux.add(p);
		}
		return aux;
	}
	public static ArrayList<Compromissos> listarCompromissosPorDatas(LocalDateTime data1,LocalDateTime data2){
		ArrayList<Compromissos> a = agenda.getCompromissos();
		ArrayList<Compromissos> aux = new ArrayList<Compromissos>();
		for(Compromissos p : a) {
			if(p.getDatahora().compareTo(data1) >= 0 && p.getDatahora().compareTo(data2) <= 0)
				aux.add(p);
		}
		return aux;
	}
	
	//------Consultas-----------------
	public static ArrayList<String> consulta1(){
		ArrayList<Contato> a = agenda.getContatos();
		ArrayList<String> s = new ArrayList<String>();
		for(Contato c : a) {
			if(c.getTelefones().size() < 2) {
				s.add(c.getNome());
			}
		}
		return s;
	}
	
	public static ArrayList<String> consulta2(){
		ArrayList<Telefone> t = agenda.getTelefones();
		ArrayList<String> s = new ArrayList<String>();
		for(Telefone c : t) {
			if(c.getContatos().size() < 2) {
				s.add(c.getNumero());
			}
		}
		return s;
	}
	
	public static void removerContato(String nome) {
		ArrayList<Contato> a = agenda.getContatos();
		ArrayList<Telefone> t = new ArrayList<Telefone>();
		for(Contato c : a) {
			if(c.getNome().contains(nome)) {
				for(int i = 0; i < c.getTelefones().size(); i++) {
					t.addAll(c.getTelefones());
					c.remover(t.get(i));
				}
			}
			agenda.remover(c);
			break;
		}
	}
	
	public static void removerCompromisso(int id) {
		ArrayList<Compromissos> c = agenda.getCompromissos();
		for(Compromissos co : c) {
			if(co.getId() == id) {
				agenda.remover(co);
			}
		}
	}
	
	public static Compromissos cadastrarCompromissoEmGrupo(String titulo, int Dia, int mes, int ano, int hora, int minuto, String tipo, ArrayList<String> nome) throws Exception {
		Compromissos c = agenda.localizarCompromissos(titulo);	
		if(c != null)
			throw new Exception("Compromisso já cadastrado" + titulo);
		
		CompromissoEmGrupo g = new CompromissoEmGrupo(agenda.getCount(), titulo, Dia, mes, ano, hora, minuto, tipo, nome);
		agenda.adicionar(c);
		return c;
	}

	public static void notificarCompromissoGrupo(int id, String senha) {
        try {
			Session session;
			String emaildestino = "erickcristhian123@gmail.com";
	        final String emailorigem = "erickcristhian123@gmail.com";
	        final String senhaS = senha;
	        Properties props = new Properties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        session = Session.getInstance(props,new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(emailorigem, senhaS);
	            }
	        });
	        MimeMessage message = new MimeMessage(session);
	        message.setSubject("Teste de email sem anexo");     //assunto
	        message.setFrom(new InternetAddress(emailorigem));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emaildestino));
	        message.setText("corpo da mensagem \n\n ok!");
	        Transport.send(message);
	
	        System.out.println("enviado com sucesso");
	         
	    } catch (MessagingException e) {
	        System.out.println(e.getMessage());
	    }
	}
}//class
