package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Pessoa;
import modelo.Telefone;


public class Cadastrar {

	public Cadastrar(){
		
		try {
			Fachada.inicializar();
			Pessoa p;
			Telefone t;
			System.out.println("cadastrando...");
			p=Fachada.cadastrarPessoa("joao");
			t=Fachada.adicionarTelefonePessoa("joao","88880000");
			t=Fachada.adicionarTelefonePessoa("joao","88881111");	
			System.out.println(p);
			
			p=Fachada.cadastrarPessoa("maria");
			t=Fachada.adicionarTelefonePessoa("maria","87882222");
			t=Fachada.adicionarTelefonePessoa("maria","88883333");
			System.out.println(p);

			p=Fachada.cadastrarPessoa("jose");
			t=Fachada.adicionarTelefonePessoa("jose","87884444");
			System.out.println(p);

			p=Fachada.cadastrarAluno("paulo", 9);
			System.out.println(p);

			p=Fachada.cadastrarProfessor("fausto", 1000.0);
			System.out.println(p);

		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}

		System.out.println("fim do programa");
	}


	public void cadastrar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


