package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Emprestimo;

public class DAOEmprestimo extends DAO<Emprestimo>{
	 //Leitura POR nome 
    public Emprestimo read (Object chave) {
        int id = (int) chave;
        Query q = manager.query();
        q.constrain(Emprestimo.class);
        q.descend("IDEmprestimo").constrain(id);
        List<Emprestimo> resultados = q.execute();
        if (resultados.size()>0)
            return resultados.get(0);
        else
            return null;
    }
 
 
    /**********************************************************
     * 
     * TODAS AS CONSULTAS DE PESSOA
     * 
     **********************************************************/
//    public  List<Pessoa> consultarPessoasPorParteNome(String caracteres) {
//        Query q = manager.query();
//        q.constrain(Pessoa.class);
//        q.descend("nome").constrain(caracteres).like();
//        List<Pessoa> result = q.execute(); 
//        return result;
//    }

}
