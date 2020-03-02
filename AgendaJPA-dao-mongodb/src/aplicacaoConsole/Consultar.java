package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Consultar {

	public Consultar(){
		Fachada.inicializar();
		try {
			System.out.println(Fachada.consultarPessoasPorParteNome("jo") );
			//System.out.println(Fachada.consultarPessoasNTelefones(2) );
			//System.out.println(Fachada.consultarPessoaPorNumero("988889999") );
			//System.out.println(Fachada.consultarTelefonesPorNome("joao") );
			System.out.println(Fachada.consultarTelefonesPorPrefixo("987") );

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

