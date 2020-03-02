package aplicacaoConsole;

import fachada.Fachada;


public class Consultar {

	public Consultar(){
		Fachada.inicializar();
		try {
			System.out.println(Fachada.consultarPessoasPorParteNome("Er"));
			System.out.println(Fachada.consultarLivroPorParteTitulo("ja"));
			System.out.println(Fachada.consultarAutorPorParteNome("jo"));

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

