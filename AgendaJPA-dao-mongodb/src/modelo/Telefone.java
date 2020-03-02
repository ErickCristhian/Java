package modelo;


/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;


@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Telefone {
	@Id		
	@GeneratedValue
	@Field(name="_id")		//chave
	private String id;
	private String numero;	
	@Version
	private int versao;

	
	@ManyToOne
	private Pessoa pessoa;
	
	public Telefone (){}
	public Telefone(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//	--------------------RELACIONAMENTO--------------------------------
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Override
	public String toString() {
		return "Telefone [id=" + id + ", " + (numero != null ? "numero=" + numero + ", " : "")
				+ (pessoa != null ? "pessoa=" + pessoa : "") + "]";
	}



//
	
}
