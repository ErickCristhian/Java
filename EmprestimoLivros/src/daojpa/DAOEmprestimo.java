package daojpa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.Query;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import modelo.Emprestimo;
 
public class DAOEmprestimo extends DAO<Emprestimo> {
	
    
	public Emprestimo read(Object chave)throws Exception  {
    	try {
    		int id = (int) chave;
    		Emprestimo e;
    		Query query = manager.createQuery("SELECT e FROM Emprestimo e where e.id = " + id);
        	e = (Emprestimo) query.getSingleResult();
        	return e;
    	}catch(Exception e) {
    		return null;
    	}
    }
}
 