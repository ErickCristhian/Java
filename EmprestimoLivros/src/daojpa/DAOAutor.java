package daojpa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.Query;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import modelo.Autor;
import modelo.Pessoa;
 
public class DAOAutor extends DAO<Autor> {
	
    
	public Autor read(Object chave)throws Exception {
    	try {
			String nome = (String) chave;
	    	Autor aut;
	    	Query query = manager.createQuery("SELECT a FROM Autor a where a.Nome = '" + nome + "'");
	        aut = (Autor) query.getSingleResult();
	        return aut;
    	}catch(Exception e) {
    		return null;
    	}
    }

	@SuppressWarnings("unchecked")
	public List<Autor> consultarAutorPorParteNome(String caracteres) throws Exception{
		try {
			List<Autor> a;
	    	Query q = manager.createQuery("SELECT a FROM Autor a where a.Nome LIKE '%" + caracteres + "%'");
	        a = q.getResultList();
	        return a;
		}catch(Exception e) {
			return null;
		}
    }
}