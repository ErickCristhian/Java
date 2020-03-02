package aplicacaoConsole;
import java.time.LocalDateTime;
import java.util.ArrayList;

import fachada.Fachada;
import modelo.Compromissos;
import modelo.Contato;
import modelo.Telefone;

public class Teste1 {

	public static void main(String[] args) {
		teste_contatos();
		teste_compromissos();
		teste_erros();
	}

	public static void teste_contatos() {
		System.out.println("------------------------------------------------");
		System.out.println("-------------TESTE DE CONTATDOS ----------------");
		System.out.println("------------------------------------------------");

		try {
			Contato c1 = Fachada.cadastrarContato("joao","joao@gmail.com","58055000","100","link",3,1,1);
			Fachada.adicionarTelefone("joao","83","988881111");
			Fachada.adicionarTelefone("joao","83","988882222");
			Fachada.adicionarTelefone("joao","83","988883333");
			Contato c2 = Fachada.cadastrarContato("maria","maria@gmail.com","58020000","200","link",3,2,2);
			Fachada.adicionarTelefone("maria","83","988881111");
			Contato c3 = Fachada.cadastrarContato("jose","jose@gmail.com","58030000","300","link",1,3,3);
			Fachada.adicionarTelefone("jose","83","988884444");
			Fachada.adicionarTelefone("jose","83","988883333");
			
			Fachada.removerTelefone("joao", "988882222");

		}
		catch(Exception e) {
			System.out.println("---->"+e.getMessage());
		}

		//---LISTAGENS DE CONTATOS
		try {
			ArrayList<Telefone> telefones = Fachada.listarTelefones();
			System.out.println("\nLISTAGEM TELEFONES:\n"+telefones);
			ArrayList<Contato> lista1 = Fachada.listarContatosPorNome("");
			System.out.println("\nLISTAGEM GERAL:\n"+lista1);
			ArrayList<Contato> lista2 = Fachada.listarContatosPorNome("jo");
			System.out.println("\nLISTAGEM POR NOME jo:\n"+lista2);
			ArrayList<Contato> lista3 = Fachada.listarContatosPorTelefone("11");
			System.out.println("\nLISTAGEM POR TELEFONE:\n"+lista3);
			ArrayList<Contato> lista4 = Fachada.listarContatosPorProximidade(3);
			System.out.println("\nLISTAGEM PRO PROXIMIDADE:\n"+lista4);

			ArrayList<String> nomes = Fachada.consulta1();
			System.out.println("\nCONSULTA1:\n"+nomes);
			ArrayList<String> numeros = Fachada.consulta2();
			System.out.println("\nCONSULT2:\n"+numeros);
		}
		catch(Exception e) {
			System.out.println("---->"+e.getMessage());
		}
	}

	public static void teste_compromissos() {
		System.out.println("\n------------------------------------------------");
		System.out.println("-------------TESTE DE COMPROMISSOS--------------");
		System.out.println("------------------------------------------------");
		try {
			Compromissos comp1 = Fachada.cadastrarCompromisso("aula de poo", 1,1,2019, 13,00, "ESTUDO");
			Compromissos comp2 = Fachada.cadastrarCompromisso("cinema", 1,1,2019, 17,00, "LAZER");
			Compromissos comp3 = Fachada.cadastrarCompromisso("jantar", 2,1,2019, 20,00, "LAZER");
			
//			Compromisso comp1 = Fachada.cadastrarCompromisso("aula de poo", "1","1","2019", "13","00", "ESTUDO");
//			Compromisso comp2 = Fachada.cadastrarCompromisso("cinema", "1","1","2019", "17","00", "LAZER");
//			Compromisso comp3 = Fachada.cadastrarCompromisso("jantar", "2","1","2019", "20","00", "LAZER");
			ArrayList<Compromissos> resultado1 = Fachada.listarCompromissosPorNome("") ;
			System.out.println("\nLISTAGEM GERAL:\n"+resultado1);
			ArrayList<Compromissos> resultado2 = Fachada.listarCompromissosPorNome("e") ;
			System.out.println("\nLISTAGEM POR TITULO e:\n"+resultado2);
			//	ArrayList<Compromisso> resultado3 = Fachada.listarCompromissosPordatas(1,1,2019,2,1,2019) ;
			ArrayList<Compromissos> resultado3 = Fachada.listarCompromissosPorDatas(LocalDateTime.of(2019,1,1,0,0,0), LocalDateTime.of(2019,1,1,23,59,0) ) ;
			System.out.println("\nLISTAGEM POR DATA:\n"+resultado3);
			ArrayList<Compromissos> resultado4 = Fachada.listarCompromissosPorTipo("LAZER") ;
			System.out.println("\nLISTAGEM POR TIPO:\n"+resultado4);
		}
		catch(Exception e) {
			System.out.println("---->"+e.getMessage());
		}

	}

	public static void teste_erros() {
		System.out.println("\n------------------------------------------------");
		System.out.println("-------------TESTE DE ERROS-----------------------");
		System.out.println("--------------------------------------------------");

		try {
			Fachada.cadastrarContato("teste","teste@gmail.com","58055000","100","link",3,1,1);
			Fachada.cadastrarContato("teste","teste@gmail.com","58055000","100","link",3,1,1);
			System.out.println("FALHA:cadastrou dois contatos iguais");
		}catch(Exception e) {System.out.println("---->"+e.getMessage());}
		try {
			Fachada.adicionarTelefone("teste","83","999990000");
			Fachada.adicionarTelefone("teste","83","999990000");
			System.out.println("FALHA:cadastrou dois telefones iguais para o mesmo contato");
		}catch(Exception e) {System.out.println("---->"+e.getMessage());}

		try {
			Fachada.cadastrarCompromisso("teste", 1,1,2019, 13,00, "ESTUDO");
			Fachada.cadastrarCompromisso("teste", 1,1,2019, 13,00, "ESTUDO");
			System.out.println("FALHA:cadastrou dois compromissos iguais");
		}catch(Exception e) {System.out.println("---->"+e.getMessage());}
	}
}
