package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;
import modelo.Pessoa;

/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */

public class Cadastro {
	protected static EntityManager manager;
	public Cadastro(){
		Pessoa p1;

		// INSTANCIA��O DO MANAGER--------------------------------
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda");
		manager = factory.createEntityManager();


		//	PERSIST�NCIA DOS OBJETOS NO BANCO-----------------------
		manager.getTransaction().begin();
		p1 = new Pessoa("joao");
		manager.persist(p1);
		manager.getTransaction().commit();

		manager.getTransaction().begin();
		p1 = new Pessoa("maria");
		manager.persist(p1);
		manager.getTransaction().commit();

		manager.getTransaction().begin();
		p1 = new Pessoa("jose");
		manager.persist(p1);	
		manager.getTransaction().commit();

		manager.getTransaction().begin();
		p1 = new Aluno("paulo",9);
		manager.persist(p1);	
		manager.getTransaction().commit();


		manager.close();
		factory.close();
		System.out.println("fim da aplica��o");
	}


	//=================================================
	public static void main(String[] args) {
		new Cadastro();
	}


}
