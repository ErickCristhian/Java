package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */
public class Pessoa{
	protected String nome;
	private LocalDate dtcadastro = LocalDate.now();
	protected ArrayList<Telefone> telefones = new ArrayList<Telefone>();

	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionar(Telefone t){
		t.setPessoa(this);
		this.telefones.add(t);
	}

	public void remover(Telefone t){
		t.setPessoa(null);
		this.telefones.remove(t);
	}

	public Telefone localizar(String num){
		for(Telefone t : telefones)
			if (t.getNumero().equals(num))
				return t;
		return null;
	}

	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}

	@Override
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String classe = getClass().getSimpleName() + ":";
		String texto =  String.format("%10s", classe)  + 
				" nome=" + String.format("%10s", nome) + 
				", cadastro=" + dtcadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		texto += ", telefones:";
		for(Telefone t : telefones)
			texto+= t.getNumero() + ", ";

		return texto;
	}






}
