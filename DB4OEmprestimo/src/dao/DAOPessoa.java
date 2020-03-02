/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Aluno;
import modelo.Pessoa;

public class DAOPessoa  extends DAO<Pessoa>{

	//Leitura POR nome 
	public Pessoa read (Object chave) {
		String nome = (String) chave;
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("nome").constrain(nome);
		List<Pessoa> resultados = q.execute();
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
	public  List<Pessoa> consultarPessoasPorParteNome(String caracteres) {
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("nome").constrain(caracteres).like();
		List<Pessoa> result = q.execute(); 
		return result;
	}

	public List<Pessoa>  consultarPessoasNTelefones(int n) {
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.constrain(new Filtro(n));
		List<Pessoa> result = q.execute(); 
		return result;
	}

	public int consultarTotalAlunos() {
		Query q = manager.query();
		q.constrain(Aluno.class);
		int total = q.execute().size(); 
		return total;
	}

	public Pessoa consultarPessoaPorNumero(String n){
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("telefones").descend("numero").constrain(n);
		List<Pessoa> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados.get(0);

	}
	
}


/*-------------------------------------------------*/
@SuppressWarnings("serial")
class Filtro  implements Evaluation {
	private int n;
	public Filtro (int n) {this.n=n;}
	public void evaluate(Candidate candidate) {
		Pessoa p = (Pessoa) candidate.getObject();
		candidate.include( p.getTelefones().size()==n);
	}
//	private boolean compara(Pessoa p, int n) {
//		return p.getTelefones().size()==n;
//	}
}

