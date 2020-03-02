package aplicacaoConsole;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Pessoa;
import modelo.Sexo;
import modelo.Telefone;


public class Cadastrar {

	public Cadastrar(){
		
		try {
			Fachada.inicializar();
			
			
			
			Pessoa p;
			Telefone t;
			System.out.println("cadastrando...");
			p=Fachada.cadastrarPessoa("joao",Sexo.MASCULINO);
			t=Fachada.adicionarTelefonePessoa("joao","988880000");
			t=Fachada.adicionarTelefonePessoa("joao","988881111");	
			
			p=Fachada.cadastrarPessoa("maria", Sexo.FEMININO);
			t=Fachada.adicionarTelefonePessoa("maria","987882222");
			t=Fachada.adicionarTelefonePessoa("maria","988883333");

			p=Fachada.cadastrarPessoa("jose", Sexo.MASCULINO);
			t=Fachada.adicionarTelefonePessoa("jose","987884444");

			p=Fachada.cadastrarAluno("paulo", Sexo.MASCULINO, 9);
			
			p=Fachada.cadastrarProfessor("fausto", Sexo.MASCULINO,  1000.0);


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


