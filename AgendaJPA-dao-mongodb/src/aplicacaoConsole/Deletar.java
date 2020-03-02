package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Deletar {

	public Deletar(){
		Fachada.inicializar();
		try {
			System.out.println("deletando maria em cascata...");
			Fachada.excluirPessoa("maria");
			System.out.println("deletou maria");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

