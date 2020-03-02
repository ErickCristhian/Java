/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Professor;

public class DAOProfessor extends DAO<Professor>{
	
	public Professor read(Object chave){
		try{
			String nome = (String) chave;
			Query q = manager.createQuery("select p from Professor p where p.nome= '" + nome +"'");
			return (Professor) q.getSingleResult();
			
		}catch(NoResultException e){
			return null;
		}
	}
}

