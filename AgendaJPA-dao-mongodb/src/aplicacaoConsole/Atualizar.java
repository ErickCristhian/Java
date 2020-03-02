package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		try {
			System.out.println("\nalterando joao para joana...");
			Fachada.alterarPessoa("joao", "joana");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nalterando telefone de joana...");
			Fachada.alterarTelefone("988880000", "988889999");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nexcluindo telefone de joana...");
			Fachada.excluirTelefonePessoa("joana", "988881111");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nadicionando telefone de joana...");
			Fachada.adicionarTelefonePessoa("joana", "999991111");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

