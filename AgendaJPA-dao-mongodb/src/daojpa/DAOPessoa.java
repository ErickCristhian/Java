/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Pessoa;
import modelo.Sexo;

public class DAOPessoa extends DAO<Pessoa>{

	public Pessoa read (Object chave){
		try{
			String nome = (String) chave;
			Query q = manager.createQuery("select p from Pessoa p where p.nome= '" + nome +"'");
			return (Pessoa) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Pessoa> readAll(){
		Query query = manager.createQuery("select p from Pessoa p order by p.nome");
		return (List<Pessoa>) query.getResultList();
	}


	//--------------------------------------------
	//  consultas
	//--------------------------------------------

	public  List<Pessoa> consultarPessoasPorParteNome(String caracteres) {
		Query q = manager.createQuery
				("select p from Pessoa p where p.nome like '%"+caracteres+"%' ");
		return(List<Pessoa>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public  List<Pessoa>  consultarPessoasNTelefones(int n) {
		Query q = manager.createQuery("select p from Pessoa p where SIZE(p.telefones)= :x");
		q.setParameter("x", n);
		return (List<Pessoa>) q.getResultList(); 
	}

	@SuppressWarnings("unchecked")
	public  Pessoa  consultarPessoaPorNumero(String numero) {
		try{
			Query q = manager.createQuery("select p from Pessoa p join p.telefones t where t.numero= :x");
			q.setParameter("x", numero);
			return (Pessoa) q.getSingleResult();			
		}catch(NoResultException e){
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarSexo (Sexo sex){		
		Query q = manager.createQuery("select p from Pessoa p where p.sexo= :x");
		q.setParameter("x",sex);
		return  q.getResultList();

	}
}

