package modelo;

import java.awt.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
	int IDEmprestimo;
	Pessoa p;
	Livro l; 
	LocalDateTime dataemp;
	LocalDateTime datadev;
	
	public Emprestimo(Pessoa p, Livro li, LocalDateTime datadev) {
		super();
		this.p = p;
		this.l = li;
		this.datadev = datadev;
		this.dataemp = LocalDateTime.now();
		this.IDEmprestimo += 1;
	}
	
	public Livro getLivro() {
		return l;
	}


	@Override
	public String toString() {
		return "Emprestimo [IDEmprestimo=" + IDEmprestimo + ", p=" + p + ", l=" + l + ", dataemp=" + dataemp
				+ ", datadev=" + datadev  + "]";
	}
	
}
