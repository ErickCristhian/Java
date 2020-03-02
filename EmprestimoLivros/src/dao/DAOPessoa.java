package dao;
 
import java.util.List;
 
import com.db4o.query.Query;
 
import modelo.Pessoa;
 
public class DAOPessoa  extends DAO<Pessoa>{
	
    //Leitura POR nome 
    public Pessoa read (Object chave) {
        String nome = (String) chave;
        Query q = manager.query();
        q.constrain(Pessoa.class);
        q.descend("Nome").constrain(nome);
        List<Pessoa> resultados = q.execute();
        if (resultados.size()>0) {
        	return resultados.get(0);
        }else {
            return null;
        }
    }
    
 
    /**********************************************************
     * 
     * TODAS AS CONSULTAS DE PESSOA
     * 
     **********************************************************/
    public  List<Pessoa> consultarPessoasPorParteNome(String caracteres) {
        Query q = manager.query();
        q.constrain(Pessoa.class);
        q.descend("Nome").constrain(caracteres).like();
        List<Pessoa> result = q.execute(); 
        return result;
    }
}
  