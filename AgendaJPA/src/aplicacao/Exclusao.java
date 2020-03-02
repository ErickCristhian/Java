package aplicacao;

/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Pessoa;

public class Exclusao {
	protected static EntityManager manager;
	public Exclusao(){
		// INSTANCIAÇÃO DO MANAGER--------------------------------
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda");
		manager = factory.createEntityManager();

		// EXCLUSÃO DOS OBJETOS USANDO QUERY-----------------------------------------
		manager.getTransaction().begin();
		try {
			Query q = manager.createQuery("select p from Pessoa p where p.nome = 'maria' ");
			Pessoa p1 = (Pessoa) q.getSingleResult();
			manager.remove(p1);
			manager.getTransaction().commit();
		}
		catch(NoResultException e) {
			System.out.println("nao encontrou a pessoa");
			manager.getTransaction().rollback();
		}
		catch(NonUniqueResultException e) {
			System.out.println("encontrou varias ocorrencias da pessoa");
			manager.getTransaction().rollback();
		}


		manager.close();
		factory.close();
		System.out.println("fim da aplicação");
	}


	//=================================================
	public static void main(String[] args) {
		new Exclusao();
	}


}
