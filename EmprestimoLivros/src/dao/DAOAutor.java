package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Autor;

public class DAOAutor extends DAO<Autor>{
	 //Leitura POR nome
	
    public Autor read (Object chave) {
        String nome = (String) chave;
        Query q = manager.query();
        q.constrain(Autor.class);
        q.descend("Nome").constrain(nome);
        List<Autor> resultados = q.execute();
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
    public  List<Autor> consultarAutorPorParteNome(String caracteres) {
        Query q = manager.query();
        q.constrain(Autor.class);
        q.descend("Nome").constrain(caracteres).like();
        List<Autor> result = q.execute(); 
        return result;
    }

}
