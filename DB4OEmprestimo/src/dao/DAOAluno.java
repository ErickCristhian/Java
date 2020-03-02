/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.util.List;
import com.db4o.query.Query;
import modelo.Aluno;

public class DAOAluno  extends DAO<Aluno>{
	//Leitura POR nome 
	public Aluno read (Object chave) {
		String nome = (String) chave;
		Query q = manager.query();
		q.constrain(Aluno.class);
		q.descend("nome").constrain(nome);
		List<Aluno> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}

