package daojpa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.Query;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import modelo.Livro;
 
public class DAOLivro extends DAO<Livro> {
	
    
	public Livro read(Object chave) throws Exception  {
		try {
			Livro li;
			String nome = (String) chave;
	    	Query query = manager.createQuery("SELECT livro FROM Livro livro where livro.Titulo = '" + nome + "'");
	        li = (Livro) query.getSingleResult();
	        return li;
		}catch(Exception e) {
			return null;
		}
    }
	@SuppressWarnings("unchecked")
	public  List<Livro> consultarLivroPorParteTitulo(String caracteres) {
        try {
			List<Livro> li;
	        Query query = manager.createQuery("SELECT livro from Livro livro where livro.Titulo LIKE '%"+ caracteres + "%'");
	        li = query.getResultList(); 
	        return li;
    }catch(Exception e) {
    	return null;
    }
}
        public  Livro consultarLivroPorEmprestimoErick(String CPF) {
            try {
    	        Query query = manager.createQuery("SELECT livro from Livro livro, IN(livro.emp) e where e.pessoa.CPF LIKE '%"+ CPF +"%'");
    	        return (Livro) query.getSingleResult();
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        	return null;
        }
	}
}