/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Aluno;

public class DAOAluno extends DAO<Aluno>{
	
	public Aluno read(Object chave){
		try{
			String nome = (String) chave;
			Query q = manager.createQuery("select p from Aluno p where p.nome= '" + nome +"'");
			return (Aluno) q.getSingleResult();
			
		}catch(NoResultException e){
			return null;
		}
	}
}

