package aplicacao;

/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Pessoa;

public class Atualizacao {
	protected static EntityManager manager;
	public Atualizacao(){

		// INSTANCIAÇÃO DO MANAGER--------------------------------
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda");
		manager = factory.createEntityManager();

		//	ALTERAÇÃO DOS OBJETOS USANDO FIND------------------------------------
		manager.getTransaction().begin();
		Pessoa p1 = manager.find(Pessoa.class, 1);		//localiza o joao
		if(p1!=null) {
			p1.setNome("joana");
			manager.merge(p1);
			manager.getTransaction().commit();
		}
		else {
			System.out.println("nao encontrou a pessoa");
			manager.getTransaction().rollback();
		}



		manager.close();
		factory.close();
		System.out.println("fim da aplicação");
	}


	//=================================================
	public static void main(String[] args) {
		new Atualizacao();
	}


}
