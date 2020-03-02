
/*
 * IFPB - TSI - Persistencia de Objetos
 * Fausto Ayres
 * 
 * Teste da Fachada com JUnit 4
 * 
 */
package aplicacaoJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fachada.Fachada;
import modelo.Pessoa;
import modelo.Telefone;

public class TesteJUnitCadastro {
	@BeforeClass	//antes de todos os testes
	public static void inicializarRecursosExternos() {
		new File("banco.db4o").delete();	//apagar banco
		Fachada.inicializar();
	}


	@Test
	//"cadastrar uma pessoa sem telefone"
	public void test1() throws Exception {
		Pessoa p = Fachada.cadastrarPessoa("joao");
		assertTrue(p.getNome().equals("joao"));
		assertEquals(p.getTelefones().size(), 0);
	}

	@Test
	//"cadastrar uma pessoa com varios telefones"
	public void test2() throws Exception {
		Pessoa p = Fachada.cadastrarPessoa("jose");
		Telefone t1 = Fachada.adicionarTelefonePessoa("jose", "1111");
		Telefone t2 = Fachada.adicionarTelefonePessoa("jose", "2222");
		assertEquals(p.getTelefones().size(), 2);
		assertTrue(t1.getNumero().equals("1111"));
		assertTrue(t2.getNumero().equals("2222"));
		assertSame(t1.getPessoa(),p);
		assertSame(t2.getPessoa(),p);
	}


	@Test
	//"verificar unicidade de objeto"
	public void test3()  {
		try {
			Fachada.cadastrarPessoa("maria");
			Fachada.cadastrarPessoa("maria");
			fail("nao pode cadastrar duas pessoas com mesmo nome");
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("cadastrar pessoa - pessoa ja cadastrado:maria"));
		}
	}

	@AfterClass 		//depois de todos os testes
	public static void depois()  {
		Fachada.finalizar();
		new File("banco.db4o").delete();

	}



}
