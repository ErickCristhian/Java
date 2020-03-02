/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Telefone;

public class DAOTelefone  extends DAO<Telefone>{
	public Telefone read (Object chave){
		try{
			String num = (String) chave;
			Query q = manager.createQuery("select t from Telefone t where t.numero= :x");
			q.setParameter("x", num);
			return (Telefone) q.getSingleResult();

		}catch(NoResultException e){
			return null;
		}
	}
	
	//--------------------------------------------
	//  consultas
	//--------------------------------------------

	public List<Telefone> consultarTelefonesPorNome (String nome){		
		Query q = manager.createQuery("select t from Telefone t where t.pessoa.nome= :x");
		q.setParameter("x",nome);
		return  (List<Telefone>) q.getResultList();
	}

	
	public List<Telefone> consultarTelefonesPorPrefixo (String prefix){		
		Query q = manager.createQuery("select t from Telefone t where t.numero like '"+ prefix +"%'");
		return  (List<Telefone>) q.getResultList();
	}
}
