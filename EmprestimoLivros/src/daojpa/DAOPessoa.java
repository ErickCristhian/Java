package daojpa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.Query;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import modelo.Pessoa;
 
public class DAOPessoa extends DAO<Pessoa> {
	
    
	public  Pessoa read(Object chave) throws Exception {
    	try {
			String nome = (String) chave;
	    	Pessoa pe;
	    	Query query = manager.createQuery("SELECT e FROM Pessoa e where e.Nome = '" + nome + "'");
	        pe = (Pessoa) query.getSingleResult();
	        return pe;
    	}catch(Exception e) {
    		return null;
    	}
    }
	
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultarPessoasPorParteNome(String caracteres) throws Exception{
		try {
			List<Pessoa> p;
	    	Query q = manager.createQuery("SELECT e FROM Pessoa e where e.Nome LIKE '%" + caracteres + "%'");
	        p = q.getResultList();
	        return p;
		}catch(Exception e) {
			return null;
		}
    }
}
 