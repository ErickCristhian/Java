
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
package repositorio;
import java.util.ArrayList;
import java.util.TreeMap;

import modelo.Compromissos;
import modelo.Contato;
import modelo.Telefone;

public class Agenda {
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	private TreeMap<String, Contato> contatos = new TreeMap<>();
	private ArrayList<Compromissos> compromissos = new ArrayList<Compromissos>();
	private static int count;

	
	public static int getCount() {
		return count;
	}
	
	public ArrayList<Compromissos> getCompromissos() {
		return compromissos;
	}
	
	public void setCompromissos(ArrayList<Compromissos> compromissos) {
		this.compromissos = compromissos;
	}
	
	public Compromissos localizarCompromissos(String titulo) {
		for(Compromissos c : compromissos) {
			if(c.getTitulo().equals(titulo))
				return c;
		}
		return null;
	}
	public void adicionar(Telefone p){
		telefones.add(p);
	}
	public void adicionar(Compromissos comp) {
		compromissos.add(comp);
		count++;
	}
	public void remover(Telefone p){
		telefones.remove(p);
	}
	public void remover(Compromissos c) {
		compromissos.remove(c);
	}
	public Telefone localizarTelefone(String numero){
		for(Telefone p : telefones){
			if(p.getNumero().equals(numero))
				return p;
		}
		return null;
	}


	public void adicionar(Contato p){
		contatos.put(p.getNome(), p);
	}
	public void remover(Contato p){
		contatos.remove(contatos.get(p.getNome()));
	}

	public Contato localizarContato(String nome){
			if(contatos.get(nome) != null) {
				return contatos.get(nome);
			}
		return null;
	}

	public ArrayList<Telefone> getProdutos() {
		return telefones;
	}

	public TreeMap<String, Contato> getPrateleiras() {
		return contatos;
	}

	public int getTotalProdutos(){
		return telefones.size();
	}
	public int getTotalPrateleiras(){
		return contatos.size();
	}
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}
	public  ArrayList<Contato> getContatos() {
		ArrayList<Contato> a = new ArrayList<Contato>(contatos.values());
		return a;
	}
	public void setContatos(TreeMap<String, Contato> contatos) {
		this.contatos = contatos;
	}
}

