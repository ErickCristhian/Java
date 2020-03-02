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
			System.out.println("alterando...");
			Fachada.alterarPessoa("joao", "joana");
			Fachada.excluirTelefonePessoa("joana", "88881111");
			Fachada.alterarTelefone("88880000", "88889999");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//erros
		System.out.println("\ntestando erros...");
		try {
			Fachada.excluirTelefonePessoa("ana", "88883333"); 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());}
		try {
			Fachada.alterarTelefone("88889999", "88883333"); 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

