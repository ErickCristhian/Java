package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Listar {

	public Listar(){
		Fachada.inicializar();
		try {
			System.out.println(Fachada.listarPessoas());
			System.out.println(Fachada.listarHomens());
			System.out.println(Fachada.listarMulheres());
			System.out.println(Fachada.listarAlunos());
			System.out.println(Fachada.listarProfessores());
			System.out.println(Fachada.listarTelefones());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

