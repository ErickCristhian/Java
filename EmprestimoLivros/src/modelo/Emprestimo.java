package modelo;

import java.awt.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "Emprestimo")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int IDEmprestimo;
	
	@ManyToOne
	@JoinColumn(name = "Pessoa")
	Pessoa pessoa;
	
	@Transient
	private int dias_emprestimo;
	
	@ManyToOne
	@JoinColumn(name = "Livro")
	Livro livro; 
	
	@Column(columnDefinition = "TIMESTAMP")
	LocalDateTime dataemp;
	
	@Column(columnDefinition = "TIMESTAMP")
	LocalDateTime datadev;
	
	@Version
	int version;
	
	public Emprestimo() {}
	
	public Emprestimo(Pessoa p, Livro li, LocalDateTime datadev) {
		super();
		this.pessoa = p;
		this.livro = li;
		this.datadev = datadev;
		this.dataemp = LocalDateTime.now();
		this.IDEmprestimo += 1;
	}
	public int getId() {
		return IDEmprestimo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public LocalDateTime getDatadev() {
		return datadev;
	}
	public LocalDateTime getDataemp() {
		return dataemp;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setDiasEmprestimo(int i) {
		this.dias_emprestimo = i;
	}
	public void setLivro(Livro li) {
		this.livro = li;
	}
	public void removerLivro(){
        this.livro = null;
	}
	public void removerPessoa(){
        this.pessoa = null;
}

	@Override
	public String toString() {
		return "Emprestimo [IDEmprestimo=" + IDEmprestimo + ", p=" + pessoa + ", l=" + livro + ", dataemp=" + dataemp
				+ ", datadev=" + datadev  + "]";
	}
	
}
