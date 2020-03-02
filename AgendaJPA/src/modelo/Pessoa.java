package modelo;

/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity 
public class Pessoa {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;	
	
	//construtor vazio
	public Pessoa (){}


	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "id="+ id + "  " + String.format("%10s", nome) ;
	}

}
