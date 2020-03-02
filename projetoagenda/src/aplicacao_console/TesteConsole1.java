package aplicacao_console;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/


import java.util.ArrayList;

import fachada.Fachada;
import modelo.Contato;
import modelo.Telefone;

public class TesteConsole1 {
	public TesteConsole1() {
		cadastrar();
		atualizar();
		excluir();
		listar();
		//consultar();
		excecoes();
	}

	public void cadastrar(){
		try {	
			Telefone p;
			Contato c;
			c = Fachada.cadastrarContato("joao", "asda@dasda.com", "das", "asdas", "asda", 2, 5, 6);
			//c = Fachada.cadastrarContato("jose");
			//c = Fachada.cadastrarContato("maria");
			System.out.println("cadastro concluido");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}


	public void atualizar(){
		try{
			Fachada.adicionarTelefone("joao", "83", "88880000");
			Fachada.adicionarTelefone("jose", "83", "88881111");
			Fachada.adicionarTelefone("maria", "83", "88882222");
			Fachada.adicionarTelefone("joao", "83", "88883333");
			Fachada.adicionarTelefone("jose", "83", "88883333");
//			Fachada.adicionarTelefone("jose", "83", "88883333");  //exceção

//			Fachada.removerTelefone("jose", "88883333");
			System.out.println("atualizacao concluido");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}

	public static void excluir(){
	}

	public void listar(){
		String texto;
		ArrayList<Telefone> lista1 = Fachada.listarTelefones();
		texto = "\nListagem de telefone: \n";
		if (lista1.isEmpty())
			texto += "não tem produto cadastrado\n";
		else 	
			for(Telefone p: lista1) 
				texto +=  p + "\n"; 
		System.out.println(texto);


		ArrayList<Contato> lista2 = Fachada.listarContatos();
		texto = "Listagem de contato: \n";
		if (lista2.isEmpty())
			texto += "não tem contato\n";
		else 
			for(Contato p: lista2) 
				texto +=  p + "\n"; 
		System.out.println(texto);
	}

	public void consultar(){
	}


	public void excecoes() {

//	
	}
	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		new TesteConsole1();
	}

}
