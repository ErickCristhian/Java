package modelo;

import java.util.ArrayList;
import java.util.List;

import fachada.Fachada;

public class CompromissoEmGrupo extends Compromissos{
	private ArrayList<Contato> contatos = new ArrayList<Contato>();
	//private ArrayList<Contato> c = Fachada.listarContatos();
	
	
	public CompromissoEmGrupo(int id, String titulo, int Dia, int mes, int ano, int hora, int minuto, String tipo, ArrayList<String> nome) {
		super(id, titulo, Dia, mes, ano, hora, minuto, tipo);
		 contatos = nome;
		 }
		
	}

}
