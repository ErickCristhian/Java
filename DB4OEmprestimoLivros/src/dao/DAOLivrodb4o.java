package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Livro;

public class DAOLivrodb4o extends DAOdb4o<Livro>{

    //Leitura POR Título 
    public Livro read (Object chave) {
        String titulo = (String) chave;
        Query q = manager.query();
        q.constrain(Livro.class);
        q.descend("Titulo").constrain(titulo);
        List<Livro> resultados = q.execute();
        if (resultados.size()>0)
            return resultados.get(0);
        else
            return null;
    }
 
 
    /**********************************************************
     * 
     * TODAS AS CONSULTAS DE LIVRO
     **********************************************************/
    public  List<Livro> consultarLivroPorParteTitulo(String caracteres) {
        Query q = manager.query();
        q.constrain(Livro.class);
        q.descend("Titulo").constrain(caracteres).like();
        List<Livro> result = q.execute(); 
        return result;
    }
}
