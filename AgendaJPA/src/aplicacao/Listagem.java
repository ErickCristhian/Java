package aplicacao;
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Aluno;
import modelo.Pessoa;

public class Listagem {
	protected static EntityManager manager;
	public Listagem(){
		Query query;
		
		// INSTANCIAÇÃO DO MANAGER--------------------------------
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda");
		manager = factory.createEntityManager();
	
		System.out.println("Listagem de pessoas");
		query = manager.createQuery("select p from Pessoa p order by p.id");
		List<Pessoa> resultados = (List<Pessoa>) query.getResultList();
		for(Pessoa p: resultados)
			System.out.println(p);
		
		System.out.println("\nListagem de alunos");
		query = manager.createQuery("select a from Aluno a");
		List<Aluno> resultados2 = (List<Aluno>) query.getResultList();
		for(Aluno a: resultados2)
			System.out.println(a);
		
		
		manager.close();
		factory.close();
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new Listagem();
	}
	

}
